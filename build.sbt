lazy val root = (project in file(".")).
  settings(
    name := "dl4j-vgg16-console-app",
    version := "1.0"
  )

lazy val spark = Seq(
  "spark-core",
  "spark-sql",
  "spark-hive"
).map("org.apache.spark" %% _ % "1.6.0" % "provided")
libraryDependencies ++= spark

libraryDependencies ++= Seq(
  "args4j" % "args4j" % "2.33",
  "org.deeplearning4j" % "deeplearning4j-core" % "0.9.1",
  "org.deeplearning4j" % "deeplearning4j-zoo" % "0.9.1",
  "org.nd4j" % "nd4j-native-platform" % "0.9.1"

)

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}

assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false)
assemblyJarName in assembly := "dl4j-vgg16-console-app.jar"


        
