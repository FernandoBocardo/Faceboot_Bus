/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listeners;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fernando
 */
public class NotificarSesionNoIniciadaListener implements iEventListener{
    
    @Override
    public void update(String json, Socket socketCliente, Socket socketNotificacion, String usuarioJson) {
        try {
            BufferedWriter salida = new BufferedWriter(new OutputStreamWriter(socketNotificacion.getOutputStream()));
            salida.write("notificarSesionNoIniciada");
            salida.newLine();
            salida.write(json);
            salida.newLine();
            salida.write("Sin usuario");
            salida.newLine();
            salida.flush();
        } catch (IOException ex) {
            Logger.getLogger(NotificarRegistroUsuarioListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
