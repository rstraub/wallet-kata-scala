package nl.codecraftr.scala.kata.wallet

sealed trait StockType

case object Petroleum extends StockType
case object Gold extends StockType
case object Dollar extends StockType
case object Euro extends StockType
