package com.example.appdozero.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appdozero.db.Banco
import com.example.appdozero.model.Pessoa
import com.example.appdozero.repository.PessoaRepository
import kotlinx.coroutines.launch

class PessoaViewModel(app: Application) : AndroidViewModel(app) {

    var pessoa = MutableLiveData<Pessoa>()
    var repository = PessoaRepository()
    var listaDePessoas = repository.listaDePessoas

}