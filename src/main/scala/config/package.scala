import com.typesafe.config.ConfigFactory

/** This object contains the loaded config */
package object config {
  val config = ConfigFactory.load().withFallback(ConfigFactory.load("pipelines"))
}
