import com.google.inject.Guice
import play.api._

object Global extends GlobalSettings {

  val injector = Guice.createInjector(new ActorsModule)

  override def getControllerInstance[A](controllerClass: Class[A]): A =
    injector.getInstance(controllerClass)

}
