package com.balab.com.balab

import org.joda.time.format.DateTimeFormat
import org.joda.time.chrono.ISOChronology


/**
 * Created by Balaji on 28/10/2014.
 */
package object phase {

  //private val pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
  private val pattern = "dd/MM/yyyy"

  private val utcChronology = ISOChronology.getInstanceUTC

  private val dateFormat = DateTimeFormat.forPattern(pattern).withChronology(utcChronology).withZoneUTC()

  def stringToDateTime(datetime: String) = dateFormat.parseDateTime(datetime)

  implicit class StringWithDateTimeConversion(datetime: String) {
    def toDateTime = stringToDateTime(datetime)
  }

  implicit class CSVHeader (header:Array[String]) extends Serializable {

    val index = header.zipWithIndex.toMap
    def apply(array:Array[String], key:String):String = array(index(key))

  }
}
