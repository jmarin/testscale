package org.scale.api

import akka.actor.Actor
import spray.httpx.marshalling.Marshaller
import spray.routing._

class ScaleService extends Actor with ScaleWebService {

  def actorRefFactory = context

  def receive = runRoute(myRoute)
}




trait ScaleWebService extends HttpService with AsyncSupport {


  val myRoute =

  path("features") {

    get {
      complete {
        "Ok"
      }
    }
  }



}
