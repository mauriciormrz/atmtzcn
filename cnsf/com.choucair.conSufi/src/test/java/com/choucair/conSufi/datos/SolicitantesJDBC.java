package com.choucair.conSufi.datos;


import java.sql.*;
import java.util.*;

import com.choucair.conSufi.domain.Solicitante;

/**
 * Clase que contiene los metodos de SELECT, INSERT, UPDATE y DELETE para la
 * tabla  en MYSQL
 *
 *
 */
public class SolicitantesJDBC {
    //Nos apoyamos de la llave primaria autoincrementable de MySql
    //Se utiliza un prepareStatement, por lo que podemos
    //utilizar parametros (signos de ?)
    //los cuales posteriormente sean sustituidos por el parametro respectivo

    private final String SQL_INSERT
            = "INSERT INTO solicitantes(application_id, nombre, apellido, tipo_documento, documento, celular, correo_electronico) VALUES(?,?,?,?,?,?,?)";

    private final String SQL_UPDATE
            = "UPDATE solicitantes SET nombre=?, apellido=? WHERE solicitante_id=?";

    private final String SQL_DELETE
            = "DELETE FROM solicitantes WHERE solicitante_id = ?";

    private final String SQL_SELECT
            = "SELECT solicitante_id, application_id, nombre, apellido FROM solicitantes ORDER BY solicitante_id";


    private final String SQL_SELECT_ULTIMO_REGISTRO
    = "SELECT solicitante_id, application_id, nombre, apellido FROM solicitantes ORDER BY solicitante_id DESC LIMIT 1";

 /**
 * 
 * @param application_id
 * @param nombre
 * @param apellido
 * @param tipo_documento
 * @param documento
 * @param celular
 * @param correo_electronico
 * @return 
 */
    public int insert(Integer application_id, String nombre, String apellido, String tipo_documento, String documento, String celular, String correo_electronico ) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0; //registros afectados
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;//contador de columnas
            stmt.setInt(index++, application_id);
            stmt.setString(index++, nombre);//param 1 => ?
            stmt.setString(index++, apellido);//param 2 => ?
            stmt.setString(index++, tipo_documento);//param 3 => ?
            stmt.setString(index++, documento);//param 4 => ?
            stmt.setString(index++, celular);//param 5 => ?
            stmt.setString(index++, correo_electronico);//param 6 => ?
            //System.out.println("Ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();//no. registros afectados
            //System.out.println("Registros afectados:" + rows);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

/**
 *  Metodo que actualiza un registro existente
 * @return 
 */
    public int update(int solicitante_id, String nombre, String apellido) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            stmt.setString(index++, nombre);
            stmt.setString(index++, apellido);
            stmt.setInt(index, solicitante_id);
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizados:" + rows);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    /**
     * Metodo que elimina un registro existente
     * @return int No. registros afectados
     */
    public int delete(int solicitante_id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, solicitante_id);
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    /**
     * Metodo que regresa el contenido de la tabla 
     */
    
	public List<Solicitante> select() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Solicitante solicitante = null;
        List<Solicitante> solicitantes = new ArrayList<Solicitante>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int solicitante_id = rs.getInt(1);
                int application_id = rs.getInt(2);
                String nombre = rs.getString(3);
                String apellido = rs.getString(4);
                /*System.out.print(" " + id_persona);
                 System.out.print(" " + nombre);
                 System.out.print(" " + apellido);
                 System.out.println();
                 */
                solicitante = new Solicitante();
                solicitante.setSolicitante_id(solicitante_id);
                solicitante.setApplication_id(application_id);
                solicitante.setNombre(nombre);
                solicitante.setApellido(apellido);
                solicitantes.add(solicitante);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return solicitantes;
    }
	
	public Solicitante ultimoSolicitante() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Solicitante solicitante = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ULTIMO_REGISTRO);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int solicitante_id = rs.getInt(1);
                int application_id = rs.getInt(2);
                String nombre = rs.getString(3);
                String apellido = rs.getString(4);

                solicitante = new Solicitante();
                solicitante.setSolicitante_id(solicitante_id);
                solicitante.setApplication_id(application_id);
                solicitante.setNombre(nombre);
                solicitante.setApellido(apellido);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return solicitante;
    }
}

