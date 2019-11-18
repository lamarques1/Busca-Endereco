package com.example.exemplocallback

import com.example.exemplocallback.model.Endereco

interface MainContract {
    interface View{
        fun setPresenter()
        fun exibirEndereco(endereco: Endereco)
        fun exibirMensagemErro(erro: String)
    }
    interface Presenter{
        fun consultarCep(numeroCep : String, callback : EnderecoCallback)
    }
}