/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package faceboot_bus;

import faceboot_bus.Cola;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public void notify(Cola cola) {
        this.activo = true;
        while(cola.getPrimero() != null)
        {
            String eventType = cola.getPrimero().getEventType();
            String json = cola.getPrimero().getJson();
            Socket socket = cola.getPrimero().getSocket();
            List<iEventListener> users = listeners.get(eventType);
            for (iEventListener listener : users) {
                listener.update(json, socket);
            }
            cola.eliminarPrimero();
        }
        this.activo = false;
    }
}
