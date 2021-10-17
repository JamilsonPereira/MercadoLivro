package com.mercadolivro.service

import com.mercadolivro.controller.request.PutCustomerRequest
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
            //retornto com filtro      acessando nome que contem letras conforme minha pesquisa
            //                                             ignoreCase para ignorar letras M e m.
            return customers.filter { it.nome.contains(name, ignoreCase = true) }
        }
        return customers
    }

    fun create(customer: CustomerModel) {
        customerRepository.save(customer)
    }

    fun getCustomer(id: Int): CustomerModel {
        //customer busca filtro, que por sua vez compara se o id que esta sendo passado é igual ao id
        //que esta na aplicação, e o coloca em primeiro lugar
        return customers.filter { it.id == id }.first()
    }
    fun update(customer: CustomerModel) {
        customers.filter { it.id == customer.id }.first().let {
            // o it está acessando o valor da variavel nome
            it.nome = customer.nome

            it.email = customer.email
        }
    }
    fun delete(id: Int) {
        //operação que remove se o id passado for igual ao que esta no codigo
        customers.removeIf { it.id == id }
    }
}