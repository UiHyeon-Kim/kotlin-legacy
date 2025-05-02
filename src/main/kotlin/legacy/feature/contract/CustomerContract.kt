package legacy.feature.contract

import legacy.data.model.Customer
import legacy.data.model.CustomerState

interface CustomerContract {
    interface View {
        fun printSystemExecutionMessage()
        fun printCustomerAddMessage(id: String, name: String, status: CustomerState)
        fun printCustomerUpdateMessage(id: String, oldName: String, newName: String)
        fun printCustomerDeleteMessage(id: String, name: String)
        fun printCustomerInquiryMessage(customers: List<Customer>)
    }

    interface Presenter {
        fun execute()
        fun registerCustomer(id: String, name: String, status: CustomerState)
        fun updateCustomer(id: String, newName: String)
        fun deleteCustomer(id: String)
        fun inquiryCustomer()
    }
}