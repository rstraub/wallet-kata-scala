package nl.codecraftr.scala.kata.wallet

case class Wallet(stocks: Map[StockType, Int]) {}

object Wallet {
  def apply(stocks: Stock*): Wallet = {
    val stocksMap = stocks
      .groupBy(_.stockType)
      .map { case (stockType, stocks) =>
        stockType -> stocks.map(_.amount).sum
      }
    new Wallet(stocksMap)
  }

  def calculateTotalValue(
      wallet: Wallet,
      rates: Map[StockType, Double]
  ): Double =
    wallet.stocks.map { case (stockType, amount) =>
      amount * rates.getOrElse(stockType, 0.0)
    }.sum
}
