import com.mariussoutier.sbt.UnpackKeys
import sbt.io.ExtensionFilter

enablePlugins(com.mariussoutier.sbt.UnpackPlugin)

name := "sourcedep"

version := "0.1"

scalaVersion := "2.13.2"

val circeVersion = "0.12.3"

libraryDependencies += "org.typelevel" %% "cats-core" % "2.1.1"

libraryDependencies += "org.typelevel" %% "mouse" % "0.25" classifier "sources" intransitive()

UnpackKeys.dependencyFilter := "*-sources.jar"
UnpackKeys.fileExcludeFilter := new ExtensionFilter("class", "MF")

sourceGenerators in Compile += UnpackKeys.unpackJars