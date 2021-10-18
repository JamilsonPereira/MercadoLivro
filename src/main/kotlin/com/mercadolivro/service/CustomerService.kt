package com.mercadolivro.service

import com.mercadolivro.model.CustomerModel
import com.mercadolivro.repository.CustomerRepository
import org.springframework.stereotype.Service


@Service
class CustomerService(
    val customerRepository : CustomerRepository
) {

    val customers = mutableListOf<CustomerModel>()

    fun getall(name: String?): List<CustomerModel> {
        //se nome não for nullo então faça o filtro
        name?.let {

            return customerRepository.findByNameContaining(it) }

        return customerRepository.findAll().toList()
    }

    fun create(customer: CustomerModel) {
        customerRepository.save(customer)
    }

    fun getById(id: Int): CustomerModel {

        //busca por id e adicionado o orElseThrow, que por está recebendo um Optional é colocado essa
        // função pro codigo funcionar
        return customerRepository.findById(id).orElseThrow()
    }
    fun update(customer: CustomerModel) {
      if(!customerRepository.existsById(customer.id!!)){
          throw Exception("Id não existe")
      }
       customerRepository.save(customer)
    }
    fun delete(id: Int) {
        customerRepository.deleteById(id)
    }
}