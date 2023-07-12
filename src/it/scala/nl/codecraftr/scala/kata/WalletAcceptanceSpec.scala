package nl.codecraftr.scala.kata

import nl.codecraftr.scala.kata.Wallet.calculateTotalValue
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class WalletAcceptanceSpec extends AnyWordSpec with Matchers {
  "wallet" should {
    "calculate total value of its stocks" in {
      val wallet = Wallet(
        Stock(1, Petroleum),
        Stock(2, Dollar),
        Stock(3, Gold)
      )

      calculateTotalValue(wallet, _ => 2.0) shouldBe (1 + 2 + 3) * 2.0
    }
  }
}
