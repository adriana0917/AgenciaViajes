
package modelo;

import conexion.ConexionLogin;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Adriana
 */
public class Usuario {
    private String userName;
    private String clave;
    
    ConexionLogin cone = new ConexionLogin();
    Connection con;
    PreparedStatement pst;
    String sql;
    ResultSet res;
    ResultSetMetaData rmeta;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }  

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public int validarLogin(String usu, String pass){
        int resultado = 0;
        try{
            sql = "select * from tb_usuario where userName = '" + usu + "' "
                    + "&& clave = '"+ pass +"'";
            Class.forName(cone.getDriver());
            con = DriverManager.getConnection(
            cone.getUrl(), cone.getUser(), cone.getPassword());
            pst = con.prepareStatement(sql);
            res = pst.executeQuery();
            rmeta = res.getMetaData();
            if(res.next()){
                resultado=1;
            }           
        }
        catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e, "Error de conexion", JOptionPane.ERROR_MESSAGE);
        }
        return resultado;
    }
    
}
