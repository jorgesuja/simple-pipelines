package steps

import pipelines._

import scala.collection.immutable.HashMap

object InitStep extends Step {

  def execute(status: HashMap[String, Object]): HashMap[String, Object] = {
    status + ("Test" -> "1")
  }
}
