package lab_5

import com.google.gson.*
import com.google.gson.reflect.TypeToken
import lab_2.Shape
import java.io.FileNotFoundException
import java.io.FileReader
import java.io.FileWriter
import java.lang.Exception

class ShapeSerializer {
    private val gson: Gson = GsonBuilder()
        .registerTypeAdapter(Shape::class.java, ShapeAdapter())
        .create()

    private val type = object : TypeToken<List<Shape>>() {}.type

    fun convertToJson(shapesList: List<Shape>, fileName: String) {
        try {
            FileWriter(fileName).use {
                gson.toJson(shapesList, type, it)
            }
        } catch (e: Exception) {
            throw Exception(e.message)
        }
    }

    fun convertFromJson(fileName: String): List<Shape> {
        try {
            FileReader(fileName).use {
                return gson.fromJson(it, type)
            }
        } catch (e: Exception) {
            throw FileNotFoundException(e.message)
        }
    }
}