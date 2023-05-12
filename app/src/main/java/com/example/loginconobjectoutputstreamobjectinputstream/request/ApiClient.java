package com.example.loginconobjectoutputstreamobjectinputstream.request;

import android.content.Context;

import com.example.loginconobjectoutputstreamobjectinputstream.modelos.Usuario;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ApiClient {
    private Context contexto;
    private static File archivo;
    //Guardar FileOutputStream, leer FileInputStream
    private static File conectar(File dir){

        if(archivo == null){
            archivo = new File(dir, "datos");
        }
        return archivo;
    }

    public static void guardar(Context contexto, Usuario usuario){
        File archivo = conectar(contexto.getFilesDir());
        try{
            FileOutputStream fos = new FileOutputStream(archivo);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(usuario);
            oos.close();
            oos.flush();


        }catch(FileNotFoundException e){
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static Usuario leer(Context contexto){
        File archivo = conectar(contexto.getFilesDir());
        try{
            FileInputStream fis = new FileInputStream(archivo);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);
            Usuario usuario = (Usuario) ois.readObject();
            ois.close();
            return usuario;
        }catch(FileNotFoundException e){
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Usuario login(Context contexto, String mail, String password){
        Usuario usuario = null;
        File archivo = conectar(contexto.getFilesDir());
        try{
            FileInputStream fis = new FileInputStream(archivo);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);
            usuario = (Usuario) ois.readObject();
            ois.close();
            return usuario;
        }catch(FileNotFoundException e){
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
