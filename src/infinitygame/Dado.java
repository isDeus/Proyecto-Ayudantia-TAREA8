/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infinitygame;

import java.util.*;

/**
 *
 * @author Mauricio
 */
public class Dado {

    private int caraResultante;

    public int lanzarDado() {
        int dado[] = {1, 2, 3, 4, 5, 6};
        int idx = new Random().nextInt(dado.length);
        int idx2 = new Random().nextInt(dado.length);
        int dado1 = dado[idx];
        int dado2 = dado[idx2];
        caraResultante = (dado1 + dado2);
        System.out.println("La suma de tus dados es " + caraResultante);
        return caraResultante;
    }

//    public int reliquia(int suerte) {
//        Random r = new Random();
//        if (suerte == 1) {
//            float probabilidadLucky = r.nextFloat();
//            if (probabilidadLucky <= 0.50f) {
//                return 1;
// 
//            } else {
//                return 0;
//            }
//        } else {
//            float probabilidad = r.nextFloat();
//            if (probabilidad <= 0.01f) {
//                return 1;
//            } else {
//                return 0;
//            }
//        }
//    }

}
