val dottyVersion = "0.25.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "piece-tour",
    version := "0.1.0",

    scalaVersion := dottyVersion,

    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test"
  )
