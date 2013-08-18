package org.scale.geo

import org.jeo.feature.Feature
import org.jeo.geojson.GeoJSONDataset
import org.jeo.data.Query
import org.jeo.geojson.GeoJSONWriter
import org.scale.database.MongoDAO
import reactivemongo.api.collections.default.BSONCollection
import java.io.File
import java.io.StringWriter
import scala.collection.JavaConversions

class GeoJSONData { //this: MongoDAO[GeoJSONData] =>

  def export(file: File) = {
    val features = Nil
    val data = new GeoJSONDataset(file)
    val cursor = data.cursor(new Query)
    val w = new GeoJSONWriter(new StringWriter)
   // val geojson = w.featureCollection(cursor)


    def exportFeatures(features:List[Feature])

    while (cursor.hasNext) {
      val f = cursor.next
      val feature = GeoJSONWriter.toString(f)
//      println(feature)
      f ::: features
    }
    features
  }

}
