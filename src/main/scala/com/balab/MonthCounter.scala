package com.balab


import com.balab.util._
import  org.joda.time._
/**
 * Created by Balaji on 15/12/2014.
 */
class MonthCounter {

  def readFile() {


   /* Sample Date
    1,06/06/2002,01/07/2003
     ....
     ..
    7,04/07/2012,15/10/2014
   */

    val fileName =  "dates.csv" // above format

    try{
      println("Company Name\t\t\t\t\tMonths")
      println("------------\t\t\t\t\t------")

      val counts = scala.collection.mutable.Map.empty[String, Int]

      io.Source.fromFile(fileName).getLines.foreach( e => {
        val ted = e.split(",")

        val companyName = ted(1)
        val date1 = new LocalDate(ted(2).toDateTime)
        val date2 = new LocalDate(ted(3).toDateTime)

        val monthDay = PeriodType.months();

        val difference = new Period(date1, date2, monthDay);
        println(companyName+"\t\t"+difference.getMonths)
        counts += (ted(0) ->  (difference.getMonths ) )


      } )
      println()

     val months = counts.values.sum;
     val quotient  = months / 12;
     val reminder = months % 12;

      println("----------------------------------")
      println("\t\t\t\t\t\t\t\t"+months)
     var result = "\t\t\tTotal " +quotient+" Years"

      if(reminder != 0) {
        result = result + " "+ reminder + " Months"
      }
      println("----------------------------------")

      println(result)



    } catch{
      case ex:Exception => println(ex)
    }

  }

}
