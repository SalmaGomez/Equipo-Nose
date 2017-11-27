/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Interfaz.*;

/**
 *
 * @author Alumno
 */
public class Main {

    public void correr() {
        FrmInterfaz1 minicio = new FrmInterfaz1();
        minicio.setVisible(true);
    }

    public static void main(String args[]) {

        Main mMain = new Main();
        mMain.correr();

    }

}
