/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listeners;

import faceboot_bus.Bus;
import faceboot_bus.Nodo;
import java.net.Socket;

/**
 *
 * @author Fernando
 */
public class RegistrarPublicacionListener implements iEventListener{
    
    @Override
    public void update(String json, Socket socketCliente, Socket socketNotificacion) {
        //Registrar publicacion por implmentar
        Bus.getInstance().añadirEvento(new Nodo("notificarRegistroPublicacion", json, socketCliente, socketNotificacion));
    }
    
}
