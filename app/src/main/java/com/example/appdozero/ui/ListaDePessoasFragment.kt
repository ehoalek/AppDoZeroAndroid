package com.example.appdozero.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.example.appdozero.R
import com.example.appdozero.model.Pessoa
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.pessoa_fragment.*


class ListaDePessoasFragment : Fragment() {

    private lateinit var viewModel: PessoaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(R.layout.lista_de_pessoas, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(PessoaViewModel::class.java)

        viewModel.pessoa.observe(viewLifecycleOwner, { pessoa ->

            txtNome.setText(pessoa.nome)
            txtCPF.setText(pessoa.cpf)
            txtAltura.setText(pessoa.altura.toString())

            view.findViewById<Button>(R.id.btnSalvar).setOnClickListener {

                val nome: String = txtNome.text.toString()
                val cpf: String = txtCPF.text.toString()
                val altura: Double = txtAltura.text.toString().toDouble()

                viewModel.salvarPessoa(
                    Pessoa(
                        id = pessoa.id,
                        nome = nome,
                        cpf = cpf,
                        altura = altura
                    )
                )
                findNavController().navigateUp()
            }
        })
        return view
    }
}