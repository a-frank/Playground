package com.arconsis.scala.traits

class Smartphone extends Phone with Sms with Internet with Camera with Mms {
  override def typing() = super.typing
  override def picture() = "Wallpaper.jpg"
}