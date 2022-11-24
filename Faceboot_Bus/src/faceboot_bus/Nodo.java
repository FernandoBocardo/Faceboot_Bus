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
    
    private Nodo anterior;
    private Nodo siguiente;
    private String eventType;
    private String json;
    private Socket socket;

    public Nodo(String eventType, String json, Socket socket)
    {
        this.anterior = null;
        this.siguiente = null;
        this.eventType = eventType;
        this.json = json;
        this.socket = socket;
    }
    
    public Nodo(String eventType)
    {
        this.anterior = null;
        this.siguiente = null;
        this.eventType = eventType;
    }
    
    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
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

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }


    
    
    
}
