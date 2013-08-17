package org.scale

import akka.actor.{ Props, ActorSystem }
import akka.io.IO
import spray.can.Http
import org.scale.api.ScaleService


object Boot extends App {

  implicit val system = ActorSystem("scale")

  val service = system.actorOf(Props(new ScaleService), "scale-service")

  IO(Http) ! Http.Bind(service, interface = "localhost", port = 8081)

}
