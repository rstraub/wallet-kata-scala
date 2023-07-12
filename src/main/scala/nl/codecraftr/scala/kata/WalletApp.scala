package nl.codecraftr.scala.kata

object WalletApp extends App {
  def calculateTotalValue(
      wallet: Wallet,
      rateProvider: StockType => Double
  ): Double = {
      val rates = calculateRates(wallet, rateProvider)
      Wallet.calculateTotalValue(wallet, rates)
  }

  private def calculateRates(
      wallet: Wallet,
      rateProvider: StockType => Double
  ) = {
    wallet.stocks
      .map(_.stockType)
      .map(stockType => stockType -> rateProvider(stockType))
      .toMap
  }
}
