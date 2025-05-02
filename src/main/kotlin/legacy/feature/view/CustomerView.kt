package legacy.feature.view

import legacy.data.model.Customer
import legacy.feature.contract.CustomerContract

class CustomerView : CustomerContract.View {
    override fun printSystemExecutionMessage() {
        println("===== 고객 관리 시스템 실행 =====\n")
    }

    override fun printCustomerInquiryMessage(customers: List<Customer>) {
        val customerCount = customers.size

        println("----- 고객 조회 결과 -----")
        println("총 고객 수: $customerCount")

        for ((index, customer) in customers.withIndex()) {
            print("${index + 1}. ")
            printCustomer(customer)
        }
    }

    override fun printCustomerAddMessage(customer: Customer) {
        print("[INFO] 고객 등록 성공: ")

    }

    override fun printCustomerUpdateMessage(customer: Customer) {
        print("[INFO] 고객 수정 성공: ")

    }

    override fun printCustomerDeleteMessage(customer: Customer) {
        print("[INFO] 고객 삭제 성공: ")

    }

    private fun printCustomer(customer: Customer) {
        println("ID: ${customer.id} | 이름: ${customer.name} | 상태: ${customer.status}")
    }
}