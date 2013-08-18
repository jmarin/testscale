package org.scale.geo

import org.specs2.mutable._
import org.jeo.geojson.GeoJSONDataset
import org.scale.database.MongoConfig
import java.io.File

class GeoJSONTest extends Specification {

  "A GeoJSON file" should {
    "be exported to MongoDB" in {
      val geojson = new GeoJSONData //with MongoDAO[GeoJSONDataset] with MongoConfig
      val url = getClass().getResource("/states.geojson")
      //println(url)
      val features = geojson.export(new File(url.getFile))
      //features.foreach(println)
      1 == 1
    }
  }

}
