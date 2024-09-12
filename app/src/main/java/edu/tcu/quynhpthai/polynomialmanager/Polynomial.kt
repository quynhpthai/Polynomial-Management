package edu.tcu.quynhpthai.polynomialmanager

class Polynomial(val name: String){
    var terms= mutableListOf<Term>()
    override fun toString(): String {
        return terms.joinToString(" + "){ term ->
            val xPart = if (term.xExpo !=0) "(x^${term.xExpo})" else ""
            val yPart = if (term.yExpo !=0) "(y^${term.yExpo})" else ""
            val zPart = if (term.zExpo !=0) "(z^${term.zExpo})" else ""
            "${term.coefficient}${xPart}${yPart}${zPart}"

        }

    }
}