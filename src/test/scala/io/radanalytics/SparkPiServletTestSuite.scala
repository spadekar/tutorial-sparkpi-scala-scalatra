package io.radanalytics

import org.scalatest.FlatSpecLike
import org.scalatra.test.scalatest.ScalatraSuite

class SparkPiServletTestSuite extends ScalatraSuite with FlatSpecLike {

    addServlet( classOf[ SparkPiServlet ], "/*" )

    "Get request" should "return http ok for now" in {
        //@formatter:off
        get( "/" ) {
            status should equal( 200 )
            body should equal( "michael" )
        }
        //@formatter:on
    }
}
