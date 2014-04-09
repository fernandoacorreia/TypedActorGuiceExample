name := "TypedActorGuiceExample"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  "com.google.inject" % "guice" % "4.0-beta",
  "net.codingwell" %% "scala-guice" % "4.0.0-beta"
)

play.Project.playScalaSettings

com.jamesward.play.BrowserNotifierPlugin.livereload
