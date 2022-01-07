package com.timrourke.ricetta.model


import PhaseOfMatter._

sealed abstract class MeasureUnit[P <: PhaseOfMatter] {
  val abbreviation: String
  val amount: Double

  def +(that: MeasureUnit[P]): MeasureUnit[P]

  def -(that: MeasureUnit[P]): MeasureUnit[P]

  final def formatMetric(): String = {
    val integrals = amount.floor.toInt
    val remainder = amount - integrals

    val integralFormatted = if (integrals == 0) "" else integrals + abbreviation
    val fractionFormatted = if (remainder == 0) "" else (remainder * 1000).round.toInt + s"m${abbreviation.toLowerCase()}"

    s"$integralFormatted $fractionFormatted".trim
  }

  override final def toString: String = formatMetric()
}

object MeasureUnit {

  final case class Grams(amount: Double) extends MeasureUnit[Solid] {
    override val abbreviation: String = "g"

    override def +(that: MeasureUnit[Solid]): MeasureUnit[Solid] = {
      Grams(amount + that.amount)
    }

    override def -(that: MeasureUnit[Solid]): MeasureUnit[Solid] = {
      Grams(amount - that.amount)
    }
  }

  final case class Liters(amount: Double) extends MeasureUnit[Liquid] {
    override val abbreviation: String = "L"

    override def +(that: MeasureUnit[Liquid]): MeasureUnit[Liquid] = {
      Liters(amount + that.amount)
    }

    override def -(that: MeasureUnit[Liquid]): MeasureUnit[Liquid] = {
      Liters(amount - that.amount)
    }
  }
}

