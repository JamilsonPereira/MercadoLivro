package com.mercadolivro.controller

import com.mercadolivro.controller.request.PostCustomerRequest
import com.mercadolivro.controller.request.PutCustomerRequest
import com.mercadolivro.extension.toCustomerModel
import com.mercadolivro.model.CustomerModel
import com.mercadolivro.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customer")
class CustomerController (
    //Criando uma lista mutavel
    val customerService : CustomerService
){

    @GetMapping
    //Adicionado RequestParam para filtrar por nome
    fun getCustomers(@RequestParam name: String?): List<CustomerModel> {
       return customerService.getall(name)
    }

    @PostMapping
    //No post a resposta http padrão é necessaria por isso usamos essa anotação
    //passando um HttpStatus.Created
    @ResponseStatus(HttpStatus.CREATED)
    //Para não passar um id que geralmente é fornecido automaticamente
    //utilizamos uma classe somente para o Request, no Caso para isso criei a PostCustomerRequest
    fun create(@RequestBody customer : PostCustomerRequest) {
        customerService.create(customer.toCustomerModel())
    }

        @GetMapping("/{id}")
        fun getCustomer(@PathVariable id: Int):CustomerModel {
            return customerService.getById(id)
        }

        @PutMapping("/{id}")
        //Este metodo Http não tem retorno
        @ResponseStatus(HttpStatus.NO_CONTENT)
        fun update(@PathVariable id: Int, @RequestBody customer: PutCustomerRequest) {
            customerService.update(customer.toCustomerModel(id))
        }
        @DeleteMapping("/{id}")
        //Este metodo Http não tem retorno
        @ResponseStatus(HttpStatus.NO_CONTENT)
        fun delete(@PathVariable id: Int) {
                customerService.delete(id)
            }
    }
