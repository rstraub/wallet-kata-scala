package nl.codecraftr.scala.kata

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class WalletSpec extends AnyWordSpec with Matchers {
  private val rates: Map[StockType, Double] = Map(
    Petroleum -> 2.0,
    Gold -> 10.0
  )

  "calculateTotalValue" should {
    "return total value given of a single stock" in {
      val wallet = Wallet(
        Stock(1, Petroleum)
      )

      Wallet.calculateTotalValue(wallet, rates) shouldBe 2.0
    }

    "return total value of multiple of a single stock" in {
      val wallet = Wallet(
        Stock(2, Petroleum)
      )

      Wallet.calculateTotalValue(wallet, rates) shouldBe 2.0 * 2
    }

    "return total value of multiple stocks" in {
      val wallet = Wallet(
        Stock(1, Petroleum),
        Stock(1, Gold)
      )

      Wallet.calculateTotalValue(wallet, rates) shouldBe 2.0 + 10.0
    }
  }
}
