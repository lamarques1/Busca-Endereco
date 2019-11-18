package com.example.exemplocallback

import com.example.exemplocallback.model.Endereco

interface EnderecoCallback {
    fun sucesso(endereco: Endereco)
    fun falha(erro: String)
}