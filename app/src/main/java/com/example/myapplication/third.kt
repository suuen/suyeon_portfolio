package com.example.myapplication


interface Operation{
    fun calculate(num1 : Double,num2 : Double) : Double
}

class Add : Operation{
    override fun calculate(num1: Double, num2: Double): Double {
        return num1 + num2

    }
}

class Sub : Operation{
    override fun calculate(num1: Double, num2: Double): Double {
        return num1 - num2
    }
}

class Mul : Operation{
    override fun calculate(num1: Double, num2: Double): Double {
        return num1 * num2
    }
}

class Div : Operation{
    override fun calculate(num1: Double, num2: Double): Double {
        if (num2 != 0.0) {
            return num1 / num2
        } else {
            throw IllegalArgumentException("0으로 나눌 수 없습니다.")
        }
    }
    }

class Carcluator(private val operation: Operation)
{
    fun operation(num1:Double,num2:Double) : Double{
        return operation.calculate(num1,num2)
    }
}

fun main() {
        print("첫번째 숫자를 입력해주세요: ")
        val num1 = readLine()!!.toDouble()

        print("사칙연산을 입력하세요 (+, -, *, / 중에서 선택): ")
        val operator = readLine()

        print("두번째 숫자를 입력해주세요: ")
        val num2 = readLine()!!.toDouble()

        val operation: Operation = when (operator) {
            "+" -> Add()
            "-" -> Sub()
            "*" -> Mul()
            "/" -> Div()
            else -> throw IllegalArgumentException("잘못된 입력입니다.")
        }

        val calculator = Carcluator(operation)
        val result = calculator.operation(num1, num2)
        println("결과: $result")
    }



