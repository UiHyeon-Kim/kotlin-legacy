package legacy.data.repository

import legacy.data.model.Customer
import legacy.data.model.CustomerState

interface CustomerRepository {
    fun insertCustomer(id: String, name: String, status: CustomerState)
    fun updateCustomer(id: String, name: String)
    fun deleteCustomer(customer: Customer)
    fun selectCustomer(id: String): Customer?
    fun getCustomers(): List<Customer>
}