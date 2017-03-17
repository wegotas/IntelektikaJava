/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.microsoft.sqlserver.jdbc.*;  

/**
 *
 * @author Wegis
 */
public class Speliotojas {

    private boolean taisykleNr1 = true;
    private boolean taisykleNr2 = true;
    private boolean taisykleNr3 = true;
    private ArrayList<Character> atspetos_raides;
    private ArrayList<Character> neatspetos_raides;
    private String spejamasZodis;
    private ArrayList<String> galimiVariantai;
    
    Connection conn;
/*
    public Speliotojas() {
    }*/

    public ResultSet KreiptisDuombazen(String uzklausa){
        try {
            this.conn = DriverManager.getConnection("jdbc:sqlserver://budeliai.database.windows.net:1433;database=Zodziai.mdf;user=budelis@budeliai;password=abc1234!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
        } catch (SQLException ex) {
            Logger.getLogger(Speliotojas.class.getName()).log(Level.SEVERE, null, ex);
        }
        Statement st;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(uzklausa);
        } catch (SQLException ex) {
            Logger.getLogger(Speliotojas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
    
    /**
     * Neuzbaigtas pustustis metodas (in-development)
     */
    
    public void Pazadinti(String zodis) {
        spejamasZodis = zodis;   
        galimiVariantai = new ArrayList<String>();
        ResultSet rs = KreiptisDuombazen("select * from Zodziai");
        try {
            while (rs.next()) {
                galimiVariantai.add(rs.getString("Zodis"));
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Speliotojas.class.getName()).log(Level.SEVERE, null, ex);
        }
        taisykleNr1 = true;
        taisykleNr2 = true;
        taisykleNr3 = true;
        atspetos_raides = new ArrayList<Character>();
        neatspetos_raides = new ArrayList<Character>();
    }

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
