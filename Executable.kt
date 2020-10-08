import java.lang.UnsupportedOperationException

open class Executable {
    open fun execute(firstNumber:Double, secondNumber: Double):Double{
        throw UnsupportedOperationException()
    }

}