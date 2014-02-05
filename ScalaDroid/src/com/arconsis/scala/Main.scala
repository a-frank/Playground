package com.arconsis.scala

import com.arconsis.scala.ActivityImplicits._
import android.app.Activity
import android.os.Bundle
import android.view.View
import android.app.AlertDialog

class Main extends Activity {
  override def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    findViewById(R.id.click_me).setOnClickListener(click _)
  }
  
  def click(v : View){
	  val builder = new AlertDialog.Builder(Main.this);
	  builder.setTitle("First Scala!")
	  builder.setMessage(R.string.hello_world);
	  builder.show()
  }
}