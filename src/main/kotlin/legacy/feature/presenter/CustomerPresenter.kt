package legacy.feature.presenter

import legacy.data.model.Customer
import legacy.data.model.CustomerId
import legacy.data.model.CustomerName
import legacy.data.model.CustomerState
import legacy.feature.contract.CustomerContract
import kotlin.properties.Delegates

class CustomerPresenter: CustomerContract.Presenter {
    private val customers = mutableListOf<Customer>()
    override fun execute() {
        println("===== 고객 관리 시스템 실행 =====\n")
        scenario()
    }

    override fun registerCustomer(id: String, name: String, status: CustomerState) {
        customers.add(Customer(CustomerId(id), CustomerName(name), status))
        println("[INFO] 고객 등록 성공: ID: $id | 이름: ${name.padStart(4)} | 상태: $status")
    }

    override fun updateCustomer(id: String, newName: String) {
        val customer = customers.find { it.id == CustomerId(id) }
            ?: throw IllegalArgumentException("아이디 못찾음 에러")

        var changeCustomer by Delegates.observable(customer.name) { _, oldName, newName ->
            println("[INFO] 고객 수정 성공: ${oldName.id} -> ${newName.id}")
        }
        changeCustomer = CustomerName(newName)
        customer.name = changeCustomer
    }

    override fun inquiryCustomer() {
        val customerCount = customers.size

        println("\n----- 고객 조회 결과 -----")
        println("총 고객 수: $customerCount")
        for ((index, customer) in customers.withIndex()) {
            println("${index + 1}. ID: ${customer.id.id} | 이름: ${customer.name.id.padStart(4)} | 상태: ${customer.status}")
        }
        println()
    }

    override fun deleteCustomer(id: String) {
        TODO("Not yet implemented")
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