from recomendation_engine_v1.kafka import kafkaServer
from recomendation_engine_v1.zookeeper import zookeeperServer
from sys import executable
from subprocess import Popen, CREATE_NEW_CONSOLE
from recomendation_engine_v1.spark import openStream
import time
import os

class Initializer:
    def __init__(self,kcf,zcf):
        self.zif = "C:/kafka/kafka_2.11-1.0.0/bin/windows/zookeeper-server-start.bat"
        self.zcf = zcf
        self.kif = "C:/kafka/kafka_2.11-1.0.0/bin/windows/kafka-server-start.bat"
        self.kcf = kcf

        self.zServer = zookeeperServer.ZookeeperServer(True, self.zif, self.zcf)

        self.kServer = kafkaServer.KafkaServer(True, self.kif, self.kcf)

    def initialize(self):
        self.zServer.startZookeeperServer()
        time.sleep(5)
        self.kServer.startKafkaServer()
        time.sleep(7)
        filePath="C:/Projects/machine_learning/Rec-Eng/recomendation_engine_v1/recomendation_engine_v1/spark"
        os.system(
            "start spark-submit --packages org.apache.spark:spark-streaming-kafka-0-8_2.11:2.0.2 "+filePath+"/openStream.py")
        # Popen([executable, openStream], creationflags=CREATE_NEW_CONSOLE)

