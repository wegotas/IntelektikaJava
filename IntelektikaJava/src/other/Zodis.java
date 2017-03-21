/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;
import java.util.ArrayList;
import java.util.List;

/**
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
    
    public Zodis(String zodis){
        this.zodis = zodis;
        pasleptasZodis = "";
        for(Character c: zodis.toCharArray()){
            pasleptasZodis+="_";
            pasleptoZodzioRaidziuSarasas.add('_');
        }
        int a = 10;
    }
    
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
    
    private void Konvertavimas(){
        pasleptasZodis = "";
        for(Character c: pasleptoZodzioRaidziuSarasas)
        {
            pasleptasZodis += c;
        }
    }
    
    public String Atvaizdavimas(){
        String dto = "";
        for(Character c: pasleptasZodis.toCharArray()){
            dto+=c+" ";
        }
        return dto;
    }
    
    public boolean ArAtspejoZodi()
    {
        if(zodis == pasleptasZodis)
        {
            return true;
        }
        return false;
    }
    
    public String GautiZodi(){
        return zodis;
    }
}
