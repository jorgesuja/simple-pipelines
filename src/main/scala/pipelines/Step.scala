package pipelines

import scala.collection.immutable.HashMap

trait Step {
  def execute(status: HashMap[String, Object]): HashMap[String, Object]
}
