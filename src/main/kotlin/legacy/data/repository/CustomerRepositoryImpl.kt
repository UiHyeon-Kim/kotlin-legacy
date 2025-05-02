package legacy.data.repository

import legacy.data.model.Customer
import legacy.data.model.CustomerId
import legacy.data.model.CustomerName
import legacy.data.model.CustomerState

class CustomerRepositoryImpl : CustomerRepository {
    private val customers = mutableListOf<Customer>()

    override fun insertCustomer(id: String, name: String, status: CustomerState) {
        customers.add(Customer(CustomerId(id), CustomerName(name), status))
    }

    override fun updateCustomer(id: String, name: String) {
        selectCustomer(id)?.name = CustomerName(name)
    }

    override fun deleteCustomer(customer: Customer) {
        customers.remove(customer)
    }

    override fun selectCustomer(id: String): Customer? =
        customers.find { it.id == CustomerId(id) }


    override fun getCustomers(): List<Customer> = customers.toList()
}