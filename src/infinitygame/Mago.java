/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infinitygame;

/**
 *
 * @author Mauricio
 */
public class Mago extends Jugador {

    int mana;

    public Mago(String nombre, int numCasillas) {
        super(nombre, numCasillas);
        this.meditar = 7;
        this.mana = 5;
    }

    public void concentracion(Guardian guardian) {
        if (this.mana > 0) {
            guardian.restarVida(2);
            System.out.println("Se ha inflingido dos puntos de daño al guardian");
            this.mana -= 1;
            System.out.println("Se ha restado uno de mana por realizar esta acción");

        } else {
            System.out.println("Tu mana es insuficiente para realizar esta acción");
        }
    }
    
        public String getClase(){
        return "mago";
    }

}
