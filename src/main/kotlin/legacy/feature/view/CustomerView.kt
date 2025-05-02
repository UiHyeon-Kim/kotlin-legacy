package legacy.feature.view

import legacy.data.model.Customer
import legacy.data.model.CustomerState
import legacy.feature.contract.CustomerContract

class CustomerView : CustomerContract.View {
    override fun printSystemExecutionMessage() {
        println("===== 고객 관리 시스템 실행 =====\n")
    }

    override fun printCustomerAddMessage(id: String, name: String, status: CustomerState) {
        print("[INFO] 고객 등록 성공: ")
        printCustomer(id, name, status)
    }

    override fun printCustomerUpdateMessage(id: String, oldName: String, newName: String) {
        val changeName = "$oldName -> $newName"
        print("[INFO] 고객 수정 성공: ")
        printCustomer(id, changeName)
    }

    override fun printCustomerDeleteMessage(id: String, name: String) {
        print("[INFO] 고객 삭제 성공: ")
        printCustomer(id, name)
    }

    override fun printCustomerInquiryMessage(customers: List<Customer>) {
        val customerCount = customers.size

        println("\n----- 고객 조회 결과 -----")
        println("총 고객 수: $customerCount")
        for ((index, customer) in customers.withIndex()) {
            print("${index + 1}. ")
            printCustomer(customer.id.id, customer.name.id, customer.status)
        }
        println()
    }

    private fun printCustomer(id: String, name: String, status: CustomerState? = null) {
        when (status) {
            null -> println("ID: $id | 이름: $name")
            else -> println("ID: $id | 이름: $name | 상태: $status")
        }
    }
}