from pymongo import MongoClient
from ..database_conversion_rule import DatabaseConversionRule
from ..data_train_mapping_rule import DataTrainMapping
import json
import pprint


class MongoDriver(DatabaseConversionRule):

    def __init__(self,host,port):
        super().__init__()
        self.host=host
        self.port=port
        self.mapper=DataTrainMapping()

    def applyRule(self, rule):
        self.rule = rule

    def connectToDB(self):
        self.client = MongoClient(self.host, self.port)

    def readJson(self, file):
        with open(file) as jdata:
            obj = json.load(jdata)
            jdata.close()
        return obj

    def readData(self, db, collection,key,dataSourceQuery):
        database = self.client[db]
        coll = database[collection]
        print("coll")
        for doc in coll.find(dataSourceQuery):
            pprint.pprint(doc)
            _, _h, transObj = self.mapper.applyTransformation(key, doc, {})
            self.streamData(transObj)
            print('data streamed::: ' + str(transObj))


