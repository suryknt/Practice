from __future__ import print_function
from pyspark.streaming import StreamingContext
from pyspark.sql import SQLContext
from pyspark.sql import SparkSession


class ConnectToStream:
    def __init__(self,name,windowInterval):
        self.__spark__ = SparkSession.builder.appName(name).getOrCreate()
        self.__sc__ = self.__spark__.sparkContext
        logger = self.__sc__._jvm.org.apache.log4j
        logger.LogManager.getRootLogger().setLevel(logger.Level.FATAL)
        self.__ssc__ = StreamingContext(self.sc, windowInterval)
        self.__sqlContext__ = SQLContext(self.sc)

    def getSparkSession(self):
        return self.__spark__

    def getContext(self):
        return self.__sc__

    def getStreamContext(self):
        return self.__ssc__

    def getSqlContext(self):
        return self.__sqlContext__

