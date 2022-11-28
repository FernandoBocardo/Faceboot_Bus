/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package faceboot_bus;

import listeners.RegistrarPublicacionListener;
import listeners.NotificarRegistroPublicacionListener;
import listeners.NotificarRegistroUsuarioListener;
import listeners.RegistrarUsuarioListener;

/**
 *
 * @author Fernando
 */
public class iniciarServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Bus bus = Bus.getInstance();
        bus.events.subscribe("registrarUsuario", new RegistrarUsuarioListener());
        bus.events.subscribe("notificarRegistroUsuario", new NotificarRegistroUsuarioListener());
        bus.events.subscribe("notificarRegistroPublicacion", new NotificarRegistroPublicacionListener()); 
        bus.events.subscribe("registrarPublicacion", new RegistrarPublicacionListener());
        PoolHilos poolHilos = new PoolHilos();
        new ServidorBus(bus, poolHilos);
    }
    
}
