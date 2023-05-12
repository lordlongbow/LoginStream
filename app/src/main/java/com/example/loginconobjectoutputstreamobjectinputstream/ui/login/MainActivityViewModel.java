package com.example.loginconobjectoutputstreamobjectinputstream.ui.login;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.loginconobjectoutputstreamobjectinputstream.modelos.Usuario;
import com.example.loginconobjectoutputstreamobjectinputstream.request.ApiClient;
import com.example.loginconobjectoutputstreamobjectinputstream.ui.register.RegistroActivity;

public class MainActivityViewModel extends AndroidViewModel{

    private MutableLiveData<Boolean> logueado = new MutableLiveData<>();
    private MutableLiveData<String> email;
    private MutableLiveData<String> password;


        private ApiClient apiClient;

    private Context contexto;


    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        apiClient = new ApiClient();
    }
        public LiveData<Boolean> getLogueado() {
            return logueado;
        }

    public LiveData<String> getEmail() {
        if(email == null){
            MutableLiveData email = new MutableLiveData();
        }
        return email;
    }

    public LiveData<String> getPassword() {
        if(password == null){
            MutableLiveData password = new MutableLiveData();
        }
        return password;
    }

    // Validar los campos de inicio de sesión
        public void login(String mail, String password) {

            if (mail.length() == 0 || password.length() == 0) {
                logueado.setValue(false);
                return;
            }
            Usuario usuario = apiClient.login(getApplication(), mail, password);
            if (usuario != null) {
               logueado.setValue(true);

            } else {
                logueado.setValue(false);
            }

        }
    public void loguearse(Boolean logueado){

         if(logueado){
        // Si el inicio de sesión es válido, redirigir al usuario a la segunda Activity
        Intent intent = new Intent(contexto.getApplicationContext(), RegistroActivity.class);
        contexto.startActivity(intent);

    } else {
        // Si el inicio de sesión no es válido, mostrar un mensaje de error
        Toast.makeText(contexto.getApplicationContext(), "Inicio de sesión no válido", Toast.LENGTH_SHORT).show();
    }
    }

}
