/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package faceboot_bus;

import listeners.ConsultarComentariosListener;
import listeners.ConsultarMencionesListener;
import listeners.ConsultarPublicacionesListener;
import listeners.ConsultarPublicacionesPorEtiquetaListener;
import listeners.EditarUsuarioListener;
import listeners.EliminarPublicacionListener;
import listeners.IniciarSesionListener;
import listeners.NotificarEdicionUsuarioListener;
import listeners.NotificarRegistroComentarioListener;
import listeners.RegistrarPublicacionListener;
import listeners.NotificarRegistroPublicacionListener;
import listeners.NotificarRegistroUsuarioListener;
import listeners.NotificarSesionIniciadaListener;
import listeners.NotificarSesionNoIniciadaListener;
import listeners.RegistrarComentarioListener;
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
        bus.events.subscribe("iniciarSesion", new IniciarSesionListener());
        bus.events.subscribe("notificarSesionIniciada", new NotificarSesionIniciadaListener());
        bus.events.subscribe("notificarSesionNoIniciada", new NotificarSesionNoIniciadaListener());
        bus.events.subscribe("consultarPublicaciones", new ConsultarPublicacionesListener());
        bus.events.subscribe("eliminarPublicacion", new EliminarPublicacionListener());
        bus.events.subscribe("consultarComentarios", new ConsultarComentariosListener());
        bus.events.subscribe("notificarRegistroComentario", new NotificarRegistroComentarioListener()); 
        bus.events.subscribe("registrarComentario", new RegistrarComentarioListener());
        bus.events.subscribe("consultarPublicacionesPorEtiqueta", new ConsultarPublicacionesPorEtiquetaListener());
        bus.events.subscribe("editarUsuario", new EditarUsuarioListener());
        bus.events.subscribe("notificarEdicionPerfil", new NotificarEdicionUsuarioListener());
        bus.events.subscribe("consultarMenciones", new ConsultarMencionesListener());
        PoolHilos poolHilos = new PoolHilos();
        new ServidorBus(bus, poolHilos);
    }
    
}
