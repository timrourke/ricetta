package com.timrourke.ricetta.model

import scala.annotation.tailrec

sealed trait UnaryProcess[P <: PhaseOfMatter] {
  self: Process[P] =>
  val item: Amount[_]

  final override def toString: String = s"$verb $item"
}

sealed trait BinaryProcess[P <: PhaseOfMatter] {
  self: Process[P] =>
  val item1: Amount[_]
  val item2: Amount[_]
  val items: Seq[Amount[_]]

  final override def toString: String = {
    Process.append(s"$verb $item1", item2 :: items.toList)
  }
}

sealed abstract class Process[P <: PhaseOfMatter] {
  val verb: String
}

object Process {

  final case class Mix[P <: PhaseOfMatter](item1: Amount[_],
                                           item2: Amount[_],
                                           items: Amount[_]*)
    extends Process[P]
      with BinaryProcess[P] {
    override val verb: String = "mix"
  }

  final case class Chop[P <: PhaseOfMatter](item: Amount[_])
    extends Process[P]
      with UnaryProcess[P] {
    override val verb: String = "chop"
  }

  final case class ChopN[P <: PhaseOfMatter](item1: Amount[_],
                                             item2: Amount[_],
                                             items: Amount[_]*)
    extends Process[P]
      with BinaryProcess[P] {
    override val verb: String = "chop"
  }

  @tailrec
  def append(string: String, rest: List[Amount[_]]): String = {
    rest match {
      case ::(head, Nil) => append(string + s", and $head", Nil)
      case ::(head, tail) => append(string + s", $head", tail)
      case Nil => string
    }
  }
}
