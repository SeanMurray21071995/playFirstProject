package models

import play.api.data._
import play.api.data.Forms._

import scala.collection.mutable.ArrayBuffer

case class CD(name:String, price:Int)

object CD{
  val createCDForm = Form(
    mapping(
      "name" -> nonEmptyText,
      "price" -> number(min=0, max=100)
    )(CD.apply)(CD.unapply)
  )

  val cds = ArrayBuffer(
    CD("Cd 1",123),
    CD("The second cd", 80),
    CD("finel edition",45)
  )
}
