package com.mercadolivro.controller.request

import com.fasterxml.jackson.annotation.JsonAlias
import java.math.BigDecimal

class PostBookRequest (
    var nome: String,
    var price: BigDecimal,
    @JsonAlias("customer_id")
    var customerId : Int
    )