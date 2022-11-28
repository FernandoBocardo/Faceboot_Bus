package faceboot_bus;

/**
 * Javier Abell�n, 25 Mayo 2006
 * Para el servidor de chat.
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.List;


/**
 * Hilo encargado de atender a un usuario.
 * @author Chuidiang
 */
public class HiloDeUsuario implements Runnable
{

    private Socket socketNotificacion;
    private Socket socketCliente;
    private BufferedReader entrada;

    /**
     * Crea una instancia de esta clase y se suscribe a cambios en la publicaciones.
     * @param nodo
     */
    public HiloDeUsuario(Socket socketCliente, Socket socketNotificacion)
    {
        this.socketCliente = socketCliente;
        this.socketNotificacion = socketNotificacion;
        try
        {
            entrada = new BufferedReader(new InputStreamReader(this.socketCliente.getInputStream()));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Atiende el socketNotificacion.
     */
    public void run()
    {
        while(socketCliente.isConnected())
        {
            try
            {
                if(entrada.ready())
                {
                    String eventType = entrada.readLine();
                    String json = entrada.readLine();
                    System.out.println(eventType);
                    System.out.println(json);
                    Nodo nodo = new Nodo(eventType, json, socketCliente, socketNotificacion);
                    Bus.getInstance().añadirEvento(nodo);
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        System.out.println("Cliente desconectado");
    }

    public Socket getSocketCliente() {
        return socketCliente;
    }

    public Socket getSocketNotificacion() {
        return socketNotificacion;
    }

    
    
    
}
