from recomendation_engine_v1 import kafkaProducer
from recomendation_engine_v1.mongo.connect import Connection
from bson.json_util import dumps
import json
import pprint

class mongoReader:
    def __init__(self,host,port,rule=None,db=None,collection=None):
        con=Connection(host,port)
        self.__producer__ = kafkaProducer.getProducer()
        self.client=con.getClient()
        self.rule=rule
        if db is not None:
            self.db = db
        if collection is not None:
            self.collection = collection
    def readJson(self,file):
        with open(file) as jdata:
            obj = json.load(jdata)
            jdata.close()
        return obj

    def streamCollection(self,db,collection):
        database=self.client[db]
        coll=database[collection]
        key=self.readJson(self.rule)
        for doc in coll.find():
            pprint.pprint(doc)
            _,_h,transObj=self.transformJson(key,doc,{})
            self.__producer__.send("engine_test",dumps(transObj))
            print('data streamed::: '+str(transObj))

    def transformJson(self,key,obj,transObject,path=""):
        print(path)
        if isinstance(obj,str) or isinstance(obj,list) or isinstance(obj,bool) or isinstance(obj,int):
            try:
                transObject[key[path]]=obj
            except KeyError:
                pass
            path=None

            return key,path,transObject
        elif isinstance(obj,dict):
            for k,v in obj.items():
                temp = path
                if path == "":
                    path=str(k)
                else:
                    path +="."+k
                key,path,transObject=self.transformJson(key,v,transObject,path)
                if path == None:
                    path=temp
            return key,path,transObject
        else:
            path=None
            return key,path,transObject
        return key,path,transObject


