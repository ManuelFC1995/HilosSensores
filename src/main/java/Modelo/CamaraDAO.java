/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Data.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author manue
 */
public class CamaraDAO {
    Connection con;
   

    public CamaraDAO() {
             
    }
    
   // Elegid//Metodo read camaras (traer las dos camaras) y devolver un Array de tres camaras
    
        public List<Camara> SelectCamaras() throws SQLException {
        ArrayList<Camara> camaras = new ArrayList<>();
     

        if (con != null) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM CAMARA");
            try {
                while (rs != null && rs.next()) {
                    Camara c = new Camara();
                   int id = rs.getInt(1);
                   int tempmaxima = rs.getInt(2);
                     int valosS1 = rs.getInt(3);
                       int valorS2 = rs.getInt(4);
                         int puerta = rs.getInt(5);
                       int motor = rs.getInt(6);

                    c.setCodigo_camara(id);
                    c.setTempMaxima(tempmaxima);
                   c.setValorS1(valosS1);
                c.setValorS2(valorS2);
                c.setPuerta(puerta);
                c.setMotor(motor);

                  
                  
                    //DAO lista de ese usuario
                    camaras.add(c);
                }
            } finally {
                rs.close();
                st.close();
            }
        }
        return camaras;

    }
  // Manu //metodos read de 1 camara por id ( nos trae la camara con toda su info) where id= 1 2 y 3
       public Camara SelectCamaraID(int id) throws SQLException {

        con = Conexion.GetConnection();
        Camara c = new Camara();

        if (con != null) {
            Statement st = con.createStatement();
            try{
      
            ResultSet rs = st.executeQuery("Select *from camara where codigo_camara="+id);
                while (rs != null) {
                   
                    int codigo_camara = rs.getInt(1);
                   int tempmaxima = rs.getInt(2);
                     int valosS1 = rs.getInt(3);
                       int valorS2 = rs.getInt(4);
                         int puerta = rs.getInt(5);
                       int motor = rs.getInt(6);

                    c.setCodigo_camara(codigo_camara);
                    c.setTempMaxima(tempmaxima);
                   c.setValorS1(valosS1);
                c.setValorS2(valorS2);
                c.setPuerta(puerta);
                c.setMotor(motor);

                  
                }
            } finally {
                st.close();
            }

        }
        return c;
    }
  
    
}
