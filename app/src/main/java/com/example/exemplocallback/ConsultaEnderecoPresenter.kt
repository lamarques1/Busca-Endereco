package com.example.exemplocallback


import com.example.exemplocallback.service.EnderecoService
import java.lang.Exception

class ConsultaEnderecoPresenter : MainContract.Presenter{

    override fun consultarCep(numeroCep: String, callback: EnderecoCallback){

        if (numeroCep.length == 8){
            try {
                val endereco = EnderecoService(numeroCep).execute().get()
                callback.sucesso(endereco!!)

            }catch (e: Exception){
                e.printStackTrace()
                callback.falha("CEP não encontrado!")
            }

        }else{
            callback.falha("Numero de CEP inválido!")
        }
    }
}