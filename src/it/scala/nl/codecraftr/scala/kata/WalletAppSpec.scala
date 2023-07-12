package nl.codecraftr.scala.kata

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class WalletAppSpec extends AnyFlatSpec with Matchers {
  "wallet" should "calculate total value of its stocks" in {
    val wallet = Wallet(
      Stock(1, Petroleum),
      Stock(2, Dollar),
      Stock(3, Gold)
    )

    val rateProvider = (stockType: StockType) =>
      stockType match {
        case Petroleum => 5.0
        case Dollar    => 1.0
        case Gold      => 10.0
      }

    WalletApp.calculateTotalValue(wallet, rateProvider) shouldBe (
      5.0 + (1.0 * 2) + (10.0 * 3)
    )
  }
}
