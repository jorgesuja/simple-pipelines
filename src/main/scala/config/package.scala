import com.typesafe.config.ConfigFactory

package object config {
  val config = ConfigFactory.load()
                            .withFallback(ConfigFactory.load("pipelines"))
}
