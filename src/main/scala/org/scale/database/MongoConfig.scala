package org.scale.database

import com.typesafe.config.ConfigFactory
import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import reactivemongo.api.{ DefaultDB, DB, MongoDriver }
import reactivemongo.api.collections.default.BSONCollection
import scala.util.Try
import java.util.Collections
import scala.collection.JavaConversions._

trait MongoConfig {
  val config = ConfigFactory.load
  private val servers = config.getStringList("mongodb.servers")
  private val dbName = config.getString("mongodb.db")

  private val driver = new MongoDriver
  val connection = driver.connection(servers)
  def db = connection(dbName)
}
