import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

    val appName         = "requests"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      "de.undercouch" % "bson4jackson" % "2.1.0" force(),
 	  "com.fasterxml.jackson.core" % "jackson-databind" % "2.1.0" force(),
  	  "com.fasterxml.jackson.core" % "jackson-annotations" % "2.1.0" force(),
  	  "com.fasterxml.jackson.core" % "jackson-core" % "2.1.0" force(),
  	  "org.mongodb" % "mongo-java-driver" % "2.11.3",
  	  "org.jongo" % "jongo" % "0.4",
  	  "uk.co.panaxiom" %% "play-jongo" % "0.6.0-jongo0.4"
    )

    val main = play.Project(appName, appVersion, appDependencies).settings(
      // Add your own project settings here      
    )

}