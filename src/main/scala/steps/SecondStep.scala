package steps

import pipelines._

import scala.collection.immutable.HashMap

object SecondStep extends Step {

  def execute(status: HashMap[String, Object]): HashMap[String, Object] = {
    status + ("Second" -> "2")
  }
}
