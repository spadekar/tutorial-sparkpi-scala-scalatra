package io.radanalytics.examples.scalatra.sparkpi

import org.scalatra.{Ok, ScalatraServlet}

class SparkPiServlet extends ScalatraServlet {
    //@formatter:off
    get( "/sparkpi" ) {
        Ok( "michael" )
    }
    //@formatter:on
}