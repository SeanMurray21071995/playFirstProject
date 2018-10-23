package controllers

import play.api._
import play.api.mvc._

class Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }
  def second(num:Int) = Action {
    Ok(views.html.secondPage("Second page woop woop"+num))
  }
  def secondStatic=Action{
    Ok(views.html.secondPage("dffgdgsdsg"))
  }
  def secondOptional=Action{
    Ok
  }

}