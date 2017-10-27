package br.com.swing;

import br.com.acoes.AcaoConectar;
import br.com.utils.TipoBanco;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame {
  private static final long serialVersionUID = 1L;

  private static JComboBox<TipoBanco[]> cbxBancos;
  private static JTextField txfServidor;
  private static JTextField txfInstancia;
  private static JTextField txfBanco;
  private static JTextField txfPorta;
  private static JTextField txfUsuario;
  private static JTextField txfSenha;

  private static TipoBanco[] bancos;

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          App frame = new App();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  public App() {
    setTitle("Testa conexão com banco de dados");
    setResizable(false);
    setBounds(100, 100, 597, 170);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panelTop = new JPanel();
    getContentPane().add(panelTop, BorderLayout.NORTH);
    panelTop.setLayout(new MigLayout("", "[60][120][60][120][60][120]",
        "[40][][][]"));

    bancos = TipoBanco.values();

    cbxBancos = new JComboBox();
    cbxBancos.setModel(new DefaultComboBoxModel(bancos));
    panelTop.add(cbxBancos, "cell 0 0 2 1,growx");

    JLabel lbServidor = new JLabel("Servidor");
    panelTop.add(lbServidor, "cell 0 1,alignx trailing");

    txfServidor = new JTextField();
    // txfServidorDestino.setText(config.getServidorDestino());
    panelTop.add(txfServidor, "cell 1 1,growx");
    txfServidor.setColumns(10);

    JLabel lblInstancia = new JLabel("Inst\u00E2ncia");
    panelTop.add(lblInstancia, "cell 2 1,alignx right");

    txfInstancia = new JTextField();
    // txfInstanciaDestino.setText(config.getInstanciaDestino());
    panelTop.add(txfInstancia, "cell 3 1,growx");
    txfInstancia.setColumns(10);

    JLabel lblBanco = new JLabel("Banco");
    panelTop.add(lblBanco, "cell 4 1,alignx trailing,aligny baseline");

    txfBanco = new JTextField();
    // txfBancoDestino.setText(config.getBancoDestino());
    panelTop.add(txfBanco, "cell 5 1,growx");
    txfBanco.setColumns(15);
    // btnTestaDestino.addActionListener(new
    // ActionTestaDestino());

    JLabel lblPorta = new JLabel("Porta");
    panelTop.add(lblPorta, "cell 0 2,alignx trailing");

    txfPorta = new JTextField();
    // txfPortaDestino.setText(config.getPortaDestino());
    panelTop.add(txfPorta, "cell 1 2,growx");
    txfPorta.setColumns(10);

    JLabel lblUsuario = new JLabel("Usu\u00E1rio");
    panelTop.add(lblUsuario, "cell 2 2,alignx trailing,aligny top");

    txfUsuario = new JTextField();
    // txfUsuarioDestino.setText(config.getUsuarioDestino());
    panelTop.add(txfUsuario, "cell 3 2,growx,aligny top");
    txfUsuario.setColumns(10);

    JLabel lblSenha = new JLabel("Senha");
    lblSenha.setHorizontalAlignment(SwingConstants.RIGHT);
    panelTop.add(lblSenha, "cell 4 2,alignx trailing,aligny top");

    txfSenha = new JPasswordField();
    // txfSenhaDestino.setText(config.getSenhaDestino());
    panelTop.add(txfSenha, "cell 5 2,growx,aligny top");

    JButton btnTestar = new JButton("Testar");
    btnTestar.addActionListener(new AcaoConectar());
    panelTop.add(btnTestar, "cell 5 3 2 1");
  }

  public static JComboBox<TipoBanco[]> getCbxBancos() {
    return cbxBancos;
  }

  public static void setCbxBancos(JComboBox<TipoBanco[]> cbxBancos) {
    App.cbxBancos = cbxBancos;
  }

  public static JTextField getTxfServidor() {
    return txfServidor;
  }

  public static void setTxfServidor(JTextField txfServidor) {
    App.txfServidor = txfServidor;
  }

  public static JTextField getTxfInstancia() {
    return txfInstancia;
  }

  public static void setTxfInstancia(JTextField txfInstancia) {
    App.txfInstancia = txfInstancia;
  }

  public static JTextField getTxfBanco() {
    return txfBanco;
  }

  public static void setTxfBanco(JTextField txfBanco) {
    App.txfBanco = txfBanco;
  }

  public static JTextField getTxfPorta() {
    return txfPorta;
  }

  public static void setTxfPorta(JTextField txfPorta) {
    App.txfPorta = txfPorta;
  }

  public static JTextField getTxfUsuario() {
    return txfUsuario;
  }

  public static void setTxfUsuario(JTextField txfUsuario) {
    App.txfUsuario = txfUsuario;
  }

  public static JTextField getTxfSenha() {
    return txfSenha;
  }

  public static void setTxfSenha(JTextField txfSenha) {
    App.txfSenha = txfSenha;
  }

  public static TipoBanco[] getBancos() {
    return bancos;
  }

  public static void setBancos(TipoBanco[] bancos) {
    App.bancos = bancos;
  }
}