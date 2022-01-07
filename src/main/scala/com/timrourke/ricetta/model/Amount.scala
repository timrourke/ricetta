package com.timrourke.ricetta.model

case class Amount[P <: PhaseOfMatter](amount: MeasureUnit[P],
                                      foodstuff: Foodstuff[P]) {
  override def toString: String = s"$amount of ${foodstuff.name}"
}
