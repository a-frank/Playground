package com.arconsis.scala.tail

class Fibonacci {
  
  def functional(of: Int): Int = of match {
    case 0 | 1 => return of
    case _ => functional(of - 2) + functional(of - 1)
  }

  def functional_tail(of: Int): Int = {
    def tailing(of: Int, z1: Int, z2: Int): Int = of match {
      case 0 => z1
      case _ => tailing(of - 1, z2, z1 + z2)
    }
    return tailing(of, 0, 1)
  }
  
  def imperativ(of: Int) = {
    var a = 0
    var b = 1
    var counter = 0

    while (counter < of) {
      val c = a + b
      a = b
      b = c
      counter = counter + 1
    }
    a
  }
}

object Fibonacci{
  def apply(of: Int) = new Fibonacci().functional_tail(of)
  def apply() = new Fibonacci()
}