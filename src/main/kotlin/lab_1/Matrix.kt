package lab_1

import kotlin.IndexOutOfBoundsException
import kotlin.IllegalArgumentException
import kotlin.math.pow

class Matrix(val rows: Int, val columns: Int) {
    private var elements: Array<Array<Double>>

    // initialization of empty matrix
    init {
        if (columns <= 0 || rows <= 0)
            throw IllegalArgumentException("Error. Matrix size should be positive.")

        elements  = Array(rows) { Array(columns) { 0.0 } }
    }

    // constructor via array
    constructor(elements : Array<Array<Double>>) : this(elements[0].size, elements.size) {
        for (i in 0 until this.elements.size - 1)
            if (this.elements[i].size != this.elements[i+1].size)
                throw IllegalArgumentException("Error. Array is incorrect.")

        for (i in 0 until this.rows)
            for (j in 0 until this.columns)
                this.elements[i][j] = elements[i][j]
    }

    // checks if matrix index is correct
    private fun indexIsCorrect(i: Int, j: Int) = !(i < 0 || j < 0 || i >= rows || j >= columns)

    // compares matrices' size
    private fun hasSameSize(other: Matrix) = (this.rows == other.rows && this.columns == other.columns)

    // returns matrix element by index
    operator fun get(i: Int, j: Int) : Double {
        if (!indexIsCorrect(i,j))
            throw IndexOutOfBoundsException("Error. Index is incorrect.")

        return elements[i][j]
    }

    // sets value by index and double
    operator fun set(i: Int, j: Int, value: Double) {
        if (!indexIsCorrect(i, j))
            throw IndexOutOfBoundsException("Error. Index is incorrect.")

        elements[i][j] = value
    }

    // sums two matrices
    operator fun plus(other: Matrix): Matrix {
        if (!hasSameSize(other))
            throw ArithmeticException("Error. Matrices have different size.")

        val sum = Matrix(rows, columns)

        for (i in 0 until rows)
            for (j in 0 until columns)
                sum[i, j] = this[i, j] + other[i, j]

        return sum
    }

    // subtracts two matrices
    operator fun minus(other: Matrix): Matrix {
        if (!hasSameSize(other))
            throw ArithmeticException("Error. Matrices have different size.")

        val difference = Matrix(rows, columns)

        for (i in 0 until rows)
            for (j in 0 until columns)
                difference[i, j] = this[i, j] - other[i, j]

        return difference
    }

    // multiplies two matrices
    operator fun times(other: Matrix): Matrix {
        if (this.columns != other.rows)
            throw ArithmeticException("Error. Matrices are incompatible.")

        val product = Matrix(rows, other.columns)

        for (i in 0 until product.rows)
            for (j in 0 until product.columns)
                for (k in 0 until this.columns)
                    product[i, j] += this[i, k] * other[k, j]

        return product
    }

    // multiplies matrix to scalar
    operator fun times(scalar: Double): Matrix {
        val product = Matrix(rows, columns)

        for (i in 0 until rows)
            for (j in 0 until columns)
                product[i, j] = this[i, j] * scalar

        return product
    }

    // returns matrix size
    fun size(): String = "$rows x $columns"

    // compute determinant
    fun determinant(): Double {
        if (rows != columns)
            throw IllegalArgumentException("Error. Matrix is not square.")
        return determinant(elements)
    }

    // algorithm of determinant computing
    private fun determinant(elements: Array<Array<Double>>): Double {
        var result = 0.0

        if (elements.size == 1) {
            result = elements[0][0]
            return result
        }
        if (elements.size == 2) {
            result = elements[0][0] * elements[1][1] - elements[0][1] * elements[1][0]
            return result
        }
        for (i in elements[0].indices) {
            val temp = Array(elements.size - 1) { Array(elements[0].size - 1) { 1.0 } }
            for (j in 1 until elements.size) {
                for (k in elements[0].indices) {
                    if (k < i) {
                        temp[j - 1][k] = elements[j][k]
                    } else if (k > i) {
                        temp[j - 1][k - 1] = elements[j][k]
                    }
                }
            }
            result += elements[0][i] * (-1.0).pow(i.toDouble()) * determinant(temp)
        }
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Matrix)
            return false
        if (this === other)
            return true
        if (rows != other.rows || columns != other.columns)
            return false
        for (i in 0 until rows)
            for (j in 0 until columns)
                if (this[i, j] != other[i, j])
                    return false
        return true
    }

    override fun toString(): String {
        var stringMatrix = String()

        for (i in 0 until rows) {
            for (j in 0 until columns)
                stringMatrix += "${this[i,j]} "
            stringMatrix += '\n'
        }

        return stringMatrix
    }

    override fun hashCode(): Int {
        var result = rows
        result = 31 * result + columns
        result = 31 * result + rows
        return result
    }
}