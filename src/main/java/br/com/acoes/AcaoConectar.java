package br.com.acoes;

import br.com.conexao.Conectar;
import br.com.models.Conexao;
import br.com.swing.App;
import br.com.utils.TipoBanco;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AcaoConectar implements ActionListener {

  @SuppressWarnings("deprecation")
  public void actionPerformed(ActionEvent arg0) {
    try {
      Conexao conexao = new Conexao();
      TipoBanco tipoBanco = (TipoBanco) App.getCbxBancos().getSelectedItem();
      conexao.setDriverClass(tipoBanco.getDriverClass());
      conexao.setServidor(App.getTxfServidor().getText());
      conexao.setPorta(App.getTxfPorta().getText());
      conexao.setBanco(App.getTxfBanco().getText());
      conexao.setInstancia(App.getTxfInstancia().getText());
      conexao.setUsuario(App.getTxfUsuario().getText());
      conexao.setSenha(App.getTxfSenha().getText());
      conexao.setUrl(tipoBanco);

      Conectar.getInstance().testaConn(conexao);

      JOptionPane.showMessageDialog(null,
          "Teste de conexão concluído com sucesso!", "Informação", JOptionPane.INFORMATION_MESSAGE);

    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Falha na conexão!!\n" + e.getMessage(), "Erro",
          JOptionPane.INFORMATION_MESSAGE);
    }
  }
}
