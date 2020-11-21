package lab_3

enum class PhoneType {
    MOBILE,
    WORK,
    HOME
}

data class PhoneNumber (val number: String, val type: PhoneType) {
    override fun toString(): String = "$number ($type)"
}