package com.example.exemplocallback.service

import android.os.AsyncTask
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

class EnderecoService(val cep : String): AsyncTask<Void, Void, String>() {

    override fun doInBackground(vararg params: Void?): String {
        var response = ""

        val url =  URL("https://api.postmon.com.br/v1/cep/$cep")
        val connection = url.openConnection() as HttpURLConnection

        try {
            connection.requestMethod = "GET"
            connection.doOutput = true
            connection.connectTimeout = 5000
            connection.connect()

            response = url.readText()
            return response

        }catch (e : Exception){
            e.printStackTrace()
        }

        return response
    }
}