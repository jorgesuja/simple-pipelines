package pipelines

import scala.collection.immutable.HashMap

trait Step {

  /**
    * Executes the step
    *
    * @param status current status of the pipeline
    * @return updated staus after the execution
    */
  def execute(status: HashMap[String, Object]): HashMap[String, Object]
}
