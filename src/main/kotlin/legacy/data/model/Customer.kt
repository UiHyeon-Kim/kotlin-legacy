package legacy.data.model

data class Customer(
    val id: CustomerId,
    val name: CustomerName,
    val status: CustomerState
)