package legacy.data.model

data class Customer(
    val id: CustomerId,
    var name: CustomerName,
    var status: CustomerState
)