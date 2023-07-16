package nl.codecraftr.scala.kata

// Imagine this is an external API
object ApiRateProvider {
  def rateProvider(stockType: StockType): Double = stockType match {
    case Petroleum => 3.99
    case Dollar    => 1.23
    case Gold      => 101.73
  }
}
