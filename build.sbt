name := "$name$"

version := "0.1"

organization := "$organization$"

scalaVersion := "2.9.1"

seq(webSettings :_*)

resolvers ++= Seq("snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
                  "releases"  at "http://oss.sonatype.org/content/repositories/releases")

libraryDependencies ++= {
  val liftVersion = "$lift_version$"
  Seq(
  "net.liftweb" %% "lift-webkit" % liftVersion % "compile",
  "org.eclipse.jetty" % "jetty-webapp" % "8.0.1.v20110908" % "container",
  "com.h2database" % "h2" % "1.2.138",
  "org.specs2" %% "specs2" % "1.10" % "test",
  "ch.qos.logback" % "logback-classic" % "0.9.26"
  )
}

// append -deprecation to the options passed to the Scala compiler
scalacOptions += "-deprecation"
