/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;
import intelektikajava.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Laiko ir vykdo savyje giją. Kad atskirtu nuo GVS'o.
 *
 */
public class Gija implements Runnable {

    public Thread gija;
    Zodis zodis;
    
    /**
     * Inicijuoja giją. ir po to paleidžia run()
     * @param zodis Dėl šito neesu įsitikinęs, bet vistiek panaudojau.
     */
    public void start(Zodis zodis) {
        this.zodis = zodis;
        gija = new Thread(this);
        gija.start();
    }
    
    /**
     * Veikia iškart po start(). Vykdo duomenų apdorojimą, kuris aprašytas GUI.
     */
    @Override
    public void run() {
        try {
            GUI.pradeti(zodis);
        } catch (InterruptedException ex) {
            Logger.getLogger(Gija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Nutraukia giją, priskirdama vidinėj klasės gijai null reikšmę.
     */
     public void stop() {
        gija = null;
     }
}
