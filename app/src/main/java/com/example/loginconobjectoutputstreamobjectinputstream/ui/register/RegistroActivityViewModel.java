package com.example.loginconobjectoutputstreamobjectinputstream.ui.register;

import static com.example.loginconobjectoutputstreamobjectinputstream.request.ApiClient.guardar;
import static com.example.loginconobjectoutputstreamobjectinputstream.request.ApiClient.leer;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.loginconobjectoutputstreamobjectinputstream.modelos.Usuario;

public class RegistroActivityViewModel extends AndroidViewModel {


    private Context contexto;
        private MutableLiveData<String> nombre = new MutableLiveData<>();
        private MutableLiveData<String> apellido = new MutableLiveData<>();
        private MutableLiveData<String> email = new MutableLiveData<>();
    private MutableLiveData<Long> dni = new MutableLiveData<>();
        private MutableLiveData<String> password = new MutableLiveData<>();
        private MutableLiveData<Boolean> datosValidos = new MutableLiveData<>();

    public MutableLiveData<Boolean> getDatosGuardados() {
        return datosGuardados;
    }

    private MutableLiveData<Boolean> datosGuardados = new MutableLiveData<>();

    public RegistroActivityViewModel(@NonNull Application application) {
        super(application);
    }


    public void guardarUsuario(Context contexto) {
        if (!validarCampos(contexto)) {
            return;
        }
        Usuario usuario = new Usuario(nombre.getValue(), email.getValue(), password.getValue(), apellido.getValue(), dni.getValue() );
       guardar(contexto, usuario);
        datosGuardados.setValue(true);
    }

    private boolean validarCampos(Context contexto) {
        if (nombre.getValue().length() == 0 || email.getValue().length() == 0 || apellido.getValue().length() == 0 || password.getValue().length() == 0 || dni!= null) {
            Toast.makeText(contexto, "Todos los datos requeridos", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }


}
