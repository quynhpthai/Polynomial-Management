package edu.tcu.quynhpthai.polynomialmanager
class PolyManager {
        // Method to run the program logic
        private  val polyList=PolyList()
        fun run() {
            while (true) {
                println("Enter a command (INSERT, DELETE, SEARCH, or QUIT):")
                val userInput = readlnOrNull() ?: break

                if (userInput.equals("QUIT", ignoreCase = true)) {
                    println("Exiting the program")
                    break
                }

                val commandParts = userInput.split(" ")
                if(commandParts.isEmpty()) println("Invalid command")
                val command = commandParts[0].uppercase()
                var result: String

                when (command) {
                    "INSERT" -> {
                        if (commandParts.size < 3) {
                            println("Invalid INSERT command format. Usage: INSERT [name] [term]")
                        } else {
                            val name = commandParts[1]
                            val term = commandParts.drop(2).map {
                                val termParts=it.split(",").map(String::toInt)
                                Term(termParts[0], termParts[1],termParts[2], termParts[3])
                            }
                            result=polyList.insertPoly(name,term)
//                           println("Inserting polynomial $name with term $term")
                            println(result)

                        }
                    }
                    "DELETE" -> {
                        if (commandParts.size < 2) {
                            println("Invalid DELETE command format. Usage: DELETE [name]")
                        } else {
                            val name = commandParts[1]
                            result=polyList.deletePolynomial(name)
                            println(result)

                        }
                    }
                    "SEARCH" -> {
                        if (commandParts.size < 2) {
                            println("Invalid SEARCH command format. Usage: SEARCH [name]")
                        } else {
                            val name = commandParts[1]
                            result=polyList.searchPolynomial(name)
                            println(result)

                        }
                    }
                    else -> {
                        println("Unknown command: $command")
                    }
                }
            }
        }


        // Companion object with the main function
        companion object {
            @JvmStatic
            fun main(args: Array<String>) {
                val polyManager = PolyManager()  // Create an instance of PolyManager
                polyManager.run()  // Run the program logic
            }
        }
}

