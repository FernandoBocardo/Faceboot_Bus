/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package faceboot_bus;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fernando
 */
public class NotificacionRegistrarPublicacionListener implements iEventListener{
    
    @Override
    public void update(String json, Socket socket) {
        List<HiloDeUsuario> sockets = ServidorBus.getInstance().getUsuariosConectados();
        for (HiloDeUsuario usuario : sockets) {
            Socket socketUsuario = usuario.getSocketCliente();
            try {
                BufferedWriter salida = new BufferedWriter(new OutputStreamWriter(socketUsuario.getOutputStream()));
                salida.write("NotificacionPublicacionRegistrada");
                salida.newLine();
                salida.write(json);
                salida.newLine();
                salida.flush();
            } catch (IOException ex) {
                Logger.getLogger(NotificacionRegistrarUsuarioListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
