package com.timrourke.ricetta.model

import java.time.LocalDate

case class FoodstuffID(value: Int)

case class Foodstuff[P <: PhaseOfMatter](id: FoodstuffID,
                                         name: String,
                                         phaseOfMatter: P,
                                         createdAt: LocalDate = LocalDate.now(),
                                         updatedAt: LocalDate = LocalDate.now()) {
  def ofAmount(amount: MeasureUnit[P]): Amount[P] = {
    Amount(amount = amount, foodstuff = this)
  }
}
