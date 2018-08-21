from recomendation_engine_v1.recomendation_engine_v1 import DataStream
from recomendation_engine_v1.kafka import kafkaServer
from recomendation_engine_v1.zookeeper import zookeeperServer
from recomendation_engine_v1.spark import sparkStream
import time
print("test")



zif="C:/kafka/kafka_2.11-1.0.0/bin/windows/zookeeper-server-start.bat"
zcf="C:/kafka/kafka_2.11-1.0.0/config/zookeeper.properties"
kif="C:/kafka/kafka_2.11-1.0.0/bin/windows/kafka-server-start.bat"
kcf="C:/kafka/kafka_2.11-1.0.0/config/server.properties"

# call(["echo","test-script"])
# Popen([executable,script],creationflags=CREATE_NEW_CONSOLE)
# zServer=zookeeperServer.ZookeeperServer(True,zif,zcf)
# zServer.startZookeeperServer()
# time.sleep(5)
# kServer=kafkaServer.KafkaServer(True,kif,kcf)
# kServer.startKafkaServer()
# time.sleep(7)
stream=DataStream()
jsonFile = "C:/Projects/machine_learning/Rec-Eng/train_data.json"
keyFile = "C:/Projects/machine_learning/Rec-Eng/key_X.json"
count = 522

stream.streamDataFromJson(jsonFile, keyFile, count)

