package edu.tcu.quynhpthai.polynomialmanager
// this class to format the polynomial, it store the polynomial name and the term information
class Polynomial(val name: String){
    var terms= mutableListOf<Term>()//list of term
    override fun toString(): String {//function to convert a polynomial class into a string
        val result=StringBuilder()
        for (term in terms){// traverse to all the term in a polynomial
            val xPart= if(term.xExpo>0){//if the exponent is larger than 0 print it out
                if(term.xExpo==1){
                    "(x)"
                }else{
                    "(x^${term.xExpo})"

                }
            }else{
                ""
            }
            val yPart= if(term.yExpo>0){//if the exponent is larger than 0 print it out
                if(term.yExpo==1){
                    "(y)"
                }else{
                    "(y^${term.yExpo})"

                }

            }else{
                ""
            }
            val zPart= if(term.zExpo>0){//if the exponent is larger than 0 print it out
                if(term.zExpo==1){
                    "(z)"
                }else{
                    "(z^${term.zExpo})"

                }
            }else{
                ""
            }
            if(term.coefficient>0&& result.isNotEmpty()){// if the coefficient is non negative and not the first term
                //then append the coefficient with the sign
                if(term.coefficient==1){
                    result.append(" + $xPart$yPart$zPart")

                }
                else{
                    result.append(" + ${term.coefficient}$xPart$yPart$zPart")

                }
            }else if(term.coefficient<0 || result.isEmpty()){//if it's negative, put the nagative sign before it and take the absolute vale
                //if it's the first term, then only print the sign if it's negative
                if(term.coefficient == -1) {
                    result.append(" - $xPart$yPart$zPart") // Skip printing the coefficient when it's 1
                }else if(term.coefficient < -1){
                    result.append(" - ${-term.coefficient}$xPart$yPart$zPart")

                }else if(term.coefficient == 1){
                    result.append(" $xPart$yPart$zPart")

                }
                else if(term.coefficient>0){
                    result.append(" ${term.coefficient}$xPart$yPart$zPart")
                }
            }




        }
        result.insert(0, "$name =")
        return result.toString().trimStart()

    }
}

