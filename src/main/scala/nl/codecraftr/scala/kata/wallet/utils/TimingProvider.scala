package nl.codecraftr.scala.kata.wallet.utils

import nl.codecraftr.scala.kata.wallet.StockType

/*
 * Higher order function to record time taken by rate provider
 */
object TimingProvider {
  def withTiming(rateProvider: StockType => Double): StockType => Double = {
    val wrapped = (stockType: StockType) => {
      val start = System.currentTimeMillis()

      val result = rateProvider(stockType)

      val end = System.currentTimeMillis()
      println(s"Retrieving rates took ${end - start} ms")
      result
    }
    wrapped
  }
}
