/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Adriana
 */
public class Pais {
    private int codPais;
    private String nombre;

    public Pais(int codPais, String nombre) {
        this.codPais = codPais;
        this.nombre = nombre;
    }

    public Pais() {
    }

    public int getCodPais() {
        return codPais;
    }

    public void setCodPais(int codPais) {
        this.codPais = codPais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }       
    
    public boolean insertarPais(Pais pais) {
        try {
            Conexion cone = new Conexion();
            String sql = "insert into tb_pais values(0,?)";
            PreparedStatement pst = cone.getConexion().prepareStatement(sql);            
            pst.setObject(1, pais.getNombre());
            pst.execute();
            pst.close();
            cone.desconectar();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }   
    public boolean editarPais(Pais pais) {
            Conexion cone = new Conexion();
            String sql = "update tb_pais set nombre = '"+ pais.getNombre()+"'"+ "where codPais ="+pais.getCodPais();
            return cone.ejecutar(sql);
    }
    
    public boolean eliminarPais(int id) {
        Conexion cone = new Conexion();
        String sql = "delete from tb_pais where codPais = " + id;
        return cone.ejecutar(sql);
        
    }
    
    public ArrayList<Pais> mostrarPais() {
        ArrayList<Pais> lista = new ArrayList<>();
        try {
           Conexion cone = new Conexion();
            String sql = "select * from tb_pais";
            ResultSet rs = cone.consultar(sql);
            while (rs.next()) {
                Pais pais = new Pais();
                pais.setCodPais(rs.getInt(1));
                pais.setNombre(rs.getString(2));
                
                lista.add(pais);
            }
            cone.desconectar();
        } catch (SQLException ex) {
            System.err.println("Error al mostrar Paises:" + ex);
        }
        return lista;
    }
    
}
