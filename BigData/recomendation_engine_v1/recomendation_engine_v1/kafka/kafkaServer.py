from subprocess import call,Popen,CREATE_NEW_CONSOLE
from sys import executable
import os

class KafkaServer:
    def __init__(self,autoMode=True,kafkaLocation=None,kafkaConfigLocation=None):
        if autoMode:
            self.kafkaLocation=kafkaLocation
            self.kafkaConfigLocation=kafkaConfigLocation

    def startKafkaServer(self):
        print("Starting Kafka Server")
        os.system("start " + self.kafkaLocation + " " + self.kafkaConfigLocation)
        # Popen([executable,script],creationflags=CREATE_NEW_CONSOLE)


if __name__=="__main__":
    ks=KafkaServer(True,"C:/kafka/kafka_2.11-1.0.0/bin/windows/kafka-server-start.bat","C:/kafka/kafka_2.11-1.0.0/config/server.properties")
    ks.startKafkaServer()
