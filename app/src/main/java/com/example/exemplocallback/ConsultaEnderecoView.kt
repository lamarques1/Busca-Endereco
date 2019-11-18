package com.example.exemplocallback

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.exemplocallback.model.Endereco

class ConsultaEnderecoView : AppCompatActivity(), MainContract.View {

    lateinit var presenter : MainContract.Presenter

    private lateinit var cep : EditText
    private lateinit var btnBuscar: Button

    private lateinit var layout: LinearLayout
    private lateinit var estado : TextView
    private lateinit var cidade : TextView
    private lateinit var bairro : TextView
    private lateinit var logradouro : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consultar_endereco)

        setPresenter()

        cep = findViewById(R.id.cep)
        btnBuscar = findViewById(R.id.btnBuscar)

        layout = findViewById(R.id.enderecoInfoLayout)
        estado = findViewById(R.id.txtEstado)
        cidade = findViewById(R.id.txtCidade)
        bairro = findViewById(R.id.txtBairro)
        logradouro = findViewById(R.id.txtLogradouro)

        btnBuscar.setOnClickListener {
            /**
             * IMPLEMENTAÇÃO CALLBACK
             */
            presenter.consultarCep(cep.text.toString(), object : EnderecoCallback{
                override fun sucesso(endereco: Endereco) {
                    exibirEndereco(endereco)
                }

                override fun falha(erro: String) {
                    exibirMensagemErro(erro)
                }

            })
        }
    }

    override fun setPresenter() {
        presenter = ConsultaEnderecoPresenter()
    }

    override fun exibirEndereco(endereco: Endereco) {
        layout.visibility = View.VISIBLE
        estado.text = endereco.estado
        cidade.text = endereco.cidade
        bairro.text = endereco.bairro
        logradouro.text = endereco.logradouro
    }

    override fun exibirMensagemErro(erro: String) {
        layout.visibility = View.GONE
        Toast.makeText(this, erro, Toast.LENGTH_SHORT).show()
    }
}
