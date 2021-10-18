package com.mercadolivro.service

import com.mercadolivro.model.BookModel
import com.mercadolivro.model.CustomerModel
import com.mercadolivro.repository.BookRepository
import org.springframework.stereotype.Service


@Service
class BookService(
    val bookRepository: BookRepository
) {

    val books = mutableListOf<BookModel>()

    fun getall(name: String?): List<BookModel> {
        //se nome não for nullo então faça o filtro
        name?.let {

            return bookRepository.findByNameContaining(name) }

        return bookRepository.findAll().toList()
    }

    fun create(book: BookModel) {
        bookRepository.save(book)
    }

    fun getCustomer(id: Int): BookModel {

        //busca por id e adicionado o orElseThrow, que por está recebendo um Optional é colocado essa
        // função pro codigo funcionar
        return bookRepository.findById(id).orElseThrow()
    }
    fun update(book: BookModel) {

      if(!bookRepository.existsById(book.id!!)){
          throw Exception("Id não existe")
      }
       bookRepository.save(book)
    }
    fun delete(id: Int) {
        bookRepository.deleteById(id)
    }


}