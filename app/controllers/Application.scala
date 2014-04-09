package controllers

import actors.DataServiceActor
import com.google.inject.Inject
import play.api._
import play.api.libs.concurrent.Execution.Implicits._
import play.api.mvc._

class Application @Inject() (dataService: DataServiceActor) extends Controller {

  def index = Action.async { implicit request =>
    dataService.getData("key").map { data =>
      val msg = s"Retrieved data: '$data'."
      Ok(views.html.index(msg))
    }
  }

}
