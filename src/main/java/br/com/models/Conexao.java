package br.com.models;

import br.com.utils.TipoBanco;

public class Conexao {
  private String driverClass;
  private String url;
  private String servidor;
  private String instancia;
  private String banco;
  private String porta;
  private String usuario;
  private String senha;

  public Conexao(String driverClass, String url, String servidor, String instancia,
                 String banco, String porta, String usuario, String senha) {
    this.driverClass = driverClass;
    this.url = url;
    this.servidor = servidor;
    this.instancia = instancia;
    this.banco = banco;
    this.porta = porta;
    this.usuario = usuario;
    this.senha = senha;
  }

  public Conexao() {
  }

  public String getDriverClass() {
    return driverClass;
  }

  public void setDriverClass(String driverClass) {
    this.driverClass = driverClass;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(TipoBanco tipoBanco) {
    StringBuilder sb = new StringBuilder();
    switch (tipoBanco.name()) {
      case "SQLSERVER":
        sb.append("jdbc:jtds:sqlserver://").append(servidor).append(":").append(porta).append("/").append(banco)
            .append(instancia.isEmpty() ? "" : ";instance=" + instancia);
        break;
      case "POSTGRESSQL":
        sb.append("jdbc:postgresql://").append(servidor).append(":").append(porta).append("/").append(banco);
        break;
      case "MYSQL":
        sb.append("jdbc:mysql://").append(servidor).append(":").append(porta).append("/").append(banco);
        break;
      case "FIREBIRD":
        sb.append("jdbc:firebirdsql://").append(servidor).append("/").append(banco).append("?cl_ctype=ISO8859_1");
        break;
      case "ORACLE":
        sb.append("jdbc:oracle:thin:@").append(servidor).append(":").append(porta).append("/").append(banco);
        break;
    }
    this.url = sb.toString();
  }

  public String getServidor() {
    return servidor;
  }

  public void setServidor(String servidor) {
    this.servidor = servidor;
  }

  public String getInstancia() {
    return instancia;
  }

  public void setInstancia(String instancia) {
    this.instancia = instancia;
  }

  public String getBanco() {
    return banco;
  }

  public void setBanco(String banco) {
    this.banco = banco;
  }

  public String getPorta() {
    return porta;
  }

  public void setPorta(String porta) {
    this.porta = porta;
  }

  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }
}
