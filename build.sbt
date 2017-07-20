
scalaVersion := "2.11.8"

name := "lrp"
organization := "edu.holycross.shot"
version := "0.0.1"
licenses += ("GPL-3.0",url("https://opensource.org/licenses/gpl-3.0.html"))
resolvers += Resolver.jcenterRepo
resolvers += Resolver.bintrayRepo("neelsmith", "maven")

resolvers += "beta" at "http://beta.hpcc.uh.edu/nexus/content/repositories/releases"
libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.1" % "test",
  "edu.holycross.shot" %% "greek" % "1.3.0",
  "edu.holycross.shot" %% "ohco2" % "9.3.1",
  "edu.holycross.shot.cite" %% "xcite" % "2.6.0",
  "edu.holycross.shot" %% "gsphone" % "1.0.1"
)
