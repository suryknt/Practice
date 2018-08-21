# -*- coding: utf-8 -*-
from .nosql_database_conversion.mongo_driver import MongoDriver
from ..util.jsonReader import JsonReader


class MainIngestionEngine(JsonReader):

    def __init__(self):
        pass

    def readConfig(self,configRule):
        self.__rule__=self.readJson(configRule)

    def callRule(self):
        print("1:::"+str(self.__rule__['dataSource']))
        self.__datasource__ = self.__rule__['dataSource']
        print("2:::"+str(self.__datasource__))
        self.callMethod(self.__datasource__)

    def callMethod(self,source):
        method_name = "ingestFrom" + str(source)
        print("3:::"+str(method_name))
        method = getattr(self, method_name, lambda: "invalid attribute!!")
        return method()

    def ingestFromdb(self):
        try:
            self.__db__=self.__rule__['db']
            print("4:::"+str(self.__db__['dbPlatform']))
            method_name = "ingestFrom" + str(self.__db__['dbPlatform'])
            method = getattr(self, method_name, lambda: "invalid attribute!!")
            return method()
        except KeyError:
            print("Problem with config rule file")

    def ingestFromMongoDB(self):
        try:
            mongoHost=self.__db__['host']
            mongoPort=self.__db__['port']
            mongoDBname=self.__db__['dbName']
            mongoCollectionName=self.__db__['collectionName']
            mongoTransformRule=self.__rule__['transformationRule']
            dataSourceQuery=self.__db__['dataSourceQuery']
            print("5:: dataSourceQuery "+str(dataSourceQuery))
            driver = MongoDriver(mongoHost, mongoPort)
            driver.applyRule(mongoTransformRule)
            driver.connectToDB()
            driver.readData (mongoDBname, mongoCollectionName,mongoTransformRule,dataSourceQuery)

        except KeyError:
            print("problem with config file rule::: ")



