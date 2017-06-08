package com.cloudera.migration

import org.apache.spark.{SparkConf, SparkContext}

 /*
  * Created by aditya on 6/7/2017.
  */

object WordCount {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf()
      .setAppName("WordCount")

    val sc = new SparkContext(conf)

    //val textFile = sc.textFile("file:///home/cloudera/aditya/ReadFile.txt") // Reading a text file from Local Environment
    val textFile =  sc.textFile("hdfs:///user/aditya/files/ReadFile.txt")

    val counts = textFile.flatMap(line => line.split(" "))
      .map(word => (word, 1))
      .reduceByKey(_ + _)

    counts.foreach(println)
  }
}
