package com.arconsis.scala

import android.view.View

object ActivityImplicits {
  implicit def function2ViewOnClickListener(f: View => Unit) = {
    new View.OnClickListener() {
      def onClick(v: View) {
        f(v)
      }
    }
  }
}