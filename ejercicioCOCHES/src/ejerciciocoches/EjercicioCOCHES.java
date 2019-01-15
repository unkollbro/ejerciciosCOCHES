/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciocoches;

import Menus.Menu;

/**
 *
 * @author Catalin 'uNKoLL' Ciurcanu
 */
public class EjercicioCOCHES {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Circuito circuito = new Circuito("Prueba", 1000, 5);
        int opc;
        do{
            opc = Menu.mostrarMenu();
            switch(opc){
                case 0: System.out.println("\n\n");
                        circuito.configurarCircuito();
                        System.out.println("\n\n");
                case 1: System.out.println("\n\n");
                        circuito.anadirCoche(); 
                        System.out.println("\n\n");
                    break;
                case 2: System.out.println("\n\n");
                        System.out.println("En total hay.."+circuito.numeroCochesCompitiendo()+" Pilotos");
                        System.out.println("\n\n");
                    break;
                case 3: break;
                case 4: break;
                case 5: break;
            }
        }while(opc!=6);
        
    }
    
}
