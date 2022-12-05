/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listeners;

import Negocios.CtrlPublicacion;
import Negocios.CtrlUsuario;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;

/**
 *
 * @author Fernando
 */
public class ConsultarMencionesListener implements iEventListener{
    
    @Override
    public void update(String json, Socket socketCliente, Socket socketNotificacion, String usuarioJson) {
        String UsuarioEtiquetadoJson = CtrlPublicacion.getInstance().consultarMencionPorUsusario(CtrlUsuario.getInstance().mapper(usuarioJson).getNombre());
        try 
        {
            BufferedWriter salida = new BufferedWriter(new OutputStreamWriter(socketNotificacion.getOutputStream()));
            salida.write("notificarConsultaMenciones");
            salida.newLine();
            salida.write(UsuarioEtiquetadoJson);
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
