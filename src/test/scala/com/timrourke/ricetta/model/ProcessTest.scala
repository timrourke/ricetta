package com.timrourke.ricetta.model

import com.timrourke.ricetta.model.MeasureUnit.{Grams, Liters}
import com.timrourke.ricetta.model.PhaseOfMatter.*
import com.timrourke.ricetta.model.Process.*
import com.timrourke.ricetta.testing.BaseTest

class ProcessTest extends BaseTest {
  private val milk = Foodstuff(
    id = FoodstuffID(1),
    name = "milk",
    phaseOfMatter = liquid,
  ).ofAmount(Liters(0.5))
  private val sugar = Foodstuff(
    id = FoodstuffID(2),
    name = "sugar",
    phaseOfMatter = solid,
  ).ofAmount(Grams(200))
  private val cinnamon = Foodstuff(
    id = FoodstuffID(3),
    name = "cinnamon",
    phaseOfMatter = solid,
  ).ofAmount(Grams(10))
  private val salt = Foodstuff(
    id = FoodstuffID(4),
    name = "salt",
    phaseOfMatter = solid,
  ).ofAmount(Grams(20))
  private val carrots = Foodstuff(
    id = FoodstuffID(5),
    name = "carrots",
    phaseOfMatter = solid,
  ).ofAmount(Grams(300))

  describe("Process") {

    describe("Mix") {

      it("should mix 2 things together") {
        Mix(milk, sugar)
          .toString shouldBe "mix 500ml of milk, and 200g of sugar"
      }

      it("should mix 3 things together") {
        Mix(milk, sugar, cinnamon)
          .toString shouldBe "mix 500ml of milk, 200g of sugar, and 10g of cinnamon"
      }

      it("should mix 4 things together") {
        Mix(milk, sugar, cinnamon, salt)
          .toString shouldBe "mix 500ml of milk, 200g of sugar, 10g of cinnamon, and 20g of salt"
      }
    }
  }

  describe("Chop") {

    it("should chop") {
      Chop(carrots).toString shouldBe "chop 300g of carrots"
    }
  }
}
