package io.radanalytics.examples.scalatra.sparkpi

import org.apache.spark.SparkContext
import java.math.BigDecimal
import scala.math.random

class SparkPI( spark : SparkContext, scale : Int ) {

    val applicationName = "Spark PI Scalatra Tutorial"

    def calculate( ) : Double = {
        val n = math.min( 100000L * scale, Int.MaxValue ).toInt // avoid overflow
        val count = spark.parallelize( 1 until n, scale ).map( i => {
            val x = random
            val y = random
            if ( x * x + y * y < 1 ) 1 else 0
        } ).reduce( _ + _ )
        4.0 * count / ( n - 1 )
    }

}
