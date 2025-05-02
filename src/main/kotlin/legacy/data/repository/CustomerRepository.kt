package legacy.data.repository

import legacy.data.model.CustomerState

interface CustomerRepository {
    fun insertCustomer(id: String, name: String, status: CustomerState)
    fun updateCustomer(id: String, newName: String)
    fun deleteCustomer(id: String)
    fun selectCustomer()
}