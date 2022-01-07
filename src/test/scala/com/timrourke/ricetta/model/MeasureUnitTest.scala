package com.timrourke.ricetta.model

import com.timrourke.ricetta.testing.BaseTest
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class MeasureUnitTest extends BaseTest {

  import MeasureUnit._

  describe("MeasureUnit") {

    describe("Grams") {

      it("should create grams") {
        Grams(3).amount shouldBe 3
      }

      it("should format grams to metric") {
        Grams(7.14).toString shouldBe "7g 140mg"
      }

      it("should add grams") {
        Grams(2) + Grams(5) shouldBe Grams(7)
      }

      it("should subtract grams") {
        Grams(12.6) - Grams(0.6) shouldBe Grams(12)
      }
    }

    describe("Liters") {

      it("should create liters") {
        Liters(22.4).amount shouldBe 22.4
      }

      it("should add liters") {
        Liters(11) + Liters(23.5) shouldBe Liters(34.5)
      }

      it("should subtract liters") {
        Liters(3.1) - Liters(14) shouldBe Liters(-10.9)
      }

      it("should format grams") {
        Grams(231.125).toString shouldBe "231g 125mg"
      }

      it("should format liters") {
        Liters(37.089).toString shouldBe "37L 89ml"
      }
    }

  }
}
