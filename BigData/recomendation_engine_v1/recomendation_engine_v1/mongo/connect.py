from pymongo import MongoClient


class Connection:
    def __init__(self,host,port):
        self.host=host
        self.port=port
        self.client=MongoClient(self.host,self.port)

    def getClient(self):
        return self.client


