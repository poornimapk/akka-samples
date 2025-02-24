organization := "com.lightbend.akka.samples"
name := "akka-sample-replicated-event-sourcing-scala"

scalaVersion := "2.13.10"

val AkkaVersion = "2.7.0"
val AkkaPersistenceCassandraVersion = "1.1.0"
val AkkaHttpVersion = "10.4.0"
val AkkaClusterManagementVersion = "1.2.0"
val AkkaDiagnosticsVersion = "2.0.0-M4"
val LogbackClassicVersion = "1.2.11" 
val ScalaTestVersion = "3.1.1"

credentials += Credentials(Path.userHome / ".lightbend" / "commercial.credentials")
resolvers += "com-mvn" at "https://repo.lightbend.com/commercial-releases/"
resolvers += Resolver.url("com-ivy",
  url("https://repo.lightbend.com/commercial-releases/"))(Resolver.ivyStylePatterns)

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-cluster-sharding-typed" % AkkaVersion,
  "com.typesafe.akka" %% "akka-persistence-typed" % AkkaVersion,
  "com.typesafe.akka" %% "akka-serialization-jackson" % AkkaVersion,
  "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-spray-json" % AkkaHttpVersion,
  "com.lightbend.akka.management" %% "akka-management" % AkkaClusterManagementVersion,
  "com.lightbend.akka.management" %% "akka-management-cluster-http" % AkkaClusterManagementVersion,
  "com.typesafe.akka" %% "akka-persistence-cassandra" % AkkaPersistenceCassandraVersion,
  "com.lightbend.akka" %% "akka-diagnostics" % AkkaDiagnosticsVersion,

  "ch.qos.logback" % "logback-classic" % LogbackClassicVersion,

  "com.typesafe.akka" %% "akka-persistence-cassandra-launcher" % AkkaPersistenceCassandraVersion,
  "com.typesafe.akka" %% "akka-persistence-testkit" % AkkaVersion % Test,
  "org.scalatest" %% "scalatest" % ScalaTestVersion % Test
)

// transitive dependency of akka 2.5x that is brought in by addons but evicted
dependencyOverrides += "com.typesafe.akka" %% "akka-protobuf" % AkkaVersion
dependencyOverrides += "com.typesafe.akka" %% "akka-cluster-tools" % AkkaVersion
dependencyOverrides += "com.typesafe.akka" %% "akka-coordination" % AkkaVersion

run / fork := true

licenses := Seq(("CC0", url("http://creativecommons.org/publicdomain/zero/1.0")))
