import sbt._

object Dependencies {

    val slf4jVersion = "1.7.5"
    val logbackVersion = "1.2.3"
    val sparkVersion = "2.3.0"
    val scalaTestVersion = "3.0.4"
    val scalatraVersion = "2.5.4"
    val jettyWebappVersion = "9.2.19.v20160908"
    val servletApiVersion = "3.1.0"
    val sparkTestBaseVersion = "2.2.0_0.8.0"

    val slf4j = Seq( "org.slf4j" % "slf4j-api" % slf4jVersion )

    val logback = Seq( "ch.qos.logback" % "logback-classic" % logbackVersion )

    val scalaTest = Seq( "org.scalatest" %% "scalatest" % scalaTestVersion % "test" )

    // TODO - fix versions later
    val scalatra = Seq( "org.scalatra" %% "scalatra" % scalatraVersion,
                        "org.scalatra" %% "scalatra-scalatest" % scalatraVersion % "test",
                        "org.eclipse.jetty" % "jetty-webapp" % jettyWebappVersion,
                        "javax.servlet" % "javax.servlet-api" % servletApiVersion )

    val spark = Seq( "org.apache.spark" %% "spark-core" % sparkVersion % "provided",
                     "org.apache.spark" %% "spark-sql" % sparkVersion % "provided",
                     "org.mongodb.spark" %% "mongo-spark-connector" % "2.3.3")

    val sparkTestBase = Seq( "com.holdenkarau" %% "spark-testing-base" % sparkTestBaseVersion % "test" )


}