from recomendation_engine_v1.ingestion_engine.main_ingestion_engine import MainIngestionEngine

class MyDataIngestor(MainIngestionEngine):
    def __init__(self):
        pass

    # def streamDataFromJson(self):
    #     pass

if __name__=="__main__":
    mdi = MyDataIngestor()

    configRule="dataTransformConfig.json"
    mdi.readConfig(configRule)
    mdi.callRule()
    # mdi.dataIngestionMongo("localhost",27017,configRule,"Morph_Bayer_Coppertone_Production_db","user_activity_collection")
