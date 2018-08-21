from ..kafka import kafkaServer
from ..zookeeper import zookeeperServer
import time
import os

class Initializer:
    def __init__(self,kcf,zcf):
        self.zif = "C:/kafka/kafka_2.11-1.0.0/bin/windows/zookeeper-server-start.bat"
        self.zcf = zcf
        self.kif = "C:/kafka/kafka_2.11-1.0.0/bin/windows/kafka-server-start.bat"
        self.kcf = kcf

    def applyServerMode(self,autoMode=True):
        self.zServer = zookeeperServer.ZookeeperServer(autoMode, self.zif, self.zcf)
        self.kServer = kafkaServer.KafkaServer(autoMode, self.kif, self.kcf)

    def initialize(self):
        self.zServer.startZookeeperServer()
        time.sleep(5)
        self.kServer.startKafkaServer()
        time.sleep(7)
        filePath="C:/Projects/machine_learning/Rec-Eng/recomendation_engine_v1/recomendation_engine_v1/spark"
        os.system(
            "start spark-submit --packages org.apache.spark:spark-streaming-kafka-0-8_2.11:2.0.2 "+filePath+"/openStream.py")
        # Popen([executable, openStream], creationflags=CREATE_NEW_CONSOLE)


