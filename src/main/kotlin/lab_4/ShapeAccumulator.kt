package lab_4

import lab_2.Shape

class ShapeAccumulator {
    private val shapes = mutableListOf<Shape>()

    fun <T : Shape> add(newShape:T) {
        shapes.add(newShape)
    }

    fun <T: Shape> addAll(newShapeList:List<T>) {
        shapes.addAll(newShapeList)
    }

    fun getMaxAreaShape() : Shape? {
        return shapes.maxByOrNull { it.calcArea() }
    }

    fun getMinAreaShape() : Shape? {
        return shapes.minByOrNull { it.calcArea() }
    }

    fun getMaxPerimeterShape() : Shape? {
        return shapes.maxByOrNull { it.calcPerimeter() }
    }

    fun getMinPerimeterShape() : Shape? {
        return shapes.minByOrNull { it.calcPerimeter() }
    }

    fun getTotalArea() : Double {
        return shapes.sumByDouble { it.calcArea()}
    }

    fun getTotalPerimeter() : Double {
        return shapes.sumByDouble { it.calcPerimeter()}
    }
}