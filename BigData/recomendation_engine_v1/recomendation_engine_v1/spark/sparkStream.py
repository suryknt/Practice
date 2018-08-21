from __future__ import print_function
from pyspark import SparkContext
from pyspark.streaming import StreamingContext
from pyspark.sql import SQLContext
from pyspark.sql import SparkSession
# from pyspark.sql.functions import desc
from pyspark.streaming.kafka import KafkaUtils
import time


class SparkStream:
    def __init__(self,name):
        self.spark = SparkSession.builder \
                    .appName(name).getOrCreate()
        self.sc = self.spark.sparkContext
        logger = self.sc._jvm.org.apache.log4j
        logger.LogManager.getRootLogger().setLevel(logger.Level.FATAL)
        self.windowInterval = 10
        self.ssc = StreamingContext(self.sc, self.windowInterval)
        self.sqlContext = SQLContext(self.sc)

    def recieveStream(self,uri,stream,topicObj):
        self.kafkaStream=KafkaUtils.createStream(self.ssc,uri,stream,topicObj)
        try:
            (
                self.kafkaStream.map(lambda data: self.printData(data))
                    .foreachRDD(lambda rdd: rdd.toDF().registerTempTable("StreamData") if not rdd.isEmpty() else print(""))
            )
        except BaseException as e:
            print("Error while processing: %s" % str(e))

        self.ssc.start()
        count = 0
        while count < 100:
            time.sleep(15)
            count += 1
            try:
                top_10 = self.sqlContext.sql("select * from StreamData")
                for row in top_10.collect():
                    print(str(row))
                print("-------------------------------------")
            except BaseException as e:
                print("Error while processing: %s" % str(e))
        self.ssc.awaitTermination()

    def printData(self,data):
        print(str(data))


