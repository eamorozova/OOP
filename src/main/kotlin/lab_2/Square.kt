package lab_2

class Square(val edge: Double): Rectangle(edge, edge) {
    override fun toString(): String = "Square (a = $edge) : S = ${calcArea()}, P = ${calcPerimeter()}"
}