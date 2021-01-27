/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import Data.Conexion;
import Modelo.Camara;
import Modelo.CamaraDAO;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author manue
 */
public class App {
        public static void main(String[] args) throws SQLException {
            Connection c = Conexion.GetConnection();
Camara cm = new Camara();
CamaraDAO cdao = new CamaraDAO();
cm=cdao.SelectCamaraID(1);
            System.out.println(cm);

        
    }
}
