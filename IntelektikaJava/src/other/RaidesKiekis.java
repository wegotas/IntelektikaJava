/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

/**
 * Klasė skirta savyje saugoti raidę bei tos raidės pasikartojimų kiekį.
 * 
 * @author Wegis
 */
public class RaidesKiekis {
    public char raide;
    public int kiekis;

    /**
     * Konstruktorius priskiriantis vidinius klases atributams gaunamas 
     * reikšmes.
     * 
     * @param raide tai simbolis iš lietuviškos abecelės aibės.
     * @param kiekis kiekis tai skaičius(int), simbolio pasikartojimo kiekis
     */
    public RaidesKiekis(char raide, int kiekis) {
        this.raide = raide;
        this.kiekis = kiekis;
    }

    public int getKiekis() {
        return kiekis;
    }

    public char getRaide() {
        return raide;
    }
}
