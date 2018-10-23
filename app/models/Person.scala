package models

import play.api.data._
import play.api.data.Forms._

import scala.collection.mutable.ArrayBuffer

case class Person(firstName: String, lastName: String, age: Int)

object Person{
  val createPerson = Form{
    mapping(
      "firstName" -> nonEmptyText,
      "lastName" -> nonEmptyText,
      "age" -> number(min = 0,max =150)
    )(Person.apply)(Person.unapply)
  }

  val people = ArrayBuffer(
    Person("Maggie","Smith",87),
    Person("Bob", "Bobert",45)
  )
}