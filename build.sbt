import sbt._
import Dependencies._

organization := "io.radanalytics"
name := "tutorial-sparkpi-scala-scalatra"
version := "0.0.1-SNAPSHOT"
scalaVersion in ThisBuild := "2.11.11"

resolvers += Resolver.sbtPluginRepo( "releases" )
resolvers += Classpaths.typesafeReleases
resolvers in ThisBuild ++= Seq( "Sonatype releases" at "https://oss.sonatype.org/content/repositories/releases",
                                "Spray IO Repository" at "http://repo.spray.io/",
                                "Maven Central" at "https://repo1.maven.org/maven2/",
                                "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/" )

mainClass in(Compile, run) := Some( "io.radanalytics.examples.scalatra.sparkpi.Main" )

enablePlugins( JavaAppPackaging )
enablePlugins( ScalatraPlugin )

// see project/Dependencies.scala for dependency management
libraryDependencies ++= slf4j ++ logback ++ scalatra ++ scalaTest ++ spark ++ sparkTestBase


// don't run tests when build the fat jar, use sbt test instead for that (takes too long when building the image)
test in assembly := {}

assemblyMergeStrategy in assembly := {
    case PathList( "META-INF", "MANIFEST.MF" ) => MergeStrategy.discard
    case PathList( "reference.conf" ) => MergeStrategy.concat
    case x => MergeStrategy.last
}