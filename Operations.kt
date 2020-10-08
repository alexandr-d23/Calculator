class Operations {
    var sum = Sum()
    var subtract = Subtract()
    var multiply = Multiply()
    var divide = Divide()
    private var currentOperation: Executable? = null

    fun setOperation(operation : Executable?){
        currentOperation = operation
    }

    fun result(firstNumber: Double, secondNumber: Double): Double{
        return currentOperation?.execute(firstNumber,secondNumber) ?: throw IllegalStateException()
    }
}