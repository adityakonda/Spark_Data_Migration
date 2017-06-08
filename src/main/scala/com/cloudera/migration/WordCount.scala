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

    val textFile = sc.parallelize(Seq("this is first line", "This is second line", "This is third line"))

    val counts = textFile.flatMap(line => line.split(" "))
      .map(word => (word, 1))
      .reduceByKey(_ + _)

    counts.foreach(println)
  }
}
