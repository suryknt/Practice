from .connect_to_stream import ConnectToStream
from pyspark.sql.functions import desc
from pyspark.streaming.kafka import KafkaUtils
import time

class SystemIntellegence:

    def __init__(self,context,windowInterval):
        self.contextName=context
        self.windowInterval=windowInterval

    def recieveStream(self,uri,stream,topicObj,config):
        spark = ConnectToStream(self.contextName,self.windowInterval)
        self.kafkaStream = KafkaUtils.createStream(spark.getStreamContext(), uri, stream, topicObj)
        try:
            (
               self.transform(config)
            )
        except BaseException as e:
            print("Error while processing: %s" % str(e))

        self.ssc.start()

    def transform(self,config):
        # perform data transformations
        self.kafkaStream.map(lambda data: self.printData(data)) \
            .foreachRDD(lambda rdd: rdd.toDF().registerTempTable("StreamData") if not rdd.isEmpty() else print(""))

    def analyzeData(self):
        pass

    def saveDataToDB(self):
        pass


    def trainModel(self):
        pass



