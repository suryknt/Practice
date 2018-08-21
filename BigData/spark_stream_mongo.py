from __future__ import print_function
from pyspark import SparkContext
from pyspark.streaming import StreamingContext
from pyspark.sql import SQLContext
from pyspark.sql.functions import desc
from pyspark.sql import SparkSession
from collections import namedtuple
import datetime
import time

spark = SparkSession \
    .builder \
    .appName("MyTwitterCount") \
    .config("spark.mongodb.input.uri", "mongodb://127.0.0.1/test.hashtagbank") \
    .config("spark.mongodb.output.uri", "mongodb://127.0.0.1/test.hashtagbank") \
    .getOrCreate()

sc=spark.sparkContext
# sc.setLogLevel("ERROR")
logger = sc._jvm.org.apache.log4j
logger.LogManager.getRootLogger().setLevel(logger.Level.FATAL)
windowInterval = 8
ssc=StreamingContext(sc,windowInterval)
sqlContext = SQLContext(sc)
# ssc.checkpoint( "C:/Projects/machine_learning/Rec-Eng/checkpoint")
tweetDstream=ssc.socketTextStream("172.16.99.228",5555)

# lines = tweetDstream.window( 20 )

def extractTweetText(tweetJson,doprint=False):
    if not tweetJson:
        tweetJson=""
    if doprint:
        print("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$tweet$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$")
        print(tweetJson)
        print("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$tweet$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$")
        return tweetJson
    else:
        return tweetJson


print(sqlContext)
TagCount = namedtuple("TagCount", ("tag","count"))
fields = ("tag", "count" )
Tweet = namedtuple( 'Tweet', fields )

try:
    (
        tweetDstream.map(lambda tweet: extractTweetText(tweet))
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
time.sleep(60)
count=0
while count < 100:
    print("Waiting for tweets to be aggregated")
    time.sleep(12)
    print("tweets aggregated")
    count += 1
    try:
        top_10=sqlContext.sql("select tag, count from tweets order by count")
        top_10.write.format("com.mongodb.spark.sql.DefaultSource").mode("append").save()
        for row in top_10.collect():
            print(row.tag.encode("utf-8"),row["count"])
        print("-------------------------------------")
    except BaseException as e:
        print(str(count)+"-------No Hashtags-------"+str(e))

ssc.awaitTermination()