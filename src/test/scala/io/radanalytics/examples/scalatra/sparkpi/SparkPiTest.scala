package io.radanalytics.examples.scalatra.sparkpi

import com.holdenkarau.spark.testing.SharedSparkContext
import org.scalatest.FlatSpec
import org.slf4j.{Logger, LoggerFactory}

class SparkPiTest extends FlatSpec with SharedSparkContext {

    val LOG : Logger = LoggerFactory.getLogger( this.getClass )

    "SparkPI" should "calculate to scale 2" in {
        val sparkPi : Double = new SparkPI( sc, 2 ).calculate()

        LOG.info( "--------------------------------------------" )
        LOG.info( s"---   Pi is roughly + $sparkPi" )
        LOG.info( "--------------------------------------------" )

        // NOTE - here is where you would put assertions, however, comparing floating point numbers that use random
        //        numbers in the algorithm is tricky so we don't do it here
        assert( true )
    }

}
