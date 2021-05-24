/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personalsoft.ges_sol_construccion.persistencia.basedatos;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.jdbc.datasource.DataSourceUtils;

/**
 *
 * @author roagudelo
 */
public class PostgresBD 
{

  public static Connection getConexion(DataSource datasource)
         throws Exception
  {
    try {
      return DataSourceUtils.doGetConnection(datasource);
    } catch (SQLException ex) {
      System.out.println(ex);
      throw new Exception("error al conectar a la base de datos..");
    }
  }

  public static void commit(DataSource datasource)
          throws Exception
  {
    commit(getConexion(datasource));
  }

  public static void commit(Connection cnn)
          throws Exception
  {
    try {
      if (cnn == null) {
        return;
      }
      if (cnn.isClosed()) {
        return;
      }
      cnn.commit();
    } catch (SQLException ex) {
      System.out.println(ex);
      throw new Exception("Error al confirmar" + ex.getMessage());
    }
  }

  public static void rollback(DataSource datasource)
          throws Exception
  {
    try {
      getConexion(datasource).rollback();
    } catch (SQLException ex) {
      System.out.println(ex);
    }
  }

}

