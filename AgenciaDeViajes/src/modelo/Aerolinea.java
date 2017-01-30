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
public class Aerolinea {
    private int codAerolinea;
    private String nombre;

    public Aerolinea() {
    }

    public Aerolinea(int codAerolinea, String nombre) {
        this.codAerolinea = codAerolinea;
        this.nombre = nombre;
    }

    public int getCodAerolinea() {
        return codAerolinea;
    }

    public void setCodAerolinea(int codAerolinea) {
        this.codAerolinea = codAerolinea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public boolean insertarAerolinea(Aerolinea aerolinea) {
        try {
            Conexion cone = new Conexion();
            String sql = "insert into tb_aerolinea values(0,?)";
            PreparedStatement pst = cone.getConexion().prepareStatement(sql);
            //pst.setObject(1, aerolinea.getCodAerolinea());         
            pst.setObject(1, aerolinea.getNombre());
            pst.execute();
            pst.close();
            cone.desconectar();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }   
    public boolean editarAerolinea(Aerolinea aerolinea) {
            Conexion cone = new Conexion();
            String sql = "update tb_aerolinea set nombre = '"+ aerolinea.getNombre()+"'"+ "where codAerolinea ="+aerolinea.getCodAerolinea();
            return cone.ejecutar(sql);
    }
    
    public boolean eliminarAerolinea(int id) {
        Conexion cone = new Conexion();
        String sql = "delete from tb_aerolinea where codAerolinea = " + id;
        return cone.ejecutar(sql);
        
    }
    
    public ArrayList<Aerolinea> mostrarAerolinea() {
        ArrayList<Aerolinea> lista = new ArrayList<>();
        try {
           Conexion cone = new Conexion();
            String sql = "select * from tb_aerolinea";
            ResultSet rs = cone.consultar(sql);
            while (rs.next()) {
                Aerolinea aero = new Aerolinea();
                aero.setCodAerolinea(rs.getInt(1));
                aero.setNombre(rs.getString(2));
                
                lista.add(aero);
            }
            cone.desconectar();
        } catch (SQLException ex) {
            System.err.println("Error al mostrar Aerolineas:" + ex);
        }
        return lista;
    }
    
}
