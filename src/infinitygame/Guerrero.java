/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infinitygame;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

/**
 *
 * @author Mauricio
 */
public class Guerrero extends Jugador {

    private int furia;

    public Guerrero(String nombre, int numCasillas) {
        super(nombre, numCasillas);
        this.furia = 5;
    }

    public void enfurecerse(ArrayList<Jugador> players) {
        if (this.furia > 0) {
            System.out.println("A que jugador le va a inflingir 1 de daño físico?");
            System.out.println("Ingrese el nombre del jugador");
            Scanner sc = new Scanner(System.in);
            String name = sc.next();
            Iterator<Jugador> it = players.iterator();
            while (it.hasNext()) {
                Jugador jugador = it.next();
                if (jugador.getName().equals(name)) {
                    jugador.cambiarVida(-1);
                }
            }
            this.furia -= 1;

        } else {
            System.out.println("Su furia es insuficiente para realizar esta acción");
        }
    }
    
    public String getClase(){
        return "guerrero";
    }
}
