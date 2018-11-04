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
public class Reliquia {

    public int activarReliquia(int suerte) {
        Random r = new Random();
        if (suerte == 1) {
            float probabilidadLucky = r.nextFloat();
            if (probabilidadLucky <= 0.50f) {
                return 1;

            } else {
                return 2;
            }
        } else {
            float probabilidad = r.nextFloat();
            if (probabilidad <= 0.01f) {
                return 1;
            } else {
                return 2;
            }
        }
    }
}
