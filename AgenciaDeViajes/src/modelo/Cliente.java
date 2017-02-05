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
public class Cliente {
    private int codCliente;
    private String nombre;
    private String direccion;
    private String telefono;
    private String correo;

    public Cliente() {
    }

    public Cliente(int codCliente, String nombre, String direccion, String telefono, String correo) {
        this.codCliente = codCliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public boolean insertarCliente(Cliente cliente) {
        try {
            Conexion cone = new Conexion();
            String sql = "insert into tb_cliente values(0,?,?,?,?)";
            PreparedStatement pst = cone.getConexion().prepareStatement(sql);            
            pst.setObject(1, cliente.getNombre());
            pst.setObject(2, cliente.getDireccion());
            pst.setObject(3, cliente.getTelefono());
            pst.setObject(4, cliente.getCorreo());
            pst.execute();
            pst.close();
            cone.desconectar();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }   
    public boolean editarCliente(Cliente cliente) {
            Conexion cone = new Conexion();
            String sql = "update tb_cliente set nombre = '"+ cliente.getNombre()+"',"
                    + "direccion = '"+cliente.getDireccion()+"',telefono= '"+cliente.getTelefono()+ "',correo='"+cliente.getCorreo()+"'"+ "where codCliente ="+cliente.getCodCliente();
            return cone.ejecutar(sql);
    }
    
    public boolean eliminarCliente(int id) {
        Conexion cone = new Conexion();
        String sql = "delete from tb_cliente where codCliente = " + id;
        return cone.ejecutar(sql);
        
    }
    
    public ArrayList<Cliente> mostrarCliente() {
        ArrayList<Cliente> lista = new ArrayList<>();
        try {
           Conexion cone = new Conexion();
            String sql = "select * from tb_cliente";
            ResultSet rs = cone.consultar(sql);
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setCodCliente(rs.getInt(1));
                cliente.setNombre(rs.getString(2));
                cliente.setDireccion(rs.getString(3));
                cliente.setTelefono(rs.getString(4));
                cliente.setCorreo(rs.getString(5));
                
                lista.add(cliente);
            }
            cone.desconectar();
        } catch (SQLException ex) {
            System.err.println("Error al mostrar Cliente:" + ex);
        }
        return lista;
    }
    
}
