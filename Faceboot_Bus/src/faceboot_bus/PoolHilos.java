/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package faceboot_bus;

import java.awt.AWTEvent;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Fernando
 */
public class PoolHilos{

    private ExecutorService executor = Executors.newCachedThreadPool();
    

    public void agregar(HiloDeUsuario hilo)
    {
        executor.execute(hilo);
    }
}
