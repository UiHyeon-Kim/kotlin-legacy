package legacy.feature.contract

import legacy.data.model.Customer
import legacy.data.model.CustomerState

interface CustomerContract {
    interface View {
        fun printSystemExecutionMessage()
        fun printCustomerInquiryMessage(customers: List<Customer>)
        fun printCustomerAddMessage(customer: Customer)
        fun printCustomerUpdateMessage(customer: Customer)
        fun printCustomerDeleteMessage(customer: Customer)
    }

    interface Presenter {
        fun execute()
        fun registerCustomer(id: String, name: String, status: CustomerState)
        fun updateCustomer(id: String, newName: String)
        fun deleteCustomer(id: String)
        fun inquiryCustomer()
    }
}