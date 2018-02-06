
name := "evaluation"

version := "0.1"

scalaVersion := "2.12.4"

libraryDependencies += "log4j" % "log4j" % "1.2.17"

libraryDependencies += "org.scalatest" % "scalatest_2.12" % "3.0.4" % "test"

coverageEnabled := true


lazy val Settings = Seq(
  version := "1.0",
  scalaVersion := "2.12.4",
  libraryDependencies += "org.scalatest" % "scalatest_2.12" % "3.0.3" % "test"

)

lazy val accounts = project.
  settings(
    Settings
  )
lazy val checkout = project.
  dependsOn(inventory)
    .settings(
    Settings
  )

lazy val inventory = project.
  settings(
    Settings
  )

lazy val apiResources = project.
  dependsOn(accounts,checkout,inventory)
      .settings(
    Settings
  )

lazy val dashboard = project.
  dependsOn(apiResources).
  settings(
    Settings
  )

lazy val root = (project in file(".")).
  aggregate(accounts, apiResources, checkout, inventory, dashboard )



