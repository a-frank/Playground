package com.arconsis.scala.traits

object TraitMain extends Application{
	val smart = new Smartphone
	
	println(smart.browsing)
	println(smart.typing)
	
	println("\nMixin")
	val mobile = new Phone with Sms
	println(mobile.call)
	println(mobile.typing)
}