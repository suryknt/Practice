import json

class JsonReader:
    def __init__(self):
        pass

    def readJson(self,file):
        with open(file) as jdata:
            obj = json.load(jdata)
            jdata.close()
        return obj
