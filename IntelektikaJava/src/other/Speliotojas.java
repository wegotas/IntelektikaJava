/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 *
 * @author Wegis
 */
public final class Speliotojas {

    private boolean taisykleNr1 = true;
    private boolean taisykleNr2 = true;
    private boolean taisykleNr3 = true;
    private ArrayList<Character> atspetos_raides;
    private ArrayList<Character> neatspetos_raides;
    private String spejamasZodis;
    private ArrayList<String> galimiVariantai
            = new ArrayList<String>();

    public Speliotojas(String spejamasZodis) {
        this.spejamasZodis = spejamasZodis;
        //cia turetu buti kreipimasis i duombaze uzpildyti galimiVariantai
        taisykleNr1 = true;
        taisykleNr2 = true;
        taisykleNr3 = true;
        atspetos_raides = new ArrayList<Character>();
        neatspetos_raides = new ArrayList<Character>();
    }

    
    
    /**
     * Neuzbaigtas pustustis metodas (in-development)
     */
    /*
    public void Pazadinti(String zodis) {
        spejamasZodis = zodis;

        taisykleNr1 = true;
        taisykleNr2 = true;
        taisykleNr3 = true;
        atspetos_raides = new ArrayList<Character>();
        neatspetos_raides = new ArrayList<Character>();
    }*/

    /**
     * Sitas metodas gali ir neveikti (in-development)
     */
    private String PasalintiBesikartojanciasRaides(String tekstas) {
        char[] chars = tekstas.toCharArray();
        HashSet<Character> present = new HashSet<>();
        int len = 0;
        for (char c : chars) {
            if (present.add(c)) {
                chars[len++] = c;
            }
        }
        return new String(chars, 0, len);
    }

    public void GautiSpejamaZodi(String spejamas) {
        spejamasZodis = spejamas;
    }

    /**
     * Tuščias metodas (in-development)
     */
    public Character SpekRaide() {
        return ' ';
    }

    /**
     * Sitas metodas gali ir neveikti (in-development)
     */
    private String GautBandytosRaides() {
        String bandytosRaides = "";
        ArrayList<Character> bandytuSarasas = new ArrayList<Character>();
        for (Character c : atspetos_raides) {
            bandytuSarasas.add(c);
        }
        for (Character c : neatspetos_raides) {
            bandytuSarasas.add(c);
        }
        if (bandytuSarasas.isEmpty()) {
            return "' '";
        }
        return bandytuSarasas.toString().replace(", ", "");
    }

    /**
     * Tuščias metodas (in-development)
     */
    private char TopRaide() {
        return ' ';
    }

    /**
     * Tuščias metodas (in-development)
     */
    private char TopXRaidziu() {
        return ' ';
    }

    /**
     * Tuščias metodas (in-development)
     */
    private char IeskotiZodzioSuRegex() {
        return ' ';
    }

    private String panaikintiTarpus(String tekstas) {
        return tekstas.replaceAll(" ", "");
    }

    public void RaidesAtspejimoSekme(boolean sekme, Character raide) {
        if (sekme) {
            atspetos_raides.add(raide);
        } else {
            neatspetos_raides.add(raide);
            taisykleNr1 = false;
        }
    }

    public static String iLoga() {
        return " ";
    }

    public static void GautAtsakyma(boolean pasisekimas, String spejamasZodis) {
        String irasytZodi = "exec IterptZodiIrSekme " + pasisekimas + ", N'" + spejamasZodis + "'";
        String atnaujint = "exec AtnaujintiKiekius";
        //KreiptisDuombazen(irasytZodi);
        //KreiptisDuombazen(atnaujint);
    }

    private Character AtsitiktinisPagalSvertus(ArrayList<RaidesKiekis> rkl) {
        int temp = 0;
        for (RaidesKiekis rk : rkl) {
            temp += rk.kiekis;
        }
        Random rand = new Random();
        //int rng = rand.next(0, temp);
        int rng = rand.nextInt(temp);
        int range = 0;
        char raide = '*';
        for (RaidesKiekis rk : rkl) {
            if (rng >= range && rng < (rk.kiekis + range)) {
                raide = rk.raide;
                break;
            }
            range += rk.kiekis;
        }
        return raide;
    }

    /**
     * Tuščias metodas (in-development)
     */
    private char KaireDesine() {

        return ' ';
    }

    /**
     * Tuščias metodas (in-development)
     */
    private char KaireDesineXRaidziu() {

        return ' ';
    }
}
