/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package faceboot_bus;

import java.net.ServerSocket;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Fernando
 */
public class Bus {
    
    private static volatile Bus instance;
    public EventManager events;
    Queue<Nodo> cola;
    
    private Bus()
    {
        this.events = new EventManager("notificarConsultaMenciones", "consultarMenciones", "notificarEdicionPerfil", "editarUsuario", "consultarPublicacionesPorEtiqueta", "registrarComentario","notificarRegistroComentario","consultarComentarios","eliminarPublicacion", "notificarSesionNoIniciada", "notificarConsultaPublicaciones", "consultarPublicaciones", "notificarSesionIniciada", "registrarUsuario", "iniciarSesion", "notificarRegistroUsuario", "notificarRegistroPublicacion", "registrarPublicacion");
        this.cola = new LinkedList<>();
    }
    
    public static Bus getInstance() 
    {
        Bus result = instance;
        if (result != null) {
            return result;
        }
        synchronized(Bus.class) 
        {
            if(instance == null) 
            {
                instance = new Bus();
            }
        return instance;
        }
    }
    
    public void añadirEvento(Nodo nodo)
    {
        this.cola.add(nodo);
        if(!events.activo)
        {
            events.notify(this.cola);
        }
    }


    
    
    
}
