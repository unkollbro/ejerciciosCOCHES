/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menus;

import java.util.Scanner;

/**
 *
 * @author Catalin 'uNKoLL' Ciurcanu
 */
public class Menu {
    public static int mostrarMenu(){
        Scanner leer = new Scanner(System.in);
        int opc=0;
        do{
            System.out.println("0. Configurar Carrera");
            System.out.println("1. Añadir Piloto");
            System.out.println("2. Número de coches compitiendo");
            System.out.println("3. Número de coches en carrera.");
            System.out.println("4. Número de coches que han finalizado la carrera");
            System.out.println("5. Estado de la carrera");
            System.out.println("6. Salir"); 
            opc = leer.nextInt();
        }while(opc<0 || opc>6);
        return opc;
    }
}
