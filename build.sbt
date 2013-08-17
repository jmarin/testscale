organization := "org.scale"

version := "1.0-SNAPSHOT"

scalaVersion := "2.10.2"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

resolvers ++= Seq(
  "spray repo" at "http://nightlies.spray.io"
)

libraryDependencies ++=Seq(
  "io.spray"            %   "spray-can"     % "1.2-20130801",
  "io.spray"            %   "spray-routing" % "1.2-20130801",
  "io.spray"            %   "spray-testkit" % "1.2-20130801" % "test",
  "com.typesafe.akka"   %%  "akka-actor"    % "2.2.0",
  "com.typesafe.akka"   %%  "akka-testkit"  % "2.2.0" % "test",
  "org.specs2"          %%  "specs2"        % "2.1.1" % "test"
)
