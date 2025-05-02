package legacy

import legacy.data.repository.CustomerRepository
import legacy.data.repository.CustomerRepositoryImpl
import legacy.feature.contract.CustomerContract
import legacy.feature.presenter.CustomerPresenter
import legacy.feature.view.CustomerView

fun main() {
    val customerView: CustomerContract.View = CustomerView()
    val repository: CustomerRepository = CustomerRepositoryImpl()
    val customerPresenter: CustomerContract.Presenter = CustomerPresenter(customerView, repository)
    customerPresenter.execute()
}