import json
from copy import deepcopy
import numpy as np
from kafka import KafkaProducer
import time

train_obj={}
key_x={}
sku_count=522
with open("C:/Projects/machine_learning/Rec-Eng/Kafka_poc/Receng/train_data.json") as jdata:
    train_obj=json.load(jdata)
    jdata.close()
with open("C:/Projects/machine_learning/Rec-Eng/Kafka_poc/Receng/key_x.json") as jdata:
    key_x=json.load(jdata)
    jdata.close()
# print(train_obj)
n=len(key_x)+1

print("n::::"+str(n))
producer = KafkaProducer(bootstrap_servers="localhost:9092",value_serializer=lambda v: json.dumps(v).encode('utf-8'))

train_X=np.zeros((1,n))
train_Y=np.zeros((sku_count,1))
# def assign_X(vector,key):
#     vector[key_x[key]]
#     return vector
vector=np.zeros((1,n))

def populate(obj,vector,train_X,train_Y):
    # print("obj:::::"+str(obj))
    # print("train_X::::"+str(train_X))
    # print("vector::::"+str(vector))
    if obj["leaf"]:
        arr=obj["prods"]
        vector_y=np.zeros((sku_count,1))
        for i in arr:
            count=0
            for j in i:
                # print("j::"+str(j))
                # print(vector_y)
                # print("j::::::"+str(j))
                vector_y[j,0]=100-count
                count+=1
                producer.send("engine_test", json.dumps({"vector_x":vector.tolist(),"vector_y":vector_y.tolist()}))
                # time.sleep(1)
                print("sending vector_x::"+str(vector))
                print("sending vector_y:::"+str(vector_y[j,:]))
        train_X=np.vstack([train_X, vector])
        train_Y=np.hstack([train_Y, vector_y])
        # print("train_X:::stack:::" + str(train_X))
        return train_X,train_Y
        # print("train_X::::"+str(train_X))
    else:
        next_qs=obj['qs']
        for i in next_qs:
            temp = deepcopy(vector)
            # print("i::"+str(i)+"key_x[i]:::"+str(key_x[i]))
            vector[0,key_x[i]]=1
            train_X,train_Y=populate(obj[i],vector,train_X,train_Y)
            # print("train_X::::2::::::::" + str(train_X))
            vector=temp
    return train_X,train_Y



x,y=populate(train_obj,vector,train_X,train_Y)
print(x)
print(y)
producer.flush()