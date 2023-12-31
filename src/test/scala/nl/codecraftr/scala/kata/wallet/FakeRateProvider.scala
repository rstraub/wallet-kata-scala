package nl.codecraftr.scala.kata.wallet

object FakeRateProvider {
  def rateProvider(stockType: StockType): Double = stockType match {
    case Petroleum => 5.0
    case Dollar    => 1.0
    case Gold      => 10.0
    case _         => 1.0
  }
}
