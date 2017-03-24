/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasė skirta būti sukurta viena, vienam spėliojimui.
 * 
 * Atributai:
 * @param  zodis žodis kuris yra žinomas ir mėginamas atspėti
 * @param pasleptasZodis žodžio, kuris yra užslėptas spėliojimo progresas.
 * @param pasleptoZodzioRaidziuSarasas pasleptas žodis, bet listo forma, 
 * naudojamas kai atverčiamos atspetos raides
 * 
 * @author Wegis
 */
public class Zodis{
    
    private String zodis;
    public String pasleptasZodis;
    public ArrayList<Character> pasleptoZodzioRaidziuSarasas = 
            new ArrayList<Character>();

    public String getZodis(){
        return zodis;
    }
    
    public String getPasleptasZodis() {
        return pasleptasZodis;
    }
    
    /**
     * Konstruktorius Zodzio klasėj.
     * Sukūria vidinį žodį kuris turi būti vartotojo įvestas ir mėginamas 
     * atspėti. Ir sugeneruoja pasleptą žodį, kuri speliotojas vėliau gauna, kad 
     * žinotu kas atspėta, kurioje pozicijoje.
     * 
     * @param zodis String Žodis kurį įvedė vartotojas
     */
    public Zodis(String zodis){
        this.zodis = zodis;
        pasleptasZodis = "";
        for(Character c: zodis.toCharArray()){
            pasleptasZodis+="_";
            pasleptoZodzioRaidziuSarasas.add('_');
        }
        int a = 10;
    }
    
    /**
     * Grąžiną ar spėjama raidė egzistuoja spėjamajame žodyje.
     * Jei yra grąžina true ir pakeičia visas tas raides žodyje į matomas,
     * jei ne grąžina false
     * 
     * @param spejimas Spėjamas charakteris 
     * @return Spėjimo sekmė, ar Žodis turi tokią raidę savyje ar ne.
     */
    public boolean Spejimas(Character spejimas){
        boolean atspejo = false;
        for(int i =0;i<zodis.length();i++)
        {
            if(zodis.charAt(i) == spejimas)
            {
                pasleptoZodzioRaidziuSarasas.set(i, spejimas);
                atspejo = true;
            }
        }
        Konvertavimas();
        return atspejo;
    }
    
    /**
     * Atspėtas raidęs atidengia iš pasleptoZodzioRaidziuSarasas, kuriame
     * laikoma pavienių žodžio raidžių sąrašas, į stringą pasleptas žodis.
     * Kuris yra grąžinamas, kai norima išgauti kiek žodžio yra žinoma.
     */
    private void Konvertavimas(){
        pasleptasZodis = "";
        for(Character c: pasleptoZodzioRaidziuSarasas)
        {
            pasleptasZodis += c;
        }
    }
    
    /**
     * Grąžina spėjamo žodžio atspėtas raides, o neatspėtu raidžių vietoje 
     * apatinius brūkšneliai. Visos raidės tarp jų gauna tarpukus, kad būtų 
     * lengviau matoma kiek raidžių dar neatspėta, kad nereikėtu matyti vieno 
     * ilgo brūkšnio.
     * 
     * @return String tipo atspėto žodžio progresas
     */
    public String Atvaizdavimas(){
        String dto = "";
        for(Character c: pasleptasZodis.toCharArray()){
            dto+=c+" ";
        }
        return dto;
    }
    
    /**
     * Sulygina spėjamą žodį su žinomu žodžiu. Jei visos raidės yra atverstos
     * tada žodžiai sutampa ir grąžinama true. Jei nevisos raidės yra atverstos
     * yra pasilikusių apatinių brūkšnėlių, tada grąžiną false.
     * @return Boolean ar atspėta žodis ar ne.
     */
    public boolean ArAtspejoZodi()
    {
        if(zodis.equals(pasleptasZodis))
        {
            return true;
        }
        return false;
    }
    
    
    /**
     * Iškviečiamas kai spėliojimai baigti ir norima išsaugoti mėginta spėti 
     * žodį.
     * 
     * @return žaidimo pradžioje mėginta spėti žodį.
     */
    public String GautiZodi(){
        return zodis;
    }
}
