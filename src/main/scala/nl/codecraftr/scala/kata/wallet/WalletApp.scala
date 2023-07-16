package nl.codecraftr.scala.kata.wallet

import LoggingProvider.withLogging

object WalletApp extends App {
  private lazy val loggingApiRateProvider = withLogging("Api")(
      ApiRateProvider.rateProvider
  )

  def calculateTotalValue(
      wallet: Wallet,
      rateProvider: StockType => Double
  ): Double = {
      val rates = calculateRates(wallet.stocks.keys.toSet, rateProvider)
      Wallet.calculateTotalValue(wallet, rates)
  }

  private def calculateRates(
      stockTypes: Set[StockType],
      rateProvider: StockType => Double
  ) = stockTypes
      .map(stockType => stockType -> rateProvider(stockType))
      .toMap
}
