/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package faceboot_bus;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Fernando
 */
public class Nodo {
    
    private String eventType;
    private String json;
    private Socket socketCliente;
    private Socket socketNotificacion;

    public Nodo(String eventType, String json, Socket socketCliente, Socket socketNotificacion)
    {
        this.eventType = eventType;
        this.json = json;
        this.socketCliente = socketCliente;
        this.socketNotificacion = socketNotificacion;
    }
    
    public Nodo(String eventType)
    {
        this.eventType = eventType;
    }
    

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public Socket getSocketCliente() {
        return socketCliente;
    }

    public void setSocketCliente(Socket socketCliente) {
        this.socketCliente = socketCliente;
    }

    public Socket getSocketNotificacion() {
        return socketNotificacion;
    }

    public void setSocketNotificacion(Socket socketNotificacion) {
        this.socketNotificacion = socketNotificacion;
    }
}
