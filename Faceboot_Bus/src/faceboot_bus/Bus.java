/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package faceboot_bus;

import java.net.ServerSocket;

/**
 *
 * @author Fernando
 */
public class Bus {
    
    private static volatile Bus instance;
    public EventManager events;
    public Cola cola;
    
    private Bus()
    {
        this.events = new EventManager("registrarUsuario", "iniciarSesion", "notificarRegistroUsuario", "NotificacionPublicacionRegistrada", "registrarPublicacion");
        this.cola = new Cola();
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
        this.cola.añadir(nodo);
        if(!events.activo)
        {
            events.notify(this.cola);
        }
    }


    
    
    
}
