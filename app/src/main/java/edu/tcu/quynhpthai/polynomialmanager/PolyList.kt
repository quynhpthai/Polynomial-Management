package edu.tcu.quynhpthai.polynomialmanager

class PolyList {
    private val polynomials = mutableListOf<Polynomial>()
    fun insertPoly(name: String, terms: List<Term>): String {
        if(polynomials.any {it.name==name}){// if there's already a polynomial
            return "POLYNOMIAL $name ALREADY INSERTED"
        }else{//if there's no polynomial
            val polynomial=Polynomial(name)
            polynomial.terms.addAll(terms)
            polynomials.add(polynomial)
            return "$polynomial"
        }

    }
        fun deletePolynomial(name: String): String {//delete polynomial
            val poly=polynomials.find {it.name == name}
            if (poly!= null){//if there's an existing poly name
                polynomials.remove(poly)
                return "POLYNOMIAL $name SUCCESSFULLY DELETED"
            } else{// else return false
                return "POLYNOMIAL $name DOES NOT EXIST"
            }
        }
        fun searchPolynomial(name: String): String {//search polynomial
            val polyVal=polynomials.find{it.name==name}
            if(polyVal != null){
                return "$polyVal"
            }
            return "POLYNOMIAL $name DOES NOT EXIST"

        }
}