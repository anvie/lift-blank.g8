name := "$name$"

version := "0.0.1"

organization := "$package$"

scalaVersion := "2.9.1"

resolvers ++= Seq(
  "snapshots"     at "http://oss.sonatype.org/content/repositories/snapshots",
  "releases"      at "http://oss.sonatype.org/content/repositories/releases",
  "Sonatype Releases" at "https://oss.sonatype.org/content/groups/scala-tools",
  "typesafe repo"   at "http://repo.typesafe.com/typesafe/releases",
  "Ansvia release repo" at "http://scala.repo.ansvia.com/releases",
  "Ansvia snapshot repo" at "http://scala.repo.ansvia.com/nexus/content/repositories/snapshots"
)

seq(com.github.siasia.WebPlugin.webSettings :_*)

scalacOptions ++= Seq("-deprecation", "-unchecked")

libraryDependencies ++= {
  val liftVersion = "$lift_version$"
  Seq(
    "net.liftweb"       %% "lift-webkit"        % liftVersion        % "compile",
    "net.liftmodules" %% ("lift-jquery-module_" + liftVersion) % "2.4",
    "org.eclipse.jetty" % "jetty-webapp"        % "7.5.4.v20111024"  % "container; test",
    "ch.qos.logback"    % "logback-classic"     % "1.0.13",
    "org.specs2"        %% "specs2"             % "1.12.4"             % "test"
  )
}

publishTo <<= version { (v:String) =>
    val ansviaRepo = "http://scala.repo.ansvia.com/nexus"
    if(v.trim.endsWith("SNAPSHOT"))
        Some("snapshots" at ansviaRepo + "/content/repositories/snapshots")
    else
        Some("releases" at ansviaRepo + "/content/repositories/releases")
}

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

crossPaths := false

