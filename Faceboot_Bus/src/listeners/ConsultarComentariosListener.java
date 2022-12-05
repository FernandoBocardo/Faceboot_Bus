/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listeners;

import Negocios.CtrlComentario;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.System.Logger;
import java.net.Socket;
import java.util.logging.Level;

/**
 *
 * @author Fernando
 */
public class ConsultarComentariosListener implements iEventListener{
    
    @Override
    public void update(String json, Socket socketCliente, Socket socketNotificacion, String usuarioJson) {
        String comentariosJson = CtrlComentario.getInstance().consultarPorPublicacion(json);
        try 
        {
            BufferedWriter salida = new BufferedWriter(new OutputStreamWriter(socketNotificacion.getOutputStream()));
            salida.write("notificarConsultaComentarios");
            salida.newLine();
            salida.write(comentariosJson);
            salida.newLine();
            salida.write(usuarioJson);
            salida.newLine();
            salida.flush();
        } catch (IOException ex) 
        {
            java.util.logging.Logger.getLogger(ConsultarComentariosListener.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
}
