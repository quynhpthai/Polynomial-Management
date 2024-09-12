package edu.tcu.quynhpthai.polynomialmanager

class PolyList {
    private val polynomials = mutableListOf<Polynomial>()
    fun insertPoly(name: String, terms: List<Term>): String {
        if(polynomials.any {it.name==name}){
            return "POLYNOMIAL $name ALREADY INSERTED"
        }else{
            val polynomial=Polynomial(name)
            polynomial.terms.addAll(terms)
            polynomials.add(polynomial)
            return "$name =$polynomial"
        }

    }
        fun deletePolynomial(name: String): String {
            val poly=polynomials.find {it.name == name}
            if (poly!= null){
                polynomials.remove(poly)
                return "POLYNOMIAL $name SUCCESSFULLY DELETED"
            } else{
                return "POLYNOMIAL $name DOES NOT EXIST"
            }
        }
        fun searchPolynomial(name: String): String {
            val poly=polynomials.find {it.name == name}
            return  poly?.let {"$name = $it"} ?: "POLYNOMIAL $name DOES NOT EXIST"
        }
}