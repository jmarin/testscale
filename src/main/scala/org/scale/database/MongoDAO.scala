package org.scale.database

import reactivemongo.api.collections.default.BSONCollection
import reactivemongo.bson.BSONDocument
import reactivemongo.bson.BSONObjectID
import scala.concurrent.ExecutionContext
import reactivemongo.api._
import reactivemongo.bson._
import reactivemongo.core.commands.{ LastError, GetLastError, Count }

trait MongoDAO[T] { this: MongoConfig =>

  implicit val ec: ExecutionContext
  implicit val reader: BSONDocumentReader[T]
  implicit val writer: BSONDocumentWriter[T]

  def collection: BSONCollection

  val ID = "_id"

  def findAll = {
    collection.find(BSONDocument()).cursor[T]
  }

  def findAll(attribute: String, value: BSONValue) = {
    collection.find(BSONDocument(attribute -> value)).cursor[T]
  }

  def findById(id: String) = {
    collection.find(BSONDocument(ID -> BSONObjectID(id))).one[T]
  }

  def findByID(id: BSONObjectID) = {
    collection.find(BSONDocument(ID -> id)).one[T]
  }

  def findUnique(attribute: String, value: String) = {
    collection.find(BSONDocument(attribute -> BSONString(value))).one[T]
  }

  def findUnique(attribute:String, value: BSONValue) = {
    collection.find(BSONDocument(attribute -> value)).one[T]
  }

}
