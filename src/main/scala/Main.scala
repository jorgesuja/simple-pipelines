import scala.collection.immutable.HashMap

object Main extends App {

  println("Starting pipeline")

  val pipeline = Pipeline(List(InitStep, SecondStep))

  val finalStatus = pipeline.execute(new HashMap[String, Object]())

  println(s"Ending pipeline: ${finalStatus.keys}" )
}