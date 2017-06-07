package com.datafactz.test

import org.apache.spark.{SparkConf, SparkContext}

 /*
  * Created by aditya on 6/7/2017.
  */

object ReadFile {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf()
      .setAppName("WordCount")

    val sc = new SparkContext(conf)

    val textFile = sc.parallelize(Seq("this is first line", "This is second line", "This is third line"))

    val counts = textFile.flatMap(line => line.split(" "))
      .map(word => (word, 1))
      .reduceByKey(_ + _)

    counts.foreach(println)
  }

  /*spark-submit --master local[*] --class com.datafactz.test.ReadFile ~/spark_data_migration_2.11-1.0.jar*/
}
