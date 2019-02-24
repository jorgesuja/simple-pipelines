package pipelines

import config._

import scala.collection.JavaConverters._
import scala.collection.immutable.HashMap
import scala.reflect.runtime.universe

class Pipeline(val steps: List[Step]) {
  
  def ++(pipeline: Pipeline) = Pipeline(this.steps ++ pipeline.steps)

  /**
    * Executes this pipeline's steps
    *
    * @param initialStatus initial data for the first step
    * @return final status after the execution of the steps
    */
  def execute(initialStatus: HashMap[String, Object]): HashMap[String, Object] = {
    this.steps.foldLeft(initialStatus)((status, step) => step.execute(status))
  }
}

object Pipeline {

  /**
    * Builds a pipeline by name, retrieving the executable steps from
    * the config file
    *
    * @param name name of the config entry with the steps
    * @return the executable pipeline
    */
  def apply(name: String): Pipeline = {

    val stepNames = config.getStringList(s"pipelines.$name")

    new Pipeline(stepNames.asScala.toList.map(instantiateStep))
  }

  /**
    * Builds a pipeline using the provided steps
    *
    * @param steps steps to execute
    * @return the executable pipeline
    */
  def apply(steps: List[Step]): Pipeline = {
    new Pipeline(steps)
  }

  /**
    * Instantiates the desired step by name
    *
    * @param stepName name of the step to instantiate
    * @return step's object
    */
  private def instantiateStep(stepName: String): Step = {

    val runtimeMirror = universe.runtimeMirror(getClass.getClassLoader)
    val module = runtimeMirror.staticModule(s"steps.$stepName")

    runtimeMirror.reflectModule(module).instance.asInstanceOf[Step]
  }
}
