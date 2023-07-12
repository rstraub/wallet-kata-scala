package nl.codecraftr.scala.kata

case class Wallet(stocks: Set[Stock]) {}

object Wallet {
  def apply(stocks: Stock*): Wallet = Wallet(stocks.toSet)

  def calculateTotalValue(
      wallet: Wallet,
      rates: Map[StockType, Double]
  ): Double =
    wallet.stocks
      .map(stock => stock.amount * rates.getOrElse(stock.stockType, 0.0))
      .sum
}
