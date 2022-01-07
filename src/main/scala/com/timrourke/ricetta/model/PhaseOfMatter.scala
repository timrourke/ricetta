package com.timrourke.ricetta.model

sealed abstract class PhaseOfMatter {
  val name: String
  override final def toString: String = name
}

object PhaseOfMatter {
  final case class Solid(name: String) extends PhaseOfMatter
  final case class Liquid(name: String) extends PhaseOfMatter
  
  final val solid = Solid("solid")
  final val liquid = Liquid("liquid")
}
