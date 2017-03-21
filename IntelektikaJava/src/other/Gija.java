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
 *
 * @author Wegis
 */
public class Gija implements Runnable {

    public Thread gija;
    Zodis zodis;
    
    public void start(Zodis zodis) {
        this.zodis = zodis;
        gija = new Thread(this);
        gija.start();
    }
    
    @Override
    public void run() {
        try {
            GUI.pradeti(zodis);
        } catch (InterruptedException ex) {
            Logger.getLogger(Gija.class.getName()).log(Level.SEVERE, null, ex);
        }
        stop();
    }
    
     public void stop() {
        gija = null;
     }
}
