package lab_3

data class Contact(val firstName: String, val lastName: String, val phoneNumbers: MutableSet<PhoneNumber>) {
    override fun toString(): String = "$firstName $lastName $phoneNumbers"
}