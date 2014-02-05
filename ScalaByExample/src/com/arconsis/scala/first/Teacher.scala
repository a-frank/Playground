package com.arconsis.scala.first

import scala.collection.mutable.MutableList

class Teacher(val name: String) {
  
  def teachComp() {
    val subject = ". Mister " + name + " is teaching"
    val list = new MutableList[String]()
    for(iter <- 0 to 10){
      if(iter > 5){
    	  val out = iter +subject
    	  println(out)
    	  list += out
      }
    }
    
    val builder = new StringBuilder
    list.foreach((s)=> builder.append(s).append(", "))
    println(builder.toString)
  }
  
  def teach() {
    val subject = ". Mister " + name + " is teaching";
    
    val teachings = for (iter <- 0 to 10; if(iter > 5)) yield {
      val out = iter + subject
      println(out)
      out
    }
    
    println(teachings.mkString(", "))
  }
  
  def techFunc(){
    val subject = ". Mister " + name + " is teaching"
    
    val listing = (0 to 10).filter(_ > 5).map((iter) => {
      val out = iter + subject 
      println(out)
      out
    }).mkString(", ")
    
    println(listing)
  }
  
}