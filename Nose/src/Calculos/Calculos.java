/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculos;

import BaseDatos.*;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author TaniaEsparza
 */
public class Calculos {

    private float Impuestos;
    private float Ganancias;
    private float Perdidas;
    private float IVA;
    private float IVAr;
    private float Subtotal;
    private float IngresoNeto;
    private String Fecha;
    private float ImpuestosM;
    float a;
    float aa;
        float ga;
            float pa;
    float b;
    float SueldoIVA;

    public Calculos() {
        Impuestos = 0;
        Ganancias = 0;
        Perdidas = 0;
        IVA = 0;
        IVAr = 0;
        Fecha = " ";
        Subtotal = 0;
        IngresoNeto = 0;
        ImpuestosM = 0;
        SueldoIVA = 0;
    }

    public float CalcularImpuestosFactura(float Importe) {
        IVA = (float) (Importe * 0.16);
        Impuestos = IVA;
        return Impuestos;
    }

    public float CalcularImpuestosRecibo(float Importe) {
        IVA = (float) (Importe * 0.16);
        IVAr = (float) (Importe * 0.1067);
        Subtotal = (float) (IVA - IVAr);
        return Subtotal;
    }

    public float ImpuestosMensuales(String mes, String anyo) {
        try {
            // fecha = "Cmbanyo.getText()+"-"+CmbMes.getText()";
            Conexion mConexion = new Conexion();
            mConexion.Conectar("localhost", "noseprueba", "root", "1234");
            String impuestos = ("select SUM(Impuesto) as total from Recibo_Factura where fecha >= '?2-?1-01' and fecha <= '?2-?1-31' and Tipo='Recibo';");
            impuestos = impuestos.replace("?1", mes);
            impuestos = impuestos.replace("?2", anyo);
            ResultSet listaimpuestos = mConexion.ejecutarConsulta(impuestos);
            if (listaimpuestos != null) {
                while (listaimpuestos.next()) {

                    a = listaimpuestos.getFloat("total");

                    System.out.println(a);
                    return a;
                }

            }
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Error al realizar Consulta");
            System.out.println(error.toString());
        }
        return ImpuestosM;
    }

    public float ImpuestosMensualesF(String mes, String anyo) {
        try {
            // fecha = "Cmbanyo.getText()+"-"+CmbMes.getText()";
            Conexion mConexion = new Conexion();
            mConexion.Conectar("localhost", "noseprueba", "root", "1234");
            String impuestosf = ("select SUM(Impuesto) as total from Recibo_Factura where fecha >= '?2-?1-01' and fecha <= '?2-?1-31' and Tipo='Factura';");
            impuestosf = impuestosf.replace("?1", mes);
            impuestosf = impuestosf.replace("?2", anyo);
            ResultSet listaimpuestosf = mConexion.ejecutarConsulta(impuestosf);
            if (listaimpuestosf != null) {
                while (listaimpuestosf.next()) {

                    b = listaimpuestosf.getFloat("total");

                    System.out.println(b);
                    return b;
                }

            }
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Error al realizar Consulta");
            System.out.println(error.toString());
        }
        return ImpuestosM;
    }

    public float CalcularGananciasPerdidasMensuales() {
        this.Ganancias = a - b;
        if (this.Ganancias < 0) {
            return Ganancias;
        } else if (Ganancias > 0) {
            Perdidas = a - b;
            return Perdidas;
        } else {
            return 0;
        }
    }

    public float ImpuestosAnuales(String anyo) {
        try {
            // fecha = "Cmbanyo.getText()+"-"+CmbMes.getText()";
            Conexion mConexion = new Conexion();
            mConexion.Conectar("localhost", "noseprueba", "root", "1234");
            String impuestos = ("select SUM(Impuestos) as total from resultados where Fecha >= '?2-01-01' and Fecha <= '?2-12-31';");
            impuestos = impuestos.replace("?2", anyo);
            ResultSet listaimpuestosA = mConexion.ejecutarConsulta(impuestos);
            if (listaimpuestosA != null) {
                while (listaimpuestosA.next()) {

                    aa= listaimpuestosA.getFloat("total");

                    System.out.println(aa);
                    return aa;
                }

            }
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Error al realizar Consulta");
            System.out.println(error.toString());
        }
        return ImpuestosM;

    }

    public float GananciasAnuales(String anyo) {
          try {
            // fecha = "Cmbanyo.getText()+"-"+CmbMes.getText()";
            Conexion mConexion = new Conexion();
            mConexion.Conectar("localhost", "noseprueba", "root", "1234");
            String impuestos = ("select SUM(Ganancias) as total from resultados where Fecha >= '?2-01-01' and Fecha <= '?2-12-31';");
            impuestos = impuestos.replace("?2", anyo);
            ResultSet listaimpuestosA = mConexion.ejecutarConsulta(impuestos);
            if (listaimpuestosA != null) {
                while (listaimpuestosA.next()) {

                    ga= listaimpuestosA.getFloat("total");

                    System.out.println(ga);
                    return ga;
                }

            }
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Error al realizar Consulta");
            System.out.println(error.toString());
        }
        return ImpuestosM;

    }
    
    public float PerdidasAnuales(String anyo) {
          try {
            // fecha = "Cmbanyo.getText()+"-"+CmbMes.getText()";
            Conexion mConexion = new Conexion();
            mConexion.Conectar("localhost", "noseprueba", "root", "1234");
            String impuestos = ("select SUM(Perdidas) as total from resultados where Fecha >= '?2-01-01' and Fecha <= '?2-12-31';");
            impuestos = impuestos.replace("?2", anyo);
            ResultSet listaimpuestosPA = mConexion.ejecutarConsulta(impuestos);
            if (listaimpuestosPA != null) {
                while (listaimpuestosPA.next()) {

                    pa= listaimpuestosPA.getFloat("total");

                    System.out.println(pa);
                    return pa;
                }

            }
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Error al realizar Consulta");
            System.out.println(error.toString());
        }
        return ImpuestosM;

    }

}
