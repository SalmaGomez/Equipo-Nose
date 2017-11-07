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
    private float Utilidad_Bruta;
    private float IVA;
    private float ISR;
    private float IVAr;
    private float Retenciones;
    private String Fecha;
    private float ImpuestosM;
    float a;
    float SueldoIVA;

    public Calculos() {
        Impuestos = 0;
        Ganancias = 0;
        Perdidas = 0;
        Utilidad_Bruta = 0;
        Fecha = " ";
    }

    public float CalcularImpuestosFactura(float Importe) {
        IVA = (float) (Importe * 0.16);
        Impuestos = IVA;
        return Impuestos;
    }

    public float CalcularImpuestosRecibo(float Importe) {
        IVA = (float) (Importe * 0.16);

        ISR = (float) (Importe * 0.10);

        IVAr = (float) (Importe * 0.1067);

        Retenciones = (float) (Importe + IVAr);

        Impuestos =  Retenciones - IVAr;

        return Impuestos;
    }

    public float ImpuestosMensuales(String mes, String anyo) {
        try {
            // fecha = "Cmbanyo.getText()+"-"+CmbMes.getText()";
            Conexion mConexion = new Conexion();
            mConexion.Conectar("localhost", "nose_prueba", "root", "nose");
            String impuestos = ("select SUM(Impuesto) as total from recibo_factura where fecha >= '?2-?1-01' and fecha <= '?2-?1-31';");
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

    public float CalcularGananciasPerdidasMensuales(float Sueldo) {
        SueldoIVA = (float) (Sueldo * 0.16);
        this.Ganancias = SueldoIVA - a;
        if (this.Ganancias > 0) {
            return Ganancias;
        } else if (Ganancias < 0) {
            Perdidas = SueldoIVA - a;
            return Perdidas;
        } else {
            return 0;
        }
    }

//    public void CalcularUtilidad_BrutaMensuales() {
//        
//    }

    public void ImpuestosAnuales() {

    }

    public void CalcularGananciasAnuales() {

    }

    public void CalcularPerdidasAnuales() {

    }

    public void CalcularUtilidad_BrutaAnuales() {

    }
}
