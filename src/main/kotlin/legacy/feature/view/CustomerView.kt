package legacy.feature.view

import legacy.data.model.Customer
import legacy.data.model.CustomerState
import legacy.feature.contract.CustomerContract

class CustomerView : CustomerContract.View {
    override fun printSystemExecutionMessage() {
        println(SYSTEM_EXECUTION_MESSAGE)
    }

    override fun printCustomerAddMessage(id: String, name: String, status: CustomerState) {
        print(REGISTRATION_SUCCESS)
        printCustomer(id, name, status)
    }

    override fun printCustomerUpdateMessage(id: String, oldName: String, newName: String) {
        val changeName = "$oldName -> $newName"
        print(MODIFICATION_SUCCESS)
        printCustomer(id, changeName)
    }

    override fun printCustomerDeleteMessage(id: String, name: String) {
        print(DELETION_SUCCESS)
        printCustomer(id, name)
    }

    override fun printCustomerInquiryMessage(customers: List<Customer>) {
        val customerCount = customers.size

        println(INQUIRY_RESULT_MESSAGE)
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

    companion object {
        private const val INFO = "[INFO]"

        private const val SYSTEM_EXECUTION_MESSAGE = "===== 고객 관리 시스템 실행 =====\n"
        private const val INQUIRY_RESULT_MESSAGE = "\n----- 고객 조회 결과 -----"

        private const val REGISTRATION_SUCCESS = "$INFO 고객 등록 성공: "
        private const val MODIFICATION_SUCCESS = "$INFO 고객 수정 성공: "
        private const val DELETION_SUCCESS = "$INFO 고객 삭제 성공: "
    }
}