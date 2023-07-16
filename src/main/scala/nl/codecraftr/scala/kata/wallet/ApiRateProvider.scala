package nl.codecraftr.scala.kata.wallet

// Imagine this is an external API
object ApiRateProvider {
  def rateProvider(stockType: StockType): Double = {
    // Imagine this being a slow api call
    Thread.sleep(250)

    stockType match {
      case Petroleum => 3.99
      case Dollar    => 1.23
      case Gold      => 101.73
    }
  }
}
