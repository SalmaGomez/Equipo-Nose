/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

/**
 *
 * @author NOSE
 */
import java.sql.*;

public class Conexion {

    private Connection conexion;
    private Statement comando;

    @SuppressWarnings("empity-statement")



    //agregar en el main o de donde se mande llamar la conexion 
            //los datos del servidor,base de datos,usuario,contrasena
    //ejemplo Conexion.Conectar(localhost, BD_NOSE, root, "") 
        public boolean Conectar(String Host, String BD, String User, String Password) throws Exception {
        try {
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            this.conexion = DriverManager.getConnection("jdbc:mysql://" + Host + "/" + BD, User, Password);
            this.comando = conexion.createStatement();
            return true;
        } catch (SQLException exc) {
            System.out.println("Error " + exc.toString());
            this.conexion.close();
            return false;
        }
    }

}
