from pyspark.sql import SparkSession

spark = SparkSession \
    .builder \
    .appName("myApp") \
    .config("spark.mongodb.input.uri", "mongodb://127.0.0.1/test.collwer1") \
    .config("spark.mongodb.output.uri", "mongodb://127.0.0.1/test.collwer1") \
    .getOrCreate()

logger = spark._jvm.org.apache.log4j
logger.LogManager.getRootLogger().setLevel(logger.Level.FATAL)
people = spark.createDataFrame([("Bilbo Baggins",  50), ("Gandalf", 1000), ("Thorin", 195), ("Balin", 178), ("Kili", 77),
   ("Dwalin", 169), ("Oin", 167), ("Gloin", 158), ("Fili", 82), ("Bombur", None)], ["name", "age"])

people.write.format("com.mongodb.spark.sql.DefaultSource").mode("append").save()

print("Schema:")
people.printSchema()

df = spark.read.format("com.mongodb.spark.sql.DefaultSource").load()

# # SQL
df.registerTempTable("temp")
centenarians = spark.sql("SELECT name, age FROM temp WHERE age >= 100")
print("Centenarians:")
centenarians.show()