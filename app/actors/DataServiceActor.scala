package actors

import scala.concurrent._
import akka.actor.TypedActor._
import play.api.Logger
import scala.util.Random

trait DataServiceActor {
  def getData(key: String): Future[String]
}

class DataServiceActorImpl extends DataServiceActor with PreStart with PostStop {

  def getData(key: String): Future[String] = {
    val fakeData = Random.nextInt.toString
    Future.successful(fakeData)
  }

  override def postStop() =
    Logger.info("DataServiceActorImpl stopped")

  override def preStart() =
    Logger.info("DataServiceActorImpl started")

}
