from recomendation_engine_v1.initialization_engine.main_initializer import Initializer


kcf = "C:/kafka/kafka_2.11-1.0.0/config/server.properties"
zcf = "C:/kafka/kafka_2.11-1.0.0/config/zookeeper.properties"

ini=Initializer(kcf=kcf,zcf=zcf)
ini.applyServerMode(autoMode=True)
ini.initialize()