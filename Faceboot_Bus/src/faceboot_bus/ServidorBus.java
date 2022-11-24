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
//    public ServidorBus(Bus bus, PoolHilos poolHilos)
//    {
//        try
//        {
//            ServerSocket socketServidor = new ServerSocket(1234);
//            while (true)
//            {
//                Socket evento = socketServidor.accept();
//                Socket json = socketServidor.accept();
//                DataInputStream dataInputEvento = new DataInputStream(evento.getInputStream());
//                String tipoEvento = dataInputEvento.readUTF();
//                DataInputStream dataInputJson = new DataInputStream(json.getInputStream());
//                String jsonString = dataInputJson.readUTF();
//                Nodo nodo = new Nodo(tipoEvento, jsonString, evento);
//                HiloDeUsuario hilo = new HiloDeUsuario(nodo, bus, usuariosConectados);
//                usuariosConectados.add(hilo);
//                new Thread(hilo).start();
//                bus.añadirEvento(nodo); 
//            }
//        } catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//    }
    
    public ServidorBus(Bus bus, PoolHilos poolHilos)
    {
        try
        {
            ServerSocket socketServidor = new ServerSocket(1234);
            while (true)
            {
                Socket clienteSocket = socketServidor.accept();
                HiloDeUsuario hiloUsuario = new HiloDeUsuario(clienteSocket);
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
