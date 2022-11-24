/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package faceboot_bus;

import Negocios.CtrlUsuario;
import java.net.Socket;



/**
 *
 * @author Fernando
 */
public class RegistrarUsuariosListener implements iEventListener{
    
    private CtrlUsuario ctrl = new CtrlUsuario();


    @Override
    public void update(String json, Socket socket) {
        this.ctrl.agregar(json);
        Bus.getInstance().añadirEvento(new Nodo("notificarRegistroUsuario", json, socket));
    }
    
}
