package com.example.exemplocallback


import com.example.exemplocallback.model.Endereco
import com.example.exemplocallback.service.EnderecoService
import com.google.gson.Gson
import java.lang.Exception

class ConsultaEnderecoPresenter : MainContract.Presenter{

    override fun consultarCep(numeroCep: String, callback: EnderecoCallback){

        if (numeroCep.length == 8){
            try {
                val endereco = EnderecoService(numeroCep).execute().get()
                    .let {
                        Gson().fromJson(it, Endereco::class.java)
                    }
                callback.sucesso(endereco)

            }catch (e: Exception){
                e.printStackTrace()
                callback.falha("Erro ao buscar CEP!")
            }

        }else{
            callback.falha("Numero de CEP inválido!")
        }
    }
}