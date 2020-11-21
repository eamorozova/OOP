package lab_3

class PhoneBook(private var contacts: MutableSet<Contact>) {
    init {
        mutableListOf<Contact>()
    }

    // Adds existed contact to phonebook
    fun addContact(contact: Contact) {
        contacts.add(contact)
    }

    // adds contact to phonebook with name and phone number
    fun addContact(firstName: String, lastName: String, phoneNumber: String, phoneType: PhoneType) {
        val newContact = Contact(firstName, lastName, mutableSetOf(PhoneNumber(phoneNumber, phoneType)))
        contacts.add(newContact)
    }

    // removes contact from phonebook
    fun removeContact(contact: Contact) {
        contacts.remove(contact)
    }

    // removes contact from phonebook by substring
    fun removeContact(substring: String) {
        val requested = this.findContacts(substring)
        contacts.removeAll(requested)
    }

    // searches contacts in phonebook by substring
    fun findContacts(substring: String): List<Contact> {
        return contacts.filter { contact ->
            (contact.firstName.contains(substring) ||
                    contact.lastName.contains(substring) ||
                    contact.phoneNumbers.any { phoneNumber ->
                        phoneNumber.number.contains(substring)
                    })
        }
    }

    override fun toString(): String {
        var result = ""
        contacts.forEach { contact -> result += "$contact\n" }
        return result
    }
}