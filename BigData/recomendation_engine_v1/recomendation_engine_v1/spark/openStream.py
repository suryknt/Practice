from recomendation_engine_v1.spark.sparkStream import SparkStream

if __name__=='__main__':
    ss=SparkStream("RecomendationTest")
    ss.recieveStream("localhost:2181","spark-twitter-stream",{"engine_test":1})
