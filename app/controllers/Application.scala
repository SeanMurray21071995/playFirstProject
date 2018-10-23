package controllers

import javax.inject.Inject
import play.api._
import play.api.mvc._
import play.api.i18n.{I18nSupport, MessagesApi}
import models.{CD, Person}

class Application @Inject()(val messagesApi: MessagesApi, environment: play.api.Environment) extends Controller with I18nSupport{

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
    Ok(views.html.secondPage("the dog"))
  }

  def listCDs = Action {implicit request =>
    Ok(views.html.formPage(CD.cds, CD.createCDForm))
  }
  def createCD = Action { implicit request =>
      val formValidationResult = CD.createCDForm.bindFromRequest
      formValidationResult.fold({formWithErrors =>
        BadRequest(views.html.formPage(CD.cds, formWithErrors))
      },
        {cd =>
          CD.cds.append(cd)
          Redirect(routes.Application.listCDs)
        }
      )
  }
  def peopleList = Action {implicit request =>
    Ok(views.html.personForm(Person.people, Person.createPerson))
  }
  def createPerson = Action {implicit request =>
    val formValidationResult = Person.createPerson.bindFromRequest
    formValidationResult.fold({formWithErrors =>
      BadRequest(views.html.personForm(Person.people, formWithErrors))
    },
      {people =>
      Person.people.append(people)
      Redirect(routes.Application.peopleList)
    }
    )
  }
}