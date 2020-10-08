import java.lang.Exception
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException
import java.lang.StringBuilder

class Calculator {
    private var output: StringBuilder = StringBuilder("")
    private var firstNumber: Double = 0.0
    private var secondNumber: Double = 0.0
    private var operations = Operations()
    private var isOperationChosen = false
    private var isNumberChanged = false

    fun process() {
        while(true) {
            try {
                print("\n Calculator 1.0 \n \n ||| ${output.toString()+"_"} ||| \n \n ")
                commands()
                var command = readLine()?.toInt()
                if (command in 2..5) {
                    if(!isNumberChanged)throw IllegalStateException("first of all you need to enter the number\n")
                    isNumberChanged = false
                    isOperationChosen = true
                }
                when (command) {
                    1 -> {
                        print("Enter the digit")
                        addDigit(readLine()?.toDouble() ?: throw IllegalArgumentException())
                    }
                    2 -> sum()
                    3 -> subtract()
                    4 -> multiply()
                    5 -> divide()
                    6 -> result()
                    7 -> clearAll()

                }
            }
            catch(exception : Exception){
                print(exception.message)
            }
        }
    }

    private fun commands() {
        print("Commands: \n1)Add digit \n")
        if(!isOperationChosen)print("2)Sum \n" +
                "3)Sub \n" +
                "4)Multiply \n" +
                "5)Divide \n")
        print("6)Result \n" +
                "7)ClearAll \n")
    }

    private fun addDigit(digit: Double){
        if(!isOperationChosen){
            firstNumber = firstNumber*10+digit
        }
        else{
            secondNumber = secondNumber*10+digit
        }
        output.append(digit.toInt())
        isNumberChanged = true
    }

    private fun sum(){
        operations.setOperation(operations.sum)
        output.append(" + ")
    }

    private fun subtract(){
        operations.setOperation(operations.subtract)
        output.append(" - ")
    }

    private fun multiply(){
        operations.setOperation(operations.multiply)
        output.append(" * ")
    }

    private fun divide(){
        operations.setOperation(operations.divide)
        output.append(" / ")
    }

    private fun result(){
        output.append(" = ")
        output.append(operations.result(firstNumber, secondNumber))
    }

    private fun clearAll(){
        firstNumber = 0.0
        secondNumber = 0.0
        operations.setOperation(null)
        isOperationChosen = false
        isNumberChanged = false
        output.clear()
    }

}

fun main(){
    Calculator().process()
}