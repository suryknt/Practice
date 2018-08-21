from subprocess import call,Popen,CREATE_NEW_CONSOLE
from sys import executable
import os

class ZookeeperServer:
    def __init__(self,autoMode=True,zookeeperLocation=None,zookeeperConfigLocation=None):
        if autoMode:
            self.zookeeperLocation=zookeeperLocation
            self.zookeeperConfigLocation=zookeeperConfigLocation

    def startZookeeperServer(self):
        print("Starting Zookeeper server...")
        os.system("start "+self.zookeeperLocation+" "+self.zookeeperConfigLocation)
        # Popen([executable,script],creationflags=CREATE_NEW_CONSOLE)


if __name__=="__main__":
    ks=ZookeeperServer(True,"C:/kafka/kafka_2.11-1.0.0/bin/windows/zookeeper-server-start.bat","C:/kafka/kafka_2.11-1.0.0/config/zookeeper.properties")
    ks.startZookeeperServer()
