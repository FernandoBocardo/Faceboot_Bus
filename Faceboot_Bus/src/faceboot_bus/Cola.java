/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package faceboot_bus;

/**
 *
 * @author Fernando
 */
public class Cola {
    
    private Nodo ultimo;
    private Nodo primero;
    
    public Cola()
    {
        this.ultimo = null;
        this.primero = null;
    }
    
    public void añadir(Nodo nodo)
    {
        if(this.ultimo == null && this.primero == null)
        {
            this.primero = nodo;
        }
        else if(this.ultimo == null && this.primero != null)
        {
            nodo.setSiguiente(this.primero);
            this.primero.setAnterior(nodo);
            this.ultimo = nodo;
        }
        else
        {
            ultimo.setAnterior(nodo);
            nodo.setSiguiente(ultimo);
            this.ultimo = nodo;
        }
    }
    
    public void eliminarPrimero()
    {
        if(this.ultimo != null)
        {
            if(this.ultimo == this.primero.getAnterior())
            {
                this.primero = primero.getAnterior();
                this.primero.setSiguiente(null);
                this.ultimo = null;
            }
            else
            {
                this.primero = primero.getAnterior();
                primero.setSiguiente(null);
            }
        }
        else
        {
            this.primero = null;
        }
    }

    public Nodo getUltimo() {
        return ultimo;
    }

    public Nodo getPrimero() {
        return primero;
    }
    
    
}
