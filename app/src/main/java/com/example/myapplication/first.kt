package com.example.myapplication

object Calculator{
    fun add(num1:Double,num2:Double)
    {
        val result = num1 + num2
        println("덧셈 결과: $result")
    }
    fun sub(num1:Double,num2: Double)
    {
        val result = num1 - num2
        println("뺄셈 결과: $result")
    }
    fun mul(num1:Double,num2:Double)
    {
        val result = num1 * num2
        println("곱셈 결과: $result")
    }
    fun div(num1:Double,num2: Double)
    {
        if(num2 != 0.0 ){
            val result = num1 / num2
            println("나눗셈 결과: $result")
        } else {
            println("0으로 나눌 수 없습니다.")
        }

    }
    fun reamain(num1:Double,num2:Double)
    {
        val result = num1 % num2
        println("나머지 연산 결과 : ${result}")
    }

    }

fun main() {

    print("첫 번째 숫자를 입력하세요: ")
    val num1 = readLine()!!.toDouble()

    print("두 번째 숫자를 입력하세요: ")
    val num2 = readLine()!!.toDouble()

    print("사칙연산을 입력하세요: ")
    val operator = readLine()

    if (operator == "+") {
        Calculator.add(num1,num2)
    } else if (operator == "-") {
        Calculator.sub(num1,num2)
    } else if (operator == "/")
    {
        Calculator.div(num1,num2)
    } else if (operator == "*") {
        Calculator.mul(num1,num2)
    } else if (operator == "%"){
        Calculator.reamain(num1,num2)
    }

    else {
        println("잘못된 연산자 입력입니다.")
    }
}