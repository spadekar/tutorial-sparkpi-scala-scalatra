package io.radanalytics.examples.scalatra.sparkpi

import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.DefaultServlet
import org.eclipse.jetty.webapp.WebAppContext
import org.scalatra.servlet.ScalatraListener

object Main {

    def main( args : Array[ String ] ) : Unit = {
        val port = 8080 //TODO - do I need to make the port configurable/dynamic?
        val server = new Server( port )
        val context = new WebAppContext()

        context.setContextPath( "/" )
        context.setResourceBase( "src/main/webapp" )
        context.setInitParameter( ScalatraListener.LifeCycleKey, "io.radanalytics.examples.scalatra.sparkpi.ScalatraInit" ) // scalatra uses some magic defaults I don't like
        context.addEventListener( new ScalatraListener )
        context.addServlet( classOf[ DefaultServlet ], "/" )

        server.setHandler( context )

        server.start()
        server.join()
    }

}
