import actors._
import akka.actor._
import com.google.inject._
import net.codingwell.scalaguice.ScalaModule
import play.api.libs.concurrent.Akka
import play.api.Play.current

class ActorsModule extends AbstractModule with ScalaModule {

  def configure() = {
  }

  @Provides
  def provideActorSystem(): ActorSystem = {
    Akka.system
  }

  @Provides
  def provideDataServiceActor(system: ActorSystem): DataServiceActor = {
    TypedActor(system).typedActorOf(TypedProps[DataServiceActorImpl]())
    // Question 1: Is there a better way to bind?
    // Question 2: Should actors be stopped after each use?
  }

}
