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
public class Circuito {
   Coche vCoches[];
   private String nombre;
   private int distancia_carrera;
   private int numCoches;

    public Circuito(String nombre, int distancia_carrera, int numCoches) {
        this.nombre = nombre;
        this.distancia_carrera = distancia_carrera;
        this.numCoches = numCoches;
        vCoches = new Coche[numCoches];
    }
    
    
    //AÑADIR COCHES AL CIRCUITO
    public void anadirCoche(){
        Scanner leer = new Scanner(System.in);
        int num_dorsal;
        String nombre_piloto;
        
        System.out.println("Introduce el Nombre del Piloto");
        nombre_piloto = leer.next();
        do{
            System.out.println("Introduce el Dorsal del Piloto");
            num_dorsal = leer.nextInt(); 
        }while (comprobarExistente(num_dorsal));
        
        for (int i = 0; i < vCoches.length; i++) {
            if(vCoches[i]==null){
                vCoches[i] = new Coche(nombre_piloto, num_dorsal, distancia_carrera);
                break;
            }
        }

    }
    
    //COMPROBAR SI EL DORSAL YA EXISTE , SI DEVUELVE TRUE
    private boolean comprobarExistente(int dorsal){
        boolean existe=false;
        for (int i = 0; i < vCoches.length; i++) {
            if(vCoches[i]!=null && dorsal==(vCoches[i].getDorsal_piloto())){
                System.out.println("El dorsal YA EXISTE");
                return true;
            }
        }
        return existe;
    }

    //CALCULAR NUMERO DE COCHES COMPTIENDO
    public int numeroCochesCompitiendo(){
        int total=0;
        for (int i = 0; i < vCoches.length; i++) {
            if(vCoches[i]!=null){
                total++;
            }
        }
        return total;
    }
    
    //CALCULAR COCHES EN CARRERA (MARCHA)
    public int numeroCochesEnCarrera(){
        int total=0;
        for (int i = 0; i < vCoches.length; i++) {
            if(vCoches[i]!=null && vCoches[i].getEstado_coche().equals("MARCHA")){
                total++;
            }
        }
        return total;
    }
    
    //CALCULAR COCHES QUE HAN FINALIZADO
    public int numeroCochesFinalizado(){
        int total=0;
        for (Coche vCoches : vCoches) {
            if (vCoches != null && vCoches.getEstado_coche().equals("TERMINADO")) {
                total++;
            }
        }
        return total;
    }
    
    //SI LA CARRERA A TERMINADO
    public String estadoCarrera(){
        String estado="";
        for (Coche vCoches : vCoches){
            if(vCoches !=null){
                estado+="\n|---------------->"+
                        "\n|Piloto: "+vCoches.getNombre_piloto().toUpperCase()+
                        "\n|Dorsal: "+vCoches.getDorsal_piloto()+
                        "\n|Estado: "+vCoches.getEstado_coche()+
                        "\n|---------------->";
            }
        }
        return estado;
    }

    @Override
    public String toString() {
        return "Nombre del circuito: "+ nombre + 
               "\nDistancia de la carrera: "+ distancia_carrera + 
               "\nParticipantes: " + numCoches;
    }
    
    private void arrancarCoches(){
        for (Coche vCoche : vCoches) {
            if(vCoche!=null){
                vCoche.setEstado_coche("MARCHA");
            }
        }
    }
    private void jugarBot(){
        
    }
    
    public void jugar(){
        Coche Coche = null;
        arrancarCoches();
        do{
            estadoCarrera();
            for (int i = 0; i < 10; i++) {
               //primero juego yo
            }
            int opc = Menu.menuJugador();
            switch(opc){
                //ACELERAR COCHE
                case 1: Coche.acelerar();
                    break;
                //FRENAR COCHE
                case 2: Coche.frenar();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                //OBTENER NUMERO DE COCHES EN CARRERO EN CASO QUE EL CIRCUITO ESTÉ CONFIGURADO
                case 5: System.out.println("\n\n");
                        System.out.println("En total hay.."+numeroCochesEnCarrera()+" Pilotos en Carrera");
                        System.out.println("\n\n");
                    break;
                //OBTENER NUMERO DE COCHES QUE HAN FINALIZADO LA CARRERA
                case 6: System.out.println("\n\n");
                        System.out.println("En total "+numeroCochesFinalizado()+" Pilotos han completado la Carrera");
                        System.out.println("\n\n");
                    break;
                //ESTADO DE LA CARRERA
                case 7: System.out.println("\n\n");
                        System.out.println(estadoCarrera());
                        System.out.println("\n\n");
                    break;
            }
        }while(!partidaTerminada());
    }
   
    private boolean partidaTerminada(){
        boolean terminado=false;
        for (Coche vCoche : vCoches) {
            if(vCoche.getEstado_coche()!="MARCHA"){
                return true;
            }
        }
        return terminado;
    }
}
