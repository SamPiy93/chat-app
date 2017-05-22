name := """gradchat-backend"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava,PlayEnhancer,PlayEbean)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  filters,
  "org.mockito" % "mockito-all" % "1.10.19",
  "org.powermock" % "powermock-mockito-release-full" % "1.6.4",
  "org.apache.httpcomponents" % "httpclient" % "4.5.2",
  "org.apache.httpcomponents" % "httpcore" % "4.4.4",
  "org.apache.httpcomponents" % "httpmime" % "4.3.1"
)
