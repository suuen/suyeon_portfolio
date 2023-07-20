package com.example.myapplication


fun main() {

    print("첫 번째 숫자를 입력하세요: ")
    val num1 = readLine()!!.toDouble()

    print("두 번째 숫자를 입력하세요: ")
    val num2 = readLine()!!.toDouble()

    print("사칙연산을 입력하세요: ")
    val operator = readLine()

    if (operator == "+") {
        val result = num1 + num2
        println("덧셈 결과: $result")
    } else if (operator == "-") {
        val result = num1 - num2
        println("뺄셈 결과: $result")
    } else if (operator == "/")
    {
        val result = num1 / num2
        println("나눗셈 연산 결과: $result")
    } else if (operator == "*") {
        val result = num1 * num2
        println("곱셈 연산 결과: $result")
    }
    else if (operator == "%") {
        val result = num1 % num2
        println("나머지 연산 결과: $result")
    }
    else {
        println("잘못된 연산자 입력입니다.")
    }
}