package io.radanalytics.examples.scalatra.sparkpi

import org.apache.spark.SparkContext
import org.apache.spark.sql.{SQLContext, SparkSession}

import scala.math.random

class FeatureProcessing(spark : SparkSession) {
  def processFeatures(inputFeatures:String,transformations:String,datasetName:String) : String = {
    val uri: String = s"mongodb://mongouser:mongouser@mongodb/sampledb"
    // This piece is used for data loading in mongodb
    // val df = spark.read.format("csv").option("header","true").option("inferSchema","true").load("C:\\data\\apps\\projects\\datamicroservices\\openshift_spark\\src\\main\\resources\\WAFnUseCTelcoCustomerChurn.csv")
    // MongoSpark.save(df.write.option("collection", "churn_data").mode("overwrite"))
    //val spark = SparkSession.builder.master("spark://172.18.91.49:7077").config(sc.getConf).getOrCreate()
    val dfRead = spark.read.format("mongo").option("uri", "mongodb://mongouser:mongouser@mongodb/sampledb.churn_data").load()
    dfRead.select("customerID","gender")
    val sampleDf = dfRead.takeAsList(10).toString()
    //val readConfig = ReadConfig(Map("collection" -> "churn_data", Some(ReadConfig(spark)))
    //val customRdd = MongoSpark.load(spark readConfig)
    sampleDf
  }
}