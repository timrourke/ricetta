package com.timrourke.ricetta.model

import com.timrourke.ricetta.model.MeasureUnit._
import com.timrourke.ricetta.model.PhaseOfMatter.{Liquid, liquid}
import com.timrourke.ricetta.testing.BaseTest

class AmountTest extends BaseTest {

  describe("Amount") {

    it("should measure an amount of a foodstuff") {
      val milk = Foodstuff(id = FoodstuffID(2), name = "milk", phaseOfMatter = liquid)
      val twoLitersOfMilk = Amount(Liters(2), milk)

      twoLitersOfMilk.toString shouldBe "2L of milk"
    }
  }
}
