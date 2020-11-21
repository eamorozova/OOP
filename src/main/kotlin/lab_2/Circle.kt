package lab_2

import kotlin.IllegalArgumentException

class Circle(private val radius: Double): Shape {
    init {
        if (radius <= 0)
            throw IllegalArgumentException("Error. Radius is incorrect.")
    }

    override fun calcArea(): Double = Math.PI * radius * radius

    override fun calcPerimeter(): Double = 2 * Math.PI * radius

    override fun toString(): String = "Circle (R = $radius) : S = ${calcArea()}, P = ${calcPerimeter()}"
}