import pipelines.Pipeline

import scala.collection.immutable.HashMap

object Main extends App {

  println("Starting pipeline")

  val pipeline = Pipeline("examplePipeline")

  val defaultStatus = new HashMap[String, Object]()

  val finalStatus = pipeline.execute(defaultStatus)

  println(s"Ending status keys: ${finalStatus.keys}" )
}
