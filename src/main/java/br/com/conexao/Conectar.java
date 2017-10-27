package br.com.conexao;

import br.com.models.Conexao;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.PooledConnection;
import java.beans.PropertyVetoException;
import java.sql.SQLException;

public class Conectar {
  private ComboPooledDataSource pool = null;
  private static Conectar uniqueInstance = new Conectar();

  private Conectar() {
  }

  public static Conectar getInstance() {
    return uniqueInstance;
  }

  public PooledConnection conn(Conexao conexao) throws ClassNotFoundException, SQLException, PropertyVetoException {
    if (pool == null && conexao != null) {
      pool = new ComboPooledDataSource();
      pool.setDriverClass(conexao.getDriverClass());
      pool.setJdbcUrl(conexao.getUrl());
      pool.setUser(conexao.getUsuario());
      pool.setPassword(conexao.getSenha());
      pool.setMinPoolSize(5);
      pool.setAcquireIncrement(5);
      pool.setMaxPoolSize(20);
    }
    return pool.getConnectionPoolDataSource().getPooledConnection();
  }

  public void testaConn(Conexao conexao) throws ClassNotFoundException, SQLException, PropertyVetoException {
    pool = null;
    conn(conexao);
    pool.setPreferredTestQuery("SELECT 1");
  }

  public void poolFecha() {
    pool = null;
  }
}
