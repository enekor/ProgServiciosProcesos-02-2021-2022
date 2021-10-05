package PruebasEneko;
import es.joseluisgs.dam.Cajera;
import es.joseluisgs.dam.CajeraHebra;
import es.joseluisgs.dam.Cliente;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class ThreadGroupTest extends Thread
{
    public static void main( String[] args )
    {
        procesarCarrosSecuencial();
        procesarCarrosConcurrentemente();
    }

    private static void procesarCarrosSecuencial() {
        System.out.println("Procesando secuencial");
        Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3});
        Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1, 1 });

        Cajera cajera1 = new Cajera("Cajera 1");
        Cajera cajera2 = new Cajera("Cajera 2");

        // Tiempo inicial de referencia
        long initialTime = System.currentTimeMillis();

        cajera1.procesarCompra(cliente1, initialTime);
        cajera2.procesarCompra(cliente2, initialTime);
    }

    private static void procesarCarrosConcurrentemente() {
        System.out.println("Procesando Paralelo con Hilos");
        Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 });
        Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1, 1 });

        // Tiempo inicial de referencia
        long initialTime = System.currentTimeMillis();
        CajeraRuneable cajera1 = new CajeraRuneable("Cajera 1", cliente1, initialTime);
        CajeraRuneable cajera2 = new CajeraRuneable("Cajera 2", cliente2, initialTime);

        // Ejecución concurrente
        ThreadGroup tg = new ThreadGroup("Grupo cajeras");
        Thread cajera1Thread = new Thread(tg,cajera1);
        Thread cajera2Thread = new Thread(tg,cajera2);
        cajera1Thread.start();
        cajera2Thread.start();
        //tg.start();
/*
        try {
            // Esperamos que termine el programa
            //tg.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(es.joseluisgs.dam.App.class.getName()).log(Level.SEVERE, null, ex);
        }*/

    }
}
