import lab_1.Matrix
import lab_2.*
import lab_3.*

fun main(args: Array<String>) {
    lab_1()
    lab_2()
    lab_3()
}

fun lab_1() {

    println("\nLAB 1\n")

    val A = Matrix(arrayOf(arrayOf(1.0, -2.0, 3.0), arrayOf(4.0, 0.0, 6.0), arrayOf(-7.0, 8.0, 9.0)))
    val B = Matrix(arrayOf(arrayOf(2.0, 1.0, 1.0), arrayOf(1.0, 1.0, 1.0), arrayOf(1.0, 1.0, 1.0)))

    println("Matrix A:\n$A")
    println("Matrix B:\n$B")
    B[0,0] = 1.0
    println("Set 1.0 to B(1,1):\n$B")
    println("A + B:\n${A + B}")
    println("A - B:\n${A - B}")
    println("A * B:\n${A * B}")
    println("A * 2:\n${A * 2.0}")
    println("Det(A):\n${A.determinant()}")
}

fun lab_2() {

    println("\nLAB 2\n")

    val shapes = listOf(
        Circle(3.0),
        Rectangle(1.0, 8.0),
        Square(5.0),
        Square(1.0),
        Triangle(1.0, 2.0, 2.0),
        Triangle(2.0, 3.0, 2.0)
    )

    println("Total area:\n${shapes.sumByDouble { it.calcArea()}}")
    println("Max S:\n${shapes.maxByOrNull { it.calcArea() } }")
    println("Min S:\n${shapes.minByOrNull { it.calcArea() }}")
    println("Max P:\n${shapes.maxByOrNull { it.calcPerimeter() }}")
    println("Min P:\n${shapes.minByOrNull { it.calcPerimeter() }}")
}

fun lab_3() {
    val number1 = PhoneNumber("89000000001", PhoneType.MOBILE)
    val number2 = PhoneNumber("89000100002", PhoneType.HOME)
    val number3 = PhoneNumber("89000000003", PhoneType.WORK)

    val contact1 = Contact("Ivan", "Ivanov", mutableSetOf(number1, number2))
    val contact2 = Contact("Petr", "Petrov", mutableSetOf(number3))
    val contact3 = Contact("Anton", "Antonov", mutableSetOf(PhoneNumber("89004000004", PhoneType.MOBILE)))

    val phoneBook = PhoneBook(mutableSetOf(contact1, contact2))

    println("PhoneBook of 2 contacts:\n$phoneBook")

    phoneBook.addContact("Anna", "Ivanova", "89000000000", PhoneType.MOBILE)
    println("Added contact with parameters:\n$phoneBook")

    phoneBook.addContact(contact3)
    println("Added existed contact:\n$phoneBook")

    phoneBook.removeContact(contact3)
    println("Removed last contact (Anton):\n$phoneBook")

    println("Found contacts by 'Iva':\n${phoneBook.findContacts("Iva")}\n")

    println("Found contacts by '03':\n${phoneBook.findContacts("03")}\n")

    phoneBook.removeContact("Anna")
    println("Removed contact by 'Anna':\n$phoneBook")
}
