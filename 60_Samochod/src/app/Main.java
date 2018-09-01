/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import data.TKabriolet;
import data.TSamochod;

/**
 *
 * @author student
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TSamochod samochod = new TSamochod("VW", 50, 150, 6);
        
        samochod.jedz(200, 20);
        System.out.println("\n======================\n");
        samochod.jedz(80, 20);
        System.out.println("\n======================\n");
        samochod.jedz(80, 1000);
        
        TKabriolet kabriolet = new TKabriolet("VW", 50, 150, 6);
        System.out.println("\n======================\n");
        kabriolet.jedz(80, 1000);
        
        kabriolet.otworz_dach();
        System.out.println("\n======================\n");
        kabriolet.jedz(80, 1000);
    }
    
}
