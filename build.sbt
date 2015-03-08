organization := "com.allstarcvs"

name := "tbone"

version := "0.1.0-SNAPSHOT"

// scalaVersion := "2.11.5"

// exclude scala-lang dependency in pom
autoScalaLibrary := false

// disable using the Scala version in output paths and artifacts
crossPaths := false

// disable Java8 javadoc errors
javacOptions ++= Seq("-Xdoclint:none")

libraryDependencies ++= Seq(
	"org.teavm" % "teavm-classlib" % "0.2.1" % "provided",
	"org.teavm" % "teavm-jso" % "0.2.1" % "provided",
	"org.teavm" % "teavm-dom" % "0.2.1" % "provided",
	"org.teavm" % "teavm-html4j" % "0.2.1" % "provided"
)

libraryDependencies ++= Seq(
  "junit"             % "junit"           % "4.12"  % "test"
)


publishTo := {
  if (isSnapshot.value)
	Some(Resolver.file("file",  new File(Path.userHome.absolutePath+"/.m2/repository")))
  else
	Some(Resolver.file("file",  new File(Path.userHome.absolutePath+"/.m2/repository")))
}