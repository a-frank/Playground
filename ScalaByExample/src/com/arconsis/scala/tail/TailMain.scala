package com.arconsis.scala.tail


object Main extends Application{
	val fib = new Fibonacci
	
	println(fib.functional_tail(100))
	
	println(Fibonacci(100))
	
	println(Fibonacci().imperativ(100))
	
	println(fib.functional(100))
}