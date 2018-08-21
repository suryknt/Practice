from __future__ import print_function
from pyspark import SparkContext
from pyspark.streaming import StreamingContext
from pyspark.sql import SQLContext
from pyspark.sql.functions import desc
from pyspark.streaming.kafka import KafkaUtils
from collections import namedtuple
import json
import time
import sys
from pyspark.sql.types import Row
from pyspark.sql.functions import desc

sc=SparkContext(appName="RecEngIt1")
sc.setLogLevel("ERROR")
windowInterval = 10
ssc=StreamingContext(sc,windowInterval)
sqlContext = SQLContext(sc)
kafkaStream=KafkaUtils.createStream(ssc,"localhost:2181","spark-twitter-stream",{"TwitterFeed":1})
# lines = tweetDstream.window( 20 )

def extractTweetText(tweetJson,doprint=False):
    if not tweetJson:
        tweetJson=""
    if doprint:
        print("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$tweet$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$")
        print(tweetJson)
        print("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$tweet$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$")
        return tweetJson[1]
    else:
        return tweetJson[1]


print(sqlContext)
TagCount = namedtuple("TagCount", ("tag","count"))
fields = ("tag", "count" )
Tweet = namedtuple( 'Tweet', fields )

try:
    (
        kafkaStream.map(lambda tweet: extractTweetText(tweet))
            .flatMap(lambda text: text.split(" "))
            .filter(lambda word: word.lower().startswith("#"))
            .map(lambda word: (word.lower(), 1))
            .reduceByKey(lambda a, b: a + b)
            .map(lambda rec: Tweet(rec[0], rec[1]))
            .foreachRDD(lambda rdd: rdd.toDF().sort(desc("count"))
                        .limit(10).registerTempTable("tweets") if not rdd.isEmpty() else print(""))
    )
except BaseException as e:
    print("Error while processing: %s" % str(e))


ssc.start()
print(sqlContext)

count=0
while count < 100:
    time.sleep(15)
    count += 1
    try:
        top_10=sqlContext.sql("select tag, count from tweets order by count")
        for row in top_10.collect():
            print(row.tag,row["count"])
        print("-------------------------------------")
    except BaseException as e:
        print("-------No Hashtags-------")

ssc.awaitTermination()