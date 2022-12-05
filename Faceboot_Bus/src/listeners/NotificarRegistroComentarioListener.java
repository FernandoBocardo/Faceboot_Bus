/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listeners;

import Negocios.CtrlComentario;
import faceboot_bus.HiloDeUsuario;
import faceboot_bus.ServidorBus;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fernando
 */
public class NotificarRegistroComentarioListener implements iEventListener{
    
    @Override
    public void update(String json, Socket socketCliente, Socket socketNotificacion, String usuarioJson) {
        List<HiloDeUsuario> sockets = ServidorBus.getInstance().getUsuariosConectados();
        for (HiloDeUsuario usuario : sockets) {
            Socket socketNotificacionUsuario = usuario.getSocketNotificacion(); 
            try 
            {
                BufferedWriter salida = new BufferedWriter(new OutputStreamWriter(socketNotificacionUsuario.getOutputStream()));
                salida.write("notificarRegistroComentario");
                salida.newLine();
                salida.write(json);
                salida.newLine();
                salida.write(usuario.getUsuarioJson());
                salida.newLine();
                salida.flush();
            } catch (IOException ex) 
            {
                Logger.getLogger(NotificarRegistroComentarioListener.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }
        
    }
    
}
