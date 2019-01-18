/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciocoches;

import Menus.Menu;
import java.util.Scanner;

/**
 *
 * @author Catalin 'uNKoLL' Ciurcanu
 */
public class EjercicioCOCHES {

    /**
     * @param args the command line arguments
     */
    //CONFIGURAR CIRCUITO
    public static Circuito configurarCircuito(){
        Scanner leer = new Scanner(System.in);
        String nombre;
        int distancia, participantes;
        System.out.println("Introduce El nombre del circuito");
        nombre = leer.next();
        System.out.println("Introduce La distancia de la carrera");
        distancia = leer.nextInt();
        System.out.println("Introduce los participantes");
        participantes = leer.nextInt();
        return new Circuito(nombre, distancia, participantes);
    }

    public static void main(String[] args) {
        int opc;
        Circuito circuito = null;
        //INICIO DEL MENU (DO WHILE)
        do{
            opc = Menu.mostrarMenu();
            // INICIO DEL TRY-CATHC
            try{
                switch(opc){
                    //CONFIGURAR EL CIRCUITO SI NO LO HA SIDO PREVIAMENTE
                    case 1: System.out.println("\n\n");

                            if(circuito==null){
                                circuito = configurarCircuito();
                            }
                            else{
                                System.out.println("El circuito ya ha sido configurado");
                            }
                            System.out.println("\n\n");
                        break;
                    //OBTENER DETALLES DEL CIRCUITO EN CASO DE ESTAR CONFIGURADO
                    case 2: System.out.println("\n\n");
                            System.out.println(circuito.toString());
                            System.out.println("\n\n");
                        break;
                    //AÑADIR PILOTOS/COCHES EN CASO QUE EL CIRCUITO ESTÉ CONFIGURADO
                    case 3: System.out.println("\n\n");
                            circuito.anadirCoche(); 
                            System.out.println("\n\n");
                        break;
                    //OBTENER EL NUMERO DE COCHES COMPITIENDO EN CASO QUE EL CIRCUITO ESTÉ CONFIGURADO
                    case 4: System.out.println("\n\n");
                            System.out.println("En total hay.."+circuito.numeroCochesCompitiendo()+" Pilotos");
                            System.out.println("\n\n");
                        break;
                    case 5: circuito.jugar();
                        break;
                }
            // FIN DEL TRY E INICIO DE EXCEPCIONES CATCH
            }catch (java.lang.NullPointerException falloVector){
                System.out.println("El circuito no ha sido configurado");
                System.out.println("\n\n");
            }
            //FIN DEL TRY-CATCH
        }while(opc!=6);
     //FIN DEL MENU (DO WHILE)
    }
    
}
