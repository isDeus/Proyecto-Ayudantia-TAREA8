///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
package infinitygame;

/**
 *
 * @author Mauricio
 */
public class Jugador {
    private String name;
    private int health;
    private int position;
    private int numcasillas;
    private int meditar;
    
    public Jugador(String nombre, int numcasillas){
        this.name = nombre;
        this.health = 15;
        this.position = 0;
        this.numcasillas = numcasillas;
        this.meditar = 5;
    }
    
    public void cambiarVida(int vida){
        this.health = (this.health+vida);
        while(this.health>15){
            this.health = 15;
        }
        while(this.health<0){
            this.health = 0;
        }
    }
    
    public void cambiarPosicion(int posicion){
        this.position = (this.position+posicion);
        if(this.position>this.numcasillas){
            this.position = this.numcasillas;
        }
        if(this.position<0){
            this.position = 0;
            //this.position = (this.numcasillas+this.position);
        }
    }
    
    public int getPosicion(){
        return this.position;
    }
    
    public void setPosicion(int lugar){
        this.position=lugar;
    }
    
    public String getName(){
        return this.name;
    }
    public int getSalud(){
        return this.health;
    }
    public int restarMeditar(){
        this.meditar = (this.meditar - 1);
        if(this.meditar<0){
            this.meditar=0;
        }
        return this.meditar;
    }
    
    public int getMeditar(){
        return this.meditar;
    }
}
    