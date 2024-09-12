package edu.tcu.quynhpthai.polynomialmanager

class Polynomial(val name: String){
    var terms= mutableListOf<Term>()
    override fun toString(): String {
        val result=StringBuilder()
        for (term in terms){
            val xPart= if(term.xExpo>0){
                if(term.xExpo==1){
                    "(x)"
                }else{
                    "(x^${term.xExpo})"

                }
            }else{
                ""
            }
            val yPart= if(term.yExpo>0){
                if(term.yExpo==1){
                    "(y)"
                }else{
                    "(y^${term.yExpo})"

                }

            }else{
                ""
            }
            val zPart= if(term.zExpo>0){
                if(term.zExpo==1){
                    "(z)"
                }else{
                    "(z^${term.zExpo})"

                }
            }else{
                ""
            }
            if(term.coefficient>=0&& result.isNotEmpty()){
                if(term.coefficient==1){
                    result.append(" + $xPart$yPart$zPart")

                }else{
                    result.append(" + ${term.coefficient}$xPart$yPart$zPart")

                }
            }else{
                if (term.coefficient == 1) {
                    result.append("$xPart$yPart$zPart") // Skip printing the coefficient when it's 1
                } else if (term.coefficient == -1) {
                    result.append("- $xPart$yPart$zPart") // For -1, skip the coefficient
                }else{
                    result.append("  ${term.coefficient}$xPart$yPart$zPart")

                }
//                result.append(" ${term.coefficient}$xPart$yPart$zPart")

            }

        }
        return result.toString().trimStart()

    }
}

