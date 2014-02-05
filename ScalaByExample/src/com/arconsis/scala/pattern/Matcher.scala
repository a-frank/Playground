package com.arconsis.scala.pattern

class Matcher {

  def matching(s: String) = s match {
    case "foo" => "You entered foo"
    case "bar" => "bar was entered"
    case s => "Something different: " + s
  }

  def matching[T](o: T) = o match {
    case i: Int => "We have an Int"
    case f: Float => "We have a Float"
    case d: Double => "We have a Double"
    case _ => "Undecided"
  }
}