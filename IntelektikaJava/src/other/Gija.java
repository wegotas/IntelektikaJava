/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;
import intelektikajava.*;

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
        GUI.pradeti(zodis);
        /*
        while (GUI.zaidimas)
        {
            GUI.speliotojas.GautiSpejamaZodi(zodis.pasleptasZodis);
            System.out.println("Veikia gijos");
        }*/
    }
    
     public void stop() {
        gija = null;
     }
}
