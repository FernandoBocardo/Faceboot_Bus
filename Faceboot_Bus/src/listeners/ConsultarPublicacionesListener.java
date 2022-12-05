/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listeners;

import Dominio.Publicacion;
import Negocios.CtrlPublicacion;
import Negocios.CtrlUsuario;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import faceboot_bus.Bus;
import faceboot_bus.Nodo;
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
public class ConsultarPublicacionesListener implements iEventListener{
    
    @Override
    public void update(String json, Socket socketCliente, Socket socketNotificacion, String usuarioJson) {
        String publicacionesJson = CtrlPublicacion.getInstance().consultarTodas();
        try 
        {
            BufferedWriter salida = new BufferedWriter(new OutputStreamWriter(socketNotificacion.getOutputStream()));
            salida.write("notificarConsultaPublicaciones");
            salida.newLine();
            salida.write(publicacionesJson);
            salida.newLine();
            salida.write(usuarioJson);
            salida.newLine();
            salida.flush();
        } catch (IOException ex) 
        {
            Logger.getLogger(NotificarRegistroUsuarioListener.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
    
}
