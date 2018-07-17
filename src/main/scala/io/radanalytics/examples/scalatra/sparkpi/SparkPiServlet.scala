package io.radanalytics.examples.scalatra.sparkpi

import org.apache.spark.{SparkConf, SparkContext}
import org.scalatra.{Ok, ScalatraServlet}

class SparkPiServlet extends ScalatraServlet {
    get( "/sparkpi" ) {
        val scale : Int = if( params("scale") != null ) Integer.parseInt(params("scale") ) else 2
        val spark = new SparkContext( new SparkConf().setAppName( "Radanalytics IO SparkPI Scalatra Tutorial" ) )
        val sparkPi = new SparkPI( spark, scale ).calculate()
        spark.stop()
        Ok( "Pi is roughly " + sparkPi )
    }
}