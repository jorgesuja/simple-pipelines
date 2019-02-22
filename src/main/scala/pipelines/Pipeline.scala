import scala.collection.immutable.HashMap

class Pipeline(val steps: List[Step]) {
  
  def ++(pipeline: Pipeline) = {
    Pipeline(this.steps ++ pipeline.steps)
  }

  def execute(initialStatus: HashMap[String, Object]): HashMap[String, Object] = {
    this.steps.foldLeft(initialStatus)((status, step) => step.execute(status))
  }
}

object Pipeline {

  def apply(steps: List[Step]) = {
    new Pipeline(steps)
  }
}