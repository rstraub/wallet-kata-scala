package nl.codecraftr.scala.kata.wallet.utils

import nl.codecraftr.scala.kata.wallet.StockType

/*
 * Higher order function to add logging to a rate provider
 */
object LoggingProvider {
  def withLogging(
      source: String
  )(rateProvider: StockType => Double): StockType => Double = {
    val wrapped = (stockType: StockType) => {
      println(s"Getting rates for $stockType from $source")
      val result = rateProvider(stockType)
      println(s"Got rates for $stockType from $source")
      result
    }
    wrapped
  }
}
