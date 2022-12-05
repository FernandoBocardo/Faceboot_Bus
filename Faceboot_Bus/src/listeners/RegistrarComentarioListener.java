/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listeners;

import Negocios.CtrlComentario;
import faceboot_bus.Bus;
import faceboot_bus.Nodo;
import java.net.Socket;

/**
 *
 * @author Fernando
 */
public class RegistrarComentarioListener implements iEventListener{
    
    @Override
    public void update(String json, Socket socketCliente, Socket socketNotificacion, String usuarioJson) {
        CtrlComentario.getInstance().registrarComentario(json, usuarioJson);
        Bus.getInstance().añadirEvento(new Nodo("notificarRegistroPublicacion", json, socketCliente, socketNotificacion, usuarioJson));
    }
    
}
