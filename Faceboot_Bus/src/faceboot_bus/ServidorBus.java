/**
 * Javier Abell�n, 25 Mayo 2006
 * Servidor de chat.
 */
package faceboot_bus;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 * Servidor de chat.
 * Acepta conexiones de usuario, crea un hilo para atenderlos, y espera la
 * siguiente conexion.
 * @author Chuidiang
 *
 */
public class ServidorBus
{
    private static volatile ServidorBus instance;
    private static List<HiloDeUsuario> usuariosConectados = new ArrayList();

    /**
     * Se mete en un bucle infinito para ateder usuario, lanzando un hilo
     * para cada uno de ellos.
     * @param bus
     * @param poolHilos
     */
    public ServidorBus(Bus bus, PoolHilos poolHilos)
    {
        try
        {
            ServerSocket socketServidor = new ServerSocket(1234);
            while (true)
            {
                Socket socketCliente = socketServidor.accept();
                Socket socketNotificacion = socketServidor.accept();
                HiloDeUsuario hiloUsuario = new HiloDeUsuario(socketCliente, socketNotificacion);
                usuariosConectados.add(hiloUsuario);
                poolHilos.agregar(hiloUsuario);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static ServidorBus getInstance() 
    {
        ServidorBus result = instance;
        if (result != null) {
            return result;
        }
        synchronized(ServidorBus.class) 
        {
            return instance;
        }
    }

    public static List<HiloDeUsuario> getUsuariosConectados() {
        return usuariosConectados;
    }
    
    
    
}
