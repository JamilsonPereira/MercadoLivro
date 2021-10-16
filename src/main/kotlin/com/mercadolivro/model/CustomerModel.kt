package com.mercadolivro.model

import javax.print.attribute.IntegerSyntax

data class CustomerModel(
    var id: String?=null,
    var nome: String,
    var email: String
)