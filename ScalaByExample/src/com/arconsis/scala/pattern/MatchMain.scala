package com.arconsis.scala.pattern

object MatchMain extends Application{
	val matching = new Matcher
	println(matching.matching("foo"))
	println(matching.matching("bar"))
	println(matching.matching("baz"))
	
	println(matching.matching(2))
	println(matching.matching(2.4))
	println(matching.matching(2.32f))
	println(matching.matching(23L))
}