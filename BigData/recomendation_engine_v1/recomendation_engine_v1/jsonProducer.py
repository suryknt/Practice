import json
import numpy as np
from copy import deepcopy
from recomendation_engine_v1 import kafkaProducer
import time
from .util.jsonReader import JsonReader

class Reader(JsonReader):
    def __init__(self):
        self.__producer__=kafkaProducer.getProducer()

    def getFeatures(self,obj,vector,key_x,train_X,train_Y,prod_count):
        if obj["leaf"]:
            arr = obj["prods"]
            vector_y = np.zeros((prod_count, 1))
            for i in arr:
                count = 0
                for j in i:
                    vector_y[j, 0] = 100 - count
                    count += 1
                    self.__producer__.send("engine_test", json.dumps({"vector_x":vector.tolist(),"vector_y":vector_y.tolist()}))
                    time.sleep(1)
                    print("sending vector_x::" + str(vector))
                    print("sending vector_y:::" + str(vector_y[j, :]))
            train_X = np.vstack([train_X, vector])
            train_Y = np.hstack([train_Y, vector_y])
            # print("train_X:::stack:::" + str(train_X))
            return train_X, train_Y
            # print("train_X::::"+str(train_X))
        else:
            next_qs = obj['qs']
            for i in next_qs:
                temp = deepcopy(vector)
                # print("i::"+str(i)+"key_x[i]:::"+str(key_x[i]))
                vector[0, key_x[i]] = 1
                train_X, train_Y = self.getFeatures(obj=obj[i],key_x=key_x, vector=vector, train_X=train_X, train_Y=train_Y,prod_count=prod_count)
                # print("train_X::::2::::::::" + str(train_X))
                vector = temp
        return train_X, train_Y

    def getStreamData(self,jsonFile,keyFile,count):
        obj=self.readJson(jsonFile)
        key_x=self.readJson(keyFile)
        n = len(key_x) + 1
        print("n::::" + str(n))
        train_X = np.zeros((1, n))
        train_Y = np.zeros((count, 1))
        vector = np.zeros((1, n))
        return self.getFeatures(obj,vector,key_x,train_X,train_Y,count)


