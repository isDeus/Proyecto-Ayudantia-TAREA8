/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infinitygame;

import java.util.Random;

/**
 *
 * @author Mauricio
 */
public class Guardian {
    
    private int vida;
    
    public Guardian(int cantidadJugadores){
        this.vida = (15 * cantidadJugadores);
    }
    
    public int habilidadFuria(){
        Random r = new Random();
        float probabilidadHablidad =  r.nextFloat();
        if(probabilidadHablidad <= 0.02f){
            this.vida =  this.vida + 2;
            return 1;
        } else {
            return 0;
        }
    }
    
    public int getVida(){
        return this.vida;
    }
    
    public void restarVida(int cantidad){
        this.vida = this.vida - cantidad;
        while(this.vida < 0){
            this.vida = 0;
        }
    }
}
