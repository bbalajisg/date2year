name := "date2year"


version := "1.0"

scalaVersion := "2.10.3"

javacOptions ++= Seq("-source", "1.7", "-target", "1.7")

initialize := {
  assert(
    Integer.parseInt(sys.props("java.specification.version").split("\\.")(1))
      >= 7,
    "Java 7 or above required")
}

libraryDependencies ++= Seq(
  "joda-time" % "joda-time" % "2.5",
  "org.joda" % "joda-convert" % "1.7"
)

resolvers +=  "Central Maven" at "http://central.maven.org/maven2/"

mainClass := Some("com.teralytics.phase.MainApp")