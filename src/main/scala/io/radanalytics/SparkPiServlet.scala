package io.radanalytics

import org.scalatra.{Ok, ScalatraServlet}

class SparkPiServlet extends ScalatraServlet {
    get( "/" ) {
        Ok( "michael" )
    }
}