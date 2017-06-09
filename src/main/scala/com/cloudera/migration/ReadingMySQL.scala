package com.cloudera.migration

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by aditya on 6/8/2017.
  */
object ReadingMySQL {

  val conf = new SparkConf()
    .setAppName("ReadingMySQL")

  val sc = new SparkContext(conf)

  val sqlContext = new SQLContext(sc)

  val data = sqlContext.read.format("jdbc").option("url","jdbc:mysql://localhost/retail_db").option("driver","com.mysql.jdbc.Driver").option("dbtable", "products").option("user", "root").option("password", "cloudera").load()

}
