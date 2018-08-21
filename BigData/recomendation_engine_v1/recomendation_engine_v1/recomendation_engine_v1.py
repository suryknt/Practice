# -*- coding: utf-8 -*-
"""Main module."""
from recomendation_engine_v1 import jsonProducer
from recomendation_engine_v1.mongoProducer import mongoReader

class DataStream:
    def streamDataFromJson(self,jsonFile, keyFile, count):
        reader = jsonProducer.Reader()
        reader.getStreamData(jsonFile, keyFile, count)

    def streamDataFromMongo(self,host,port,rule,db,collection):
        reader=mongoReader(host,port,rule)
        reader.streamCollection(db,collection)


