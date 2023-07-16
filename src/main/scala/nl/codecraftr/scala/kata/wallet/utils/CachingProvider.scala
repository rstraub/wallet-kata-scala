package nl.codecraftr.scala.kata.wallet.utils

import nl.codecraftr.scala.kata.wallet.StockType

import scala.collection.mutable

/*
 * Higher order function to cache a rate provider's result (very naively, just for demo purposes)
 */
object CachingProvider {
  def withCaching(rateProvider: StockType => Double): StockType => Double = {
    // Clojure to cache the result of the rate provider
    val cache = mutable.Map.empty[StockType, Double]

    val cached = (stockType: StockType) => {
      lazy val result = cache.getOrElse(stockType, rateProvider(stockType))

      cache += stockType -> result

      result
    }
    cached
  }
}
