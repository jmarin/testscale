package org.scale.api

import akka.actor.Actor
import spray.routing._
import spray.http.HttpResponse
import spray.can.parsing.Result.Ok

import scala.concurrent.{ExecutionContext, Future}
import spray.httpx.marshalling.Marshaller

class ScaleService extends Actor with ScaleWebService {

  def actorRefFactory = context

  def receive = runRoute(myRoute)
}




trait ScaleWebService extends HttpService {


  val myRoute =

  path("features") {

    get {
      complete {
        "Ok"
      }
    }
  }



}
