import json
from kafka import KafkaProducer

def getProducer():
    return KafkaProducer(bootstrap_servers="localhost:9092",value_serializer=lambda v: json.dumps(v).encode('utf-8'))



