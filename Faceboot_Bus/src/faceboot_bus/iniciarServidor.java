/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package faceboot_bus;

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
        bus.events.subscribe("registrarUsuario", new RegistrarUsuariosListener());
        bus.events.subscribe("iniciarSesion", new RegistrarUsuariosListener());
        bus.events.subscribe("notificarRegistroUsuario", new NotificacionRegistrarUsuarioListener());
        bus.events.subscribe("NotificacionPublicacionRegistrada", new NotificacionRegistrarPublicacionListener()); 
        bus.events.subscribe("registrarPublicacion", new RegistrarPublicacionesListener());
        PoolHilos poolHilos = new PoolHilos();
        new ServidorBus(bus, poolHilos);
    }
    
}
