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
public class Reservacion {
    private int codReserva;    
    private int codPaquete;
    private int codCliente;
    private String fechaSalida;
    private String fechaIngreso;

    public Reservacion() {
    }

    public Reservacion(int codReserva, int codPaquete, int codCliente, String fechaSalida, String fechaIngreso) {
        this.codReserva = codReserva;
        this.codPaquete = codPaquete;
        this.codCliente = codCliente;
        this.fechaSalida = fechaSalida;
        this.fechaIngreso = fechaIngreso;
    }

    public int getCodReserva() {
        return codReserva;
    }

    public void setCodReserva(int codReserva) {
        this.codReserva = codReserva;
    }

    public int getCodPaquete() {
        return codPaquete;
    }

    public void setCodPaquete(int codPaquete) {
        this.codPaquete = codPaquete;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    
    public boolean insertarReservacion(Reservacion resv) {
        try {
            Conexion cone = new Conexion();
            String sql = "insert into tb_reservacion values(0,?,?,?,?)";
            PreparedStatement pst = cone.getConexion().prepareStatement(sql);
            pst.setObject(1, resv.getCodPaquete());
            pst.setObject(2, resv.getCodCliente());
            pst.setObject(3, resv.getFechaSalida());
            pst.setObject(4, resv.getFechaIngreso());            
            pst.execute();
            pst.close();
            cone.desconectar();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public boolean editarReservacion(Reservacion res) {
            Conexion cone = new Conexion();            
            String sql = "update tb_reservacion set codPaquete="+res.getCodPaquete()+",codCliente="+res.getCodCliente()+",FechaSalida='"+res.getFechaSalida()+"',FechaIngreso='"+res.getFechaIngreso()+"' where codReserva ="+res.getCodReserva();
            return cone.ejecutar(sql);
    }
    
    public boolean eliminarReservacion(int id) {
        Conexion cone = new Conexion();
        String sql = "delete from tb_reservacion where codReserva = " + id;
        return cone.ejecutar(sql);
        
    }
    
    public ArrayList<Reservacion> mostrarReservacion() {
        ArrayList<Reservacion> lista = new ArrayList<>();
        try {
           Conexion cone = new Conexion();
            String sql = "select * from tb_reservacion";
            ResultSet rs = cone.consultar(sql);
            while (rs.next()) {
                Reservacion res = new Reservacion();
                res.setCodReserva(rs.getInt(1));
                res.setCodPaquete(rs.getInt(2));
                res.setCodCliente(rs.getInt(3));
                res.setFechaSalida(rs.getString(4));
                res.setFechaIngreso(rs.getString(5));                
                lista.add(res);
            }
            cone.desconectar();
        } catch (SQLException ex) {
            System.err.println("Error al mostrar Reservaciones:" + ex);
        }
        return lista;
    }
    
}
