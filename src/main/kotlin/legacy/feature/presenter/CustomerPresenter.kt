package legacy.feature.presenter

import legacy.data.model.CustomerState
import legacy.data.repository.CustomerRepository
import legacy.feature.contract.CustomerContract
import kotlin.properties.Delegates

class CustomerPresenter(
    private val customerView: CustomerContract.View,
    private val repository: CustomerRepository
) : CustomerContract.Presenter {
    override fun execute() {
        customerView.printSystemExecutionMessage()
        scenario()

        // TODO 추가 기능 구현 예정
    }

    override fun registerCustomer(id: String, name: String, status: CustomerState) {
        repository.insertCustomer(id, name, status)
        customerView.printCustomerAddMessage(id, name, status)
    }

    override fun updateCustomer(id: String, newName: String) {
        val customer = repository.selectCustomer(id)
        var changeCustomer by Delegates.observable(customer.name.id) { _, oldName, newName ->
            customerView.printCustomerUpdateMessage(customer.id.id, oldName, newName)
        }
        changeCustomer = newName
        repository.updateCustomer(id, changeCustomer)
    }

    override fun deleteCustomer(id: String) {
        val customer = repository.selectCustomer(id)
            .apply { repository.deleteCustomer(this) }

        customerView.printCustomerDeleteMessage(id, customer.name.id)
    }

    override fun inquiryCustomer() {
        val customers = repository.getCustomers()
        customerView.printCustomerInquiryMessage(customers)
    }

    private fun scenario() {
        registerCustomer("101", "홍길동", CustomerState.ACTIVITY)
        registerCustomer("102", "이순신", CustomerState.VIP)
        registerCustomer("103", "강감찬", CustomerState.ACTIVITY)
        registerCustomer("104", "율곡이이", CustomerState.ACTIVITY)

        inquiryCustomer()
        updateCustomer("101", "홍길순")
        deleteCustomer("104")
        inquiryCustomer()
    }
}