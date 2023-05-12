package com.example.loginconobjectoutputstreamobjectinputstream.ui.register;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import  com.example.loginconobjectoutputstreamobjectinputstream.databinding.RegistroActivityBinding;

public class RegistroActivity extends AppCompatActivity {

    private RegistroActivityBinding binding;
    private RegistroActivityViewModel vm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = RegistroActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        vm = new ViewModelProvider(this).get(RegistroActivityViewModel.class);


        // observar el LiveData para mostrar un mensaje de confirmación cuando se guarden los datos del usuario
       vm.getDatosGuardados().observe(this, new Observer<Boolean>() {
           @Override
           public void onChanged(Boolean aBoolean) {
                vm.guardarUsuario(RegistroActivity.this);
           }
       });
    }



}
