from recomendation_engine_v1.kafka import kafkaServer
from recomendation_engine_v1.zookeeper import zookeeperServer
import time
import os

zif="C:/kafka/kafka_2.11-1.0.0/bin/windows/zookeeper-server-start.bat"
zcf="C:/kafka/kafka_2.11-1.0.0/config/zookeeper.properties"
kif="C:/kafka/kafka_2.11-1.0.0/bin/windows/kafka-server-start.bat"
kcf="C:/kafka/kafka_2.11-1.0.0/config/server.properties"

zServer=zookeeperServer.ZookeeperServer(True,zif,zcf)
zServer.startZookeeperServer()
time.sleep(5)
kServer=kafkaServer.KafkaServer(True,kif,kcf)
kServer.startKafkaServer()
time.sleep(7)
os.system("start spark-submit --packages org.apache.spark:spark-streaming-kafka-0-8_2.11:2.0.2 recommendation_engine_v1/spark/openStream.py")


