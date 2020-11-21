package lab_2

import kotlin.math.sqrt

class Triangle(private val a: Double, private val b: Double, private val c: Double): Shape {
    init {
        if (a <= 0 || b <= 0 || c <= 0)
            throw IllegalArgumentException("Error. Values are incorrect.")
        if (a + b <= c || a + c <= b || b + c <= a)
            throw ArithmeticException("Error. Incorrect triangle's edges.")
    }

    override fun calcArea(): Double {
        val p = calcPerimeter() / 2

        return sqrt(p * (p - a) * (p - b) * (p - c))
    }

    override fun calcPerimeter(): Double = a + b + c

    override fun toString(): String = "Triangle (a = $a, b = $b, c = $c) : S = ${calcArea()}, P = ${calcPerimeter()}"
}