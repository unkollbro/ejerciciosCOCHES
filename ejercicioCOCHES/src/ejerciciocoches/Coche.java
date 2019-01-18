/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciocoches;

import java.util.Random;

/**
 *
 * @author Catalin 'uNKoLL' Ciurcanu
 */
public class Coche {
    private String  nombre_piloto;
    private int     dorsal_piloto;
    private int     distancia_carrera;
    //ESTADOS: PARADO-MARCHA-ACCIDENTADO-TERMINADO
    private String  estado_coche;
    private int     potencia_coche;
    private int     velocidad_coche;
    private int     kilometros_recorridos;

    public Coche(String nombre_piloto, int dorsal_piloto, int distancia_carrera) {
        this.nombre_piloto = nombre_piloto;
        this.dorsal_piloto = dorsal_piloto;
        this.distancia_carrera = distancia_carrera;
        this.estado_coche = "PARADO";
        this.potencia_coche = 50;
        this.velocidad_coche = 0;
        this.kilometros_recorridos = 0;
    }
    
    /**
     * @return the nombre_piloto
     */
    public String getNombre_piloto() {
        return nombre_piloto;
    }

    /**
     * @param nombre_piloto the nombre_piloto to set
     */
    public void setNombre_piloto(String nombre_piloto) {
        this.nombre_piloto = nombre_piloto;
    }

    /**
     * @return the dorsal_piloto
     */
    public int getDorsal_piloto() {
        return dorsal_piloto;
    }

    /**
     * @param dorsal_piloto the dorsal_piloto to set
     */
    public void setDorsal_piloto(int dorsal_piloto) {
        this.dorsal_piloto = dorsal_piloto;
    }

    /**
     * @return the distancia_carrera
     */
    public int getDistancia_carrera() {
        return distancia_carrera;
    }

    /**
     * @param distancia_carrera the distancia_carrera to set
     */
    public void setDistancia_carrera(int distancia_carrera) {
        this.distancia_carrera = distancia_carrera;
    }

    /**
     * @return the estado_coche
     */
    public String getEstado_coche() {
        return estado_coche;
    }

    /**
     * @param estado_coche the estado_coche to set
     */
    public void setEstado_coche(String estado_coche) {
        this.estado_coche = estado_coche;
    }

    /**
     * @return the potencia_coche
     */
    public int getPotencia_coche() {
        return potencia_coche;
    }

    /**
     * @param potencia_coche the potencia_coche to set
     */
    public void setPotencia_coche(int potencia_coche) {
        this.potencia_coche = potencia_coche;
    }

    /**
     * @return the velocidad_coche
     */
    public int getVelocidad_coche() {
        return velocidad_coche;
    }

    /**
     * @param velocidad_coche the velocidad_coche to set
     */
    public void setVelocidad_coche(int velocidad_coche) {
        this.velocidad_coche = velocidad_coche;
    }

    /**
     * @return the kilometros_recorridos
     */
    public int getKilometros_recorridos() {
        return kilometros_recorridos;
    }

    /**
     * @param kilometros_recorridos the kilometros_recorridos to set
     */
    public void setKilometros_recorridos(int kilometros_recorridos) {
        this.kilometros_recorridos = kilometros_recorridos;
    }
    
    //Arrancar. Pone el coche en marcha.
    // Acelerar. Cada vez que se acelera, se generará un aleatorio entre 0 y
    //potencia, que se incrementará a la velocidad y será el espacio en
    //Kilómetros que recorra.
    // Frenar. Frena funciona igual que acelerar pero reduciendo velocidad.
    // Rearrancar. Un coche podrá rearrancar cuando esté accidentado y
    //ningún otro coche haya terminado la carrera
    public int velocidadAleatoria(){
        Random r = new Random();
        int num_aleatorio = r.nextInt(0 - 50);
        return num_aleatorio;
    }
    public void acelerar(){
        int aleatorio = velocidadAleatoria();
        if(velocidad_coche+aleatorio<=200){
            System.out.println("Velocidad del coche aumentada !");
            System.out.println("+"+aleatorio+" km/h");
            velocidad_coche += aleatorio;
            kilometros_recorridos += aleatorio;
        }else{
            System.out.println("Te has estrellado");
            estado_coche = "ACCIDENTADO";
            velocidad_coche = 0;
        }
        System.out.println("VELOCIDAD ACTUAL : "+velocidad_coche);
    }
    public void frenar(){
        int aleatorio = velocidadAleatoria();
        System.out.println("Velocidad del coche disminuida !");
        System.out.println("-"+aleatorio+" km/h");
        if(aleatorio>velocidad_coche){
            estado_coche = "PARADO";
            velocidad_coche = 0;
        }else{
            velocidad_coche -= aleatorio;
        }
        System.out.println("VELOCIDAD ACTUAL : "+velocidad_coche);
    }
    public void rearrancar(){
        estado_coche = "";
    }
}
