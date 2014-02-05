package com.arconsis.scala.first

import com.arconsis.java.first.JTeacher

object FirstMain extends Application{
	println("Scala:")
	val max = new Teacher("Max")
	max.teach
	
	println()
	println("Func:")
	val func = new Teacher("Func")
	func.techFunc
	
	println()
	println("Java:")
	val muster = new JTeacher("Musterman");
	muster.teach
	
	println()
	println("Comp:")
	max.teachComp
}