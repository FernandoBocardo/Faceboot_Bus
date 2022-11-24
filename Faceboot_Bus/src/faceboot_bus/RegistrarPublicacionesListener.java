/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package faceboot_bus;

import java.net.Socket;

/**
 *
 * @author Fernando
 */
public class RegistrarPublicacionesListener implements iEventListener{
    
    @Override
    public void update(String json, Socket socket) {
        //Registrar publicacion por implmentar
        Bus.getInstance().añadirEvento(new Nodo("NotificacionPublicacionRegistrada", json, socket));
    }
    
}
