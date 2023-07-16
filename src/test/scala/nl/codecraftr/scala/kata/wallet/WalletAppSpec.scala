package nl.codecraftr.scala.kata.wallet

import LoggingProvider.withLogging
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class WalletAppSpec extends AnyFlatSpec with Matchers {
  private val wallet = Wallet(
    Stock(1, Petroleum),
    Stock(2, Dollar),
    Stock(3, Gold)
  )

  "wallet" should "calculate total value of its stocks (Fake)" in {
    WalletApp.calculateTotalValue(
      wallet,
      withLogging("fake")(FakeRateProvider.rateProvider)
    ) shouldBe (
      5.0 + (1.0 * 2) + (10.0 * 3)
    )
  }

  it should "calculate total value of its stocks (API)" in {
    WalletApp.calculateTotalValue(
      wallet,
      withLogging("api")(ApiRateProvider.rateProvider)
    ) should be > 0.0
  }
}
