from kafka import KafkaProducer
import time

producer = KafkaProducer(bootstrap_servers="localhost:9092")
for i in range(10):
    time.sleep(2)
    producer.send("MyFirstTopic1",str.encode("message no. "+str(i)))

producer.flush()