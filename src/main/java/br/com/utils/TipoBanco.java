package br.com.utils;

public enum TipoBanco {
  SQLSERVER("net.sourceforge.jtds.jdbc.Driver"), POSTGRESSQL("org.postgresql.Driver"),
  MYSQL("com.mysql.jdbc.Driver"), FIREBIRD("org.firebirdsql.jdbc.FBDriver"),
  ORACLE("oracle.jdbc.driver.OracleDriver");

  private String driverClass;

  TipoBanco(String driverClass) {
    this.driverClass = driverClass;
  }

  public String getDriverClass() {
    return driverClass;
  }

  public void setDriverClass(String driverClass) {
    this.driverClass = driverClass;
  }
}
