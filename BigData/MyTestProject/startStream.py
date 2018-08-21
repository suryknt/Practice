from recomendation_engine_v1.recomendation_engine_v1 import DataStream

class MyDataIngestor(DataStream):
    def __init__(self):
        pass

    # def streamDataFromJson(self):
    #     pass

if __name__=="__main__":
    mdi = MyDataIngestor()
    # jsonFile = "C:/Projects/machine_learning/Rec-Eng/train_data.json"
    # keyFile = "C:/Projects/machine_learning/Rec-Eng/key_X.json"
    # count = 522

    # mdi.streamDataFromJson(jsonFile, keyFile, count)
    configRule="C:\Projects\machine_learning\Rec-Eng\MyTestProject\collection_transform.json"
    mdi.streamDataFromMongo("localhost",27017,configRule,"Morph_Bayer_Coppertone_Production_db","user_activity_collection")
