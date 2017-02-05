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
public class Paquete {
    private int codPaquete;
    private String descripcion;
    private int codPais;
    private Double precio;
    private int numDias;
    private int codHotel;
    private int codAerolinea;

    public Paquete() {
    }

    public Paquete(int codPaquete, String descripcion, int codPais, Double precio, int numDias, int codHotel, int codAerolinea) {
        this.codPaquete = codPaquete;
        this.descripcion = descripcion;
        this.codPais = codPais;
        this.precio = precio;
        this.numDias = numDias;
        this.codHotel = codHotel;
        this.codAerolinea = codAerolinea;
    }

    public int getCodPaquete() {
        return codPaquete;
    }

    public void setCodPaquete(int codPaquete) {
        this.codPaquete = codPaquete;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCodPais() {
        return codPais;
    }

    public void setCodPais(int codPais) {
        this.codPais = codPais;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getNumDias() {
        return numDias;
    }

    public void setNumDias(int numDias) {
        this.numDias = numDias;
    }

    public int getCodHotel() {
        return codHotel;
    }

    public void setCodHotel(int codHotel) {
        this.codHotel = codHotel;
    }

    public int getCodAerolinea() {
        return codAerolinea;
    }

    public void setCodAerolinea(int codAerolinea) {
        this.codAerolinea = codAerolinea;
    }
    
    public boolean insertarPaquete(Paquete pqu) {
        try {
            Conexion cone = new Conexion();
            String sql = "insert into tb_paquete values(0,?,?,?,?,?,?)";
            PreparedStatement pst = cone.getConexion().prepareStatement(sql);
            pst.setObject(1, pqu.getDescripcion());
            pst.setObject(2, pqu.getCodPais());
            pst.setObject(3, pqu.getPrecio());
            pst.setObject(4, pqu.getNumDias());
            pst.setObject(5, pqu.getCodHotel());
            pst.setObject(6, pqu.getCodAerolinea());
            pst.execute();
            pst.close();
            cone.desconectar();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public boolean editarPaquete(Paquete pqu) {
            Conexion cone = new Conexion();            
            String sql = "update tb_paquete set descripcion = '"+ pqu.getDescripcion()+"',codPais ="+pqu.getCodPais()+",precio="+pqu.getPrecio()+",numDias="+pqu.getNumDias()+",codHotel="+pqu.getCodHotel()+",codAerolinea="+pqu.getCodAerolinea()+" where codPaquete ="+pqu.getCodPaquete();
            return cone.ejecutar(sql);
    }
    
    public boolean eliminarPaquete(int id) {
        Conexion cone = new Conexion();
        String sql = "delete from tb_paquete where codPaquete = " + id;
        return cone.ejecutar(sql);
        
    }
    
    public ArrayList<Paquete> mostrarPaquete() {
        ArrayList<Paquete> lista = new ArrayList<>();
        try {
           Conexion cone = new Conexion();
            String sql = "select * from tb_paquete";
            ResultSet rs = cone.consultar(sql);
            while (rs.next()) {
                Paquete pqu = new Paquete();
                pqu.setCodPaquete(rs.getInt(1));
                pqu.setDescripcion(rs.getString(2));
                pqu.setCodPais(rs.getInt(3));
                pqu.setPrecio(rs.getDouble(4));
                pqu.setNumDias(rs.getInt(5));
                pqu.setCodHotel(rs.getInt(6));
                pqu.setCodAerolinea(rs.getInt(7));
                lista.add(pqu);
            }
            cone.desconectar();
        } catch (SQLException ex) {
            System.err.println("Error al mostrar Paquetes:" + ex);
        }
        return lista;
    }
    
}
