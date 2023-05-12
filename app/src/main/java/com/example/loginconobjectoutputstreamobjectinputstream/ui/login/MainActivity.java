package com.example.loginconobjectoutputstreamobjectinputstream.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.loginconobjectoutputstreamobjectinputstream.R;
import  com.example.loginconobjectoutputstreamobjectinputstream.databinding.ActivityMainBinding;
import com.example.loginconobjectoutputstreamobjectinputstream.ui.register.RegistroActivity;

public class MainActivity extends AppCompatActivity {

        private ActivityMainBinding binding;
        private MainActivityViewModel vm;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            binding = ActivityMainBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());
           vm = new ViewModelProvider(this).get(MainActivityViewModel.class);


            // Observar el LiveData que indica si el inicio de sesión es válido
            vm.getLogueado().observe(this, new Observer<Boolean>() {
                @Override
                public void onChanged(Boolean logueado) {
                   vm.loguearse(logueado);
                }
            });

            // Configurar el botón de inicio de sesión
           binding.btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String email = binding.etEmail.getText().toString();
                    String password = binding.etPassword.getText().toString();
                   vm.login(email, password);
                }
            });

            // Configurar el botón de registro y redirige al usuario a la segunda Activity
          binding.btnRegistro.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(MainActivity.this, RegistroActivity.class);
                    startActivity(intent);
                }
            });
        }
    }


