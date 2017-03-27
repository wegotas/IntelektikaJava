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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.microsoft.sqlserver.jdbc.*;
import java.util.Collections;
import java.util.Comparator;

/**
 * @param taisykleNr1 TopRaide taisyklė.
 * @param taisykleNr2 Regex taisyklė.
 * @param taisykleNr3 TopxRaide taisyklė..
 * @param atspetos_raides raidės, kurios buvo bandytos spėti ir jos sėkmingai 
 * buvo atspėtos.
 * @param neatspetos_raides raidės, kurios buvo bandytos spėti ir jos 
 * nesėkmingai buvo neatspėtos.
 * @param spejamasZodis žinomas žodis. Atspėtos raidės pateikiamos kaip raidės.
 * Dar nežinomos pozicijos pateikiamos apatiniais brūkšneliais.
 * @param galimiVariantai Regex'o taisyklei taikomas sąrašas žodžių. Jame laikomi
 * žodžiai, kurie toliau atitinka keliamas besikartojančias savybes sąlygas.
 * @param taisyklesTekstas Šiame stringe laikomas tekstas kokia taisyklė buvo 
 * taikoma, kad iš grąfinės sąsajos būtų aišku kodėl spėjama viena ar kita raidė.
 * @param conn Azure serveryje laikomos duombazės jungties eilutė.
 * 
 * @author Wegis
 */
public class Speliotojas {

    private boolean taisykleNr1 = true;
    private boolean taisykleNr2 = true;
    private boolean taisykleNr3 = true;
    private List<Character> atspetos_raides;
    private List<Character> neatspetos_raides;
    private String spejamasZodis;
    private List<String> galimiVariantai;
    private String taisyklesTekstas = "";
    static Connection conn;
    
    /**
     * Metodas procedūrom į duomenų bazę negrąžinančių reikšmių/rezultatų atgal.
     * Tokiom kaip insert/update/delete ir pan.
     * 
     * @param uzklausa procedūros eilutė, kuri bus perduota duomenų bazėj.
     */
     private void KreiptisDuombazenBegrazinimo(String uzklausa) {
         try {
            conn = DriverManager.getConnection("jdbc:sqlserver://budeliai.database.windows.net:1433;database=Zodziai.mdf;user=budelis@budeliai;password=abc1234!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
        } catch (SQLException ex) {
            Logger.getLogger(Speliotojas.class.getName()).log(Level.SEVERE, null, ex);
        }
        Statement st;
        try {
            st = conn.createStatement();
            st.execute(uzklausa);
        } catch (SQLException ex) {
            Logger.getLogger(Speliotojas.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
    /**
     * Metodas procedūrom į duomenų bazę grąžinančiom reikšmes/rezultatus atgal.
     * 
     * @param uzklausa procedūros eilutė, kuri bus perduota duomenų bazėj.
     * @return Lentelė resultset tipo.
     */
    private ResultSet KreiptisDuombazen(String uzklausa) {
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

    /**
     * Ištuština sąrašus atspėtų ir neatspėtų raidžių.
     * Priskiria reikšmę naujo žodžio vidiniam kintamajam.
     * Užpildo galimiVariantai sąrašą žodžiais, kurie atitinka besikartojančias 
     * sąvybes.
     * Ir nustato kad visos taisykles galima taikyti.
     * 
     * @param zodis priimamas žodis, kuris gaunamas kaip apatinių brūkšnelių 
     * rinkinys, kurių kiekis atitinka žodžio ilgį.
     */
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
     * Grąžina stringą, kuriame jau būna pašalintos besikartojančios raides.
     * labas -> labs
     * ananasas -> ans
     * bananas -> bans
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
     * Metodas kviečiamas GUI dalyje ir grąžina vieną raidę. Jame pasirenkama
     * taisyklė ir jį vykdoma.
     */
    public Character SpekRaide() {
        if (taisykleNr1) {
            return TopRaide();
        } else if (taisykleNr2) {
            char spejimas = IeskotiZodzioSuRegex();
            if (spejimas != '*') {
                return spejimas;
            } else {
                taisykleNr2 = false;
                return TopXRaidziu();
            }
        } else {
            return TopXRaidziu();
        }
    }

    /**
     * Pagal sąrašus atspetų ir neatspetu raidžių sudaromas vienas stringas
     * panaudotų raidžių.
     * 
     * @return stringa bandytų raidžių
     */
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

    /**
     * Įvertina pagal raides lentelę DB raides didžiausią pasikartojimų kiekį 
     * ir grąžiną didžiausią reikšmę turinčią raidę, kurį nėra tarp bandytų 
     * raidžių (atspėtų ir neatspėtos raidės sudėtos į vieną)
     * @return character tipo kintamąjį, kuris yra viena raidė.
     */
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
        taisyklesTekstas = "Taikyta dažniausiai besikartojančios raidės taisyklė(TopRaide).\r\n";
        return raide;
    }

    /**
     * Įvertina vieną arba daugiau raidžių. 
     * Grąžiną raidę iš svarstytinų atsitiktinę pagal svertus
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
        taisyklesTekstas = "Taikyta dažniausiai besikartojančių raidžių pagal svertus taisyklė(TopXraide).\r\n";
        return spejamaRaide;
    }

    /**
     * Daroma prielaida kad vartotojo spėjamas žodis jau duomenų bazėje 
     * egzistuoja ir spėlojama pagal duombazėj egzistuojančius žodžius ir jų 
     * turimas sąvybes.
     * 
     * Pagal žodžio ilgį ir pasikartojančias savybes atrenkamą atrenkamas žodžių
     * sąrašas o iš jo atrenkama labiausiai tikėtinas raides. Kurios atsitiktinių
     * pagal svertus principą išrenkama viena ir jį grąžinama.
     * @return raidė pagal besikartojančias sąvybes.
     */
    private char IeskotiZodzioSuRegex() {
        List<String> atrinktiZodziai = new ArrayList<String>();
        List<RaidesKiekis> RKlistas = new ArrayList<RaidesKiekis>();

        String pattern = "";
        for (char c : spejamasZodis.toCharArray()) {
            if (c == '_') {
                pattern += "[^" + GautBandytosRaides() + "]";
            } else {
                pattern += c;
            }
        }
        Pattern regexPattern = Pattern.compile(pattern);
        for (String zodis : galimiVariantai) {
            Matcher m = regexPattern
                    .matcher(zodis);
            while (m.find()) {
                atrinktiZodziai.add(m.group());
            }
        }

        boolean rasta = false;
        String apkarpytasZodis;
        if(atrinktiZodziai.size() == 0){
            return '*';
        }
        for (String zodis : atrinktiZodziai) {
            apkarpytasZodis = PasalintiBesikartojanciasRaides(zodis);
            for (char raide : apkarpytasZodis.toCharArray()) {
                rasta = false;
                if (!atspetos_raides.contains(raide)) {
                    for (RaidesKiekis rk : RKlistas) {
                        if (rk.raide == raide) {
                            rk.kiekis++;
                            rasta = true;
                            break;
                        }
                    }
                    if (!rasta) {
                        RKlistas.add(new RaidesKiekis(raide, 1));
                    }
                }
            }
        }
        Collections.sort(RKlistas, (RaidesKiekis rk1,RaidesKiekis rk2) -> rk2.kiekis-rk1.kiekis);
        galimiVariantai = atrinktiZodziai;
        List<RaidesKiekis> RKlistas2 = new ArrayList<RaidesKiekis>();
        for(int i=0;i<=neatspetos_raides.size();i++)
        {
            if(RKlistas.size()<=i)
            {
                break;
            }
            RKlistas2.add(RKlistas.get(i));
        }
        if(RKlistas2.size() == 0)
        {
            return '*';
        }
        char spejamaRaide = AtsitiktinisPagalSvertus(RKlistas2);
        taisyklesTekstas = "Taikyta pagal besikartojančias sąvybes, dažniausiai pasitaikanti raidė(Regex).\r\n";
        return spejamaRaide;
    }
    
    /**
     * Panaikina tarpus kurie būna po stringo išgavimo iš duombazės.
     * "tekstas                   " -> "tekstas"
     * "    t   e  k s   t  a  s    " -> "tekstas"
     * 
     * @param tekstas stringas turintis dažniausiai savo galę tarpus(space)
     * @return tekstas be tarpų(space)
     */
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
    
    /**
     * @return Tekstas kokia taisyklė yra taikoma
     */
    public String iLoga() {
        return taisyklesTekstas;
    }

    /**
     * Pasibaigus žaidimui, spėtas žodis yra mėginamas išsaugoti duombazėn.
     * Jei toks žodis yra. Tada to žodžio kartu_speta padidėja vienu vienetu.
     * O raidžių lentelė yra perskaičiuojama.
     * 
     * @param pasisekimas ar pasisekė atspėti žodį
     * @param spejamasZodis žodis, kuris buvo mėgintas spėti.
     * @throws SQLException reikalavo, priešingu atveju nekompiliavo
     */
    public void GautAtsakyma(boolean pasisekimas, String spejamasZodis) throws SQLException {
        String irasytZodi = "exec IterptZodiIrSekme " + pasisekimas + ", N'" + spejamasZodis + "'";
        String atnaujint = "exec AtnaujintiKiekius";
        KreiptisDuombazenBegrazinimo(irasytZodi);
        conn.close();
        KreiptisDuombazenBegrazinimo(atnaujint);
        conn.close();
    }

    /**
     * Jis veikia pagal principą:
     * raidė: a kiekis: 50
     * raidė: b kiekis: 30
     * raidė: c kiekis: 20
     * 
     * Random funkcija tada turi šansus 
     * ,kad a = 50%,b = 30%,c = 20% gavimo šansus
     * 
     * @param rkl RaidesKiekis objektų sąrašas.
     * @return raidė, kuri buvo parinkta mėginti spėti.
     */
    private Character AtsitiktinisPagalSvertus(List<RaidesKiekis> rkl) {
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
     * Taip ir nepabaigėm dėl laiko trūkumo, 
     * dėl įgyvendinto algoritmo veikimo ilgio
     * ir dėl įgyvendinto algoritmo netinkamo veikimo.
     */
    private char KaireDesine() {

        return ' ';
    }

    /**
     * Tuščias metodas (in-development)
     * Taip ir nepabaigėm dėl laiko trūkumo, 
     * dėl įgyvendinto algoritmo veikimo ilgio
     * ir dėl įgyvendinto algoritmo netinkamo veikimo.
     */
    private char KaireDesineXRaidziu() {

        return ' ';
    }
}
