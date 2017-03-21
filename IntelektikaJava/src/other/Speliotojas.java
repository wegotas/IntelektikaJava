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

    static Connection conn;

    /*
    public Speliotojas() {
    }*/

    private ResultSet KreiptisDuombazen(String uzklausa) {
        
        if(atspetos_raides.size()+neatspetos_raides.size() > 6)
        {
            int a = 10;
        }
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://budeliai.database.windows.net:1433;database=Zodziai.mdf;user=budelis@budeliai;password=abc1234!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
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

    public void Pazadinti(String zodis) {
        atspetos_raides = new ArrayList<Character>();
        neatspetos_raides = new ArrayList<Character>();
        spejamasZodis = zodis;
        galimiVariantai = new ArrayList<String>();
        ResultSet rs = KreiptisDuombazen("exec GautZodziusPagalZodzioIlgi " + spejamasZodis.length());
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
        //return TopRaide();
        return TopXRaidziu();
    }

    private String GautBandytosRaides() {
        String bandytosRaides = "";
        for (Character c : atspetos_raides) {
            bandytosRaides += c;
        }
        for (Character c : neatspetos_raides) {
            bandytosRaides += c;
        }
        return bandytosRaides;
    }

    private Character TopRaide() {
        String gautRaide = "exec GautiTopNesikartojanciaRaide N'" + GautBandytosRaides() + "'";
        ResultSet rs = KreiptisDuombazen(gautRaide);
        Character raide = '*';
        try {
            while (rs.next()) {
                raide = rs.getString("Raide").charAt(0);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Speliotojas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return raide;
    }

    /**
     * Tuščias metodas (in-development)
     */
    private char TopXRaidziu() {
        String gautRaides = "exec GautTopPagalKieki " + (neatspetos_raides.size() + 1) + ", N'" + GautBandytosRaides() + "'";
        ResultSet rs = KreiptisDuombazen(gautRaides);
        ArrayList<RaidesKiekis> raidziuKiekioListas = new ArrayList<RaidesKiekis>();
        try {
            while (rs.next()) {
                raidziuKiekioListas.add(new RaidesKiekis(rs.getString("Raide").charAt(0), Integer.parseInt(rs.getString("Kiekis"))));
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Speliotojas.class.getName()).log(Level.SEVERE, null, ex);
        }
        Character spejamaRaide = AtsitiktinisPagalSvertus(raidziuKiekioListas);
        return spejamaRaide;
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

    public void GautAtsakyma(boolean pasisekimas, String spejamasZodis) {
        String irasytZodi = "exec IterptZodiIrSekme " + pasisekimas + ", N'" + spejamasZodis + "'";
        String atnaujint = "exec AtnaujintiKiekius";
        KreiptisDuombazen(irasytZodi);
        KreiptisDuombazen(atnaujint);
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
