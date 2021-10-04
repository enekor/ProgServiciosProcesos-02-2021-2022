package es.joseluisgs.dam;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main(String[] args) {
        Pila pila = new Pila();

        // Jugar cambiando los valores y quitando consumidores o productores
        Productor pr = new Productor(1,pila,20, 500);
        Consumidor cs = new Consumidor (1,pila,20,200);
        Productor pr2 = new Productor(2,pila,20, 500);
        Consumidor cs2 = new Consumidor (2,pila,20,200);
        Consumidor cs3 = new Consumidor (3,pila,20,200);


        pr.setName("Hebra consumidora 1");
        pr.start();
        cs.start();
        pr2.start();
        cs2.start();
        cs3.setPriority(10); // Este se debe ejecutar mas que el otro, comrpbar
        cs3.start();

        // Esta parte crea un interbloqueo o una espera activa?,
        //sabes por que?
        /*
        try {
            pr.join();
            System.out.println("La hebra"+pr.getName()+" ha terminado");
            cs.join();
            pr2.join();
            cs2.join();
            cs3.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         */


    }

}
