name := "$name$"

version := "0.0.1"

organization := "$package$"

scalaVersion := "2.11.6"

resolvers ++= Seq("snapshots"     at "http://oss.sonatype.org/content/repositories/snapshots",
                "releases"        at "http://oss.sonatype.org/content/repositories/releases"
                )

seq(com.earldouglas.xsbtwebplugin.WebPlugin.webSettings: _*)

scalacOptions ++= Seq("-deprecation", "-unchecked")

libraryDependencies ++= {
    val liftVersion = "$lift_version$"
    Seq(
        "net.liftweb"  %% "lift-webkit" % liftVersion % "compile",
        "net.liftmodules" % ("lift-jquery-module_" + liftVersion + "_2.11") % "2.9",
        "org.eclipse.jetty" % "jetty-webapp"        % "8.1.7.v20120910"  % "container,compile,test",
        "org.eclipse.jetty.orbit" % "javax.servlet" % "3.0.0.v201112011016" % "container,compile,test" artifacts Artifact("javax.servlet", "jar", "jar"),
        "ch.qos.logback"    % "logback-classic"     % "1.0.13"
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
