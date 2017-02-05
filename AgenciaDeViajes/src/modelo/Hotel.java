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
public class Hotel {
    private int codHotel;
    private String nombre;

    public Hotel() {
    }

    public int getCodHotel() {
        return codHotel;
    }

    public void setCodHotel(int codHotel) {
        this.codHotel = codHotel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public boolean insertarHotel(Hotel hotel) {
        try {
            Conexion cone = new Conexion();
            String sql = "insert into tb_hotel values(0,?)";
            PreparedStatement pst = cone.getConexion().prepareStatement(sql);            
            pst.setObject(1, hotel.getNombre());
            pst.execute();
            pst.close();
            cone.desconectar();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }   
    public boolean editarHotel(Hotel hotel) {
            Conexion cone = new Conexion();
            String sql = "update tb_hotel set nombre = '"+ hotel.getNombre()+"'"+ "where codHotel ="+hotel.getCodHotel();
            return cone.ejecutar(sql);
    }
    
    public boolean eliminarHotel(int id) {
        Conexion cone = new Conexion();
        String sql = "delete from tb_hotel where codHotel = " + id;
        return cone.ejecutar(sql);
        
    }
    
    public ArrayList<Hotel> mostrarHotel() {
        ArrayList<Hotel> lista = new ArrayList<>();
        try {
           Conexion cone = new Conexion();
            String sql = "select * from tb_hotel";
            ResultSet rs = cone.consultar(sql);
            while (rs.next()) {
                Hotel hotel = new Hotel();
                hotel.setCodHotel(rs.getInt(1));
                hotel.setNombre(rs.getString(2));
                
                lista.add(hotel);
            }
            cone.desconectar();
        } catch (SQLException ex) {
            System.err.println("Error al mostrar Hoteles:" + ex);
        }
        return lista;
    }
    
    
}
