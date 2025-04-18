package legacy

class CustomerLegacy {
    var id: String = ""
    var name: String = ""
    var status: String = ""
}

class CustomerService {
    val customers = ArrayList<CustomerLegacy>()

    fun run() {
        registerCustomer("101", "홍길동", "ACTIVE")
        registerCustomer("102", "이순신", "ACTIVE")
        registerCustomer("103", "강감찬", "ACTIVE")
        registerCustomer("104", "율곡이이", "ACTIVE")

        println("모든 고객 조회:")
        listCustomers()

        updateCustomer("101", "홍길순")

        deleteCustomer("104")

        println("모든 고객 조회:")
        listCustomers()
    }

    fun registerCustomer(id: String, name: String, status: String) {
        val c = CustomerLegacy().apply {
            this.id = id
            this.name = name
            this.status = status
        }
        customers.add(c)
        println("고객 등록: $id, $name, $status")
    }

    fun updateCustomer(id: String, newName: String) {
        for (c in customers) {
            if (c.id == id) {
                print("고객 정보 수정: ")
                print("수정 전 - ${c.name}")
                c.name = newName
                println(", 수정 후 - ${c.name}")
                break
            }
        }
    }

    fun deleteCustomer(id: String) {
        for (i in customers.indices) {
            if (customers[i].id == id) {
                customers.removeAt(i)
                println("고객 삭제 완료: $id")
                break
            }
        }
    }

    fun listCustomers() {
        for (c in customers) {
            println("ID: ${c.id}, 이름: ${c.name}, 상태: ${c.status}")
        }
    }
}
