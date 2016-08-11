import sbt._
import sbt.Keys._

object Build extends Build {

  lazy val commonSettings = Seq(
    scalaVersion:= "2.11.7"
  )

  lazy val chiselSettings = Seq(
    libraryDependencies += "edu.berkeley.cs" %% "chisel" % "latest.release"
  )

  lazy val root = Project("AXI-in-Chisel", file("."))
    .settings(commonSettings: _*)
    .settings(
      name := "AXI in Chisel",
      version := "0.1"
    )
    .dependsOn(
      examples
    )

  lazy val axi = Project("AXI-Definitions", file("AXI"))
    .settings(commonSettings: _*)
    .settings(chiselSettings: _*)

  lazy val examples = Project("AXI-Examples", file("examples"))
    .settings(commonSettings: _*)
    .settings(chiselSettings: _*)
    .dependsOn(axi)
}
