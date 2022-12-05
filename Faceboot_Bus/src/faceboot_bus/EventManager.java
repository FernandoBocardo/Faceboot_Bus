/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package faceboot_bus;

import listeners.iEventListener;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author Fernando
 */
public class EventManager {
    
    private Map<String, List<iEventListener>> listeners = new HashMap<>();
    public boolean activo = false;

    public EventManager(String... operations) {
        for (String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }
    
    public void subscribe(String eventType, iEventListener listener) {
        List<iEventListener> users = listeners.get(eventType);
        users.add(listener);
    }

    public void unsubscribe(String eventType, iEventListener listener) {
        List<iEventListener> users = listeners.get(eventType);
        users.remove(listener);
    }

    public void notify(Queue<Nodo> cola) {
        this.activo = true;
        while(cola.peek()!= null)
        {
            Nodo nodo = cola.remove();
            String eventType = nodo.getEventType();
            String json = nodo.getJson();
            Socket socketCliente = nodo.getSocketCliente();
            Socket socketNotificacion = nodo.getSocketNotificacion();
            String usuarioJson = nodo.getUsuarioJson();
            List<iEventListener> users = new CopyOnWriteArrayList(listeners.get(eventType));
            for (iEventListener listener : users) {
                listener.update(json, socketCliente, socketNotificacion, usuarioJson);
            }
        }
        this.activo = false;
    }
}
