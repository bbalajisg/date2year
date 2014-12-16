package com.balab


import com.balab.phase._
import java.util.Date
import  org.joda.time._
/**
 * Created by Balaji on 15/12/2014.
 */
class MonthCounter {

  def readFile() {


   /* Sample Date
    1,06/06/2002,01/07/2003
    2,01/05/2004,20/04/2005
    3,04/07/2006,30/12/2006
    4,01/05/2007,16/03/2009
    5,01/11/2009,16/06/2010
    6,27/07/2010,18/06/2012
    7,04/07/2012,15/10/2014
   */

    val fileName =  "dates.csv" // above format

    try{


      val counts = scala.collection.mutable.Map.empty[String, Int]

      io.Source.fromFile(fileName).getLines.foreach( e => {
        val ted = e.split(",")

        val date1 = new LocalDate(ted(1).toDateTime)
        val date2 = new LocalDate(ted(2).toDateTime)

        val monthDay = PeriodType.months();

        val difference = new Period(date1, date2, monthDay);

        counts += (ted(0) ->  (difference.getMonths ) )


      } )


     val months = counts.values.sum;
     val quotient  = months / 12;
     val reminder = months % 12;

     var result = "Total " +quotient+" Years"

      if(reminder != 0) {
        result = result + " "+ reminder + " Months"
      }


      println(result)

    } catch{
      case ex:Exception => println(ex)
    }

  }

}
