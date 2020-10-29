package com.example.appdozero.model


data class Pessoa (

    var docId : String,
    var nome : String,
    var cpf : String,
    var foto : String,
    var altura : Int
)
{
    constructor() : this(String(), String(), String(), String(),0)
}