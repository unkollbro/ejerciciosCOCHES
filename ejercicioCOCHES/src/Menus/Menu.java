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
            System.out.println("1. Configurar Carrera");
            System.out.println("2. Detalles del Circuito");
            System.out.println("3. Añadir Piloto");
            System.out.println("4. Número de coches compitiendo");
            System.out.println("5. Configuracion Jugador");
            System.out.println("6. Salir"); 
            opc = leer.nextInt();
        }while(opc<1 || opc>6);
        return opc;
    }
    
    public static int menuJugador(){
        Scanner leer = new Scanner(System.in);
        int opc=0;
        do{
            System.out.println("1. Acelerar");
            System.out.println("2. Frenar");
            System.out.println("3. Rearrancar");
            System.out.println("4. Estado coche");
            System.out.println("5. Número de coches en carrera.");
            System.out.println("6. Número de coches que han finalizado la carrera");
            System.out.println("7. Estado de la carrera");
            System.out.println("8. Salir");
            opc = leer.nextInt();
        }while(opc<1 || opc>8);
        return opc;
    }
}
