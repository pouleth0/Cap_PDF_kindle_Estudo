/*
*Autor: Paulo H A Moreira...
*github.com/pouleth0
*Obs: Manter divulgar. (sem restrições-manter gratificações do Developer: não e crime;
*Omitir créditos para o autor original, sé torna plagio, é vergonhoso...=)
*
*    Created on : Jul 31, 2017, 9:32:04 AM
*    Author     : kn0w
*/
package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class ControlComponents {

    public String URL=null;
    public static final String DEST = null;
    private static String name = null;
    private static String pass = null;
    @FXML
    private RadioButton rtButtKindl3;
    @FXML
    private RadioButton rtButtGoogl3;
    @FXML
    private RadioButton rtButtFaes4;
    @FXML
    private TextField txtFildUser;
    @FXML
    private PasswordField txtFildPass;
    @FXML
    private Label lbltext;

    @FXML
    private void urlKindl(MouseEvent event) {
        rtButtKindl3.setSelected(true);
        veriFicaEVENTO("kindle");
    }
    @FXML
    private void urlGoogl(MouseEvent event) {
        rtButtGoogl3.setSelected(true);
        veriFicaEVENTO("google");
    }
    @FXML
    private void urlFaes(MouseEvent event) {
        rtButtFaes4.setSelected(true);
        veriFicaEVENTO("faesa");
    }
    @FXML
    private void Sair(ActionEvent event) {
        System.out.println("Bottão Sair..");
        System.exit(0);
    }
    @FXML
    private void Limpar(ActionEvent event) {
        rtButtFaes4.setSelected(false);
        rtButtGoogl3.setSelected(false);
        rtButtKindl3.setSelected(false);
        txtFildUser.setText(null);
        txtFildPass.setText(null);
        System.out.println("Bottão Limpar ");
    }
    @FXML
    private void LoginButt(ActionEvent event) {
        lbltext.setText("sdsadsadsa");
    }
    private void nameLog(ActionEvent event){
    }
    public void PassLog(ActionEvent event){
    }
    public void veriFicaEVENTO(String ex) {
        System.out.println("EX e "+ex);
        switch(ex) {
            case "kindle":
                rtButtFaes4.setSelected(false);
                rtButtGoogl3.setSelected(false);
                System.out.println("selecionado Kindle = "+rtButtKindl3.isSelected());
                System.out.println("Faesa = "+rtButtFaes4.isSelected());
                System.out.println("Google = "+rtButtGoogl3.isSelected());
                this.setURL("http://read.amazon.com");
                break;
            case "google":
                rtButtFaes4.setSelected(false);
                rtButtKindl3.setSelected(false);
                System.out.println("selecionado google = "+rtButtGoogl3.isSelected());
                System.out.println("Kindle = "+rtButtKindl3.isSelected());
                System.out.println("Faesa = "+rtButtFaes4.isSelected());
                this.setURL("https://books.google.com.br/bkshp?hl=pt-BR&tab=wp");
                break;
            case "faesa":
                rtButtGoogl3.setSelected(false);
                rtButtKindl3.setSelected(false);
                System.out.println("selecionado faesa = "+rtButtFaes4.isSelected());
                System.out.println("google = "+rtButtGoogl3.isSelected());
                System.out.println("Kindle = "+rtButtKindl3.isSelected());
                this.setURL("http://biblioteca.faesa.br/biblioteca/index.php");
                break;
        }
    }
    public String getURL() {
        return URL;
    }
    public void setURL(String URL) {
        this.URL = URL;
    }
    public static String getName() {
        return name;
    }
    public static void setName(String name) {
        ControlComponents.name = name;
    }
    public static String getPass() {
        return pass;
    }
    public static void setPass(String pass) {
        ControlComponents.pass = pass;
    }
    public RadioButton getRtButtKindl3() {
        return rtButtKindl3;
    }
    public void setRtButtKindl3(RadioButton rtButtKindl3) {
        this.rtButtKindl3 = rtButtKindl3;
    }
    public RadioButton getRtButtGoogl3() {
        return rtButtGoogl3;
    }
    public void setRtButtGoogl3(RadioButton rtButtGoogl3) {
        this.rtButtGoogl3 = rtButtGoogl3;
    }
    public RadioButton getRtButtFaes4() {
        return rtButtFaes4;
    }
    public void setRtButtFaes4(RadioButton rtButtFaes4) {
        this.rtButtFaes4 = rtButtFaes4;
    }
    public TextField getTxtFildUser() {
        return txtFildUser;
    }
    public void setTxtFildUser(TextField txtFildUser) {
        this.txtFildUser = txtFildUser;
    }
    public PasswordField getTxtFildPass() {
        return txtFildPass;
    }
    public void setTxtFildPass(PasswordField txtFildPass) {
        this.txtFildPass = txtFildPass;
    }
    @FXML
    private void PassLog(KeyEvent event) {
        lbltext.setText("sdsadsadsa");
        new Thread(() -> {
            this.lbltext.setText(txtFildUser.getText());
            lbltext.setText(txtFildUser.getText());
        }).start();
    }
}
