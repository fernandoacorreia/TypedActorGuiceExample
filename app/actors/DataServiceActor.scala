package actors

import akka.actor.TypedActor._
import play.api.Logger
import scala.concurrent._
import scala.util.Random

trait DataServiceActor {
  def getData(key: String): Future[String]
}

class DataServiceActorImpl extends DataServiceActor with PreStart with PostStop {

  val actorId = Random.nextInt;

  def getData(key: String): Future[String] = {
    val fakeData = actorId.toString
    context.stop(context.self) // Release this per-request actor.
    return Future.successful(fakeData)
  }

  override def postStop() =
    Logger.info(s"DataServiceActorImpl $actorId stopped")

  override def preStart() =
    Logger.info(s"DataServiceActorImpl $actorId started")

}
