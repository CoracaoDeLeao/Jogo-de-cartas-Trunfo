/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package GUI;

import cartaTrunfo.Player;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author THE KING
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label ganhador;
    @FXML
    private Label VS;
    @FXML
    private Label rodadas;
    @FXML
    private Label scoreP1;
    @FXML
    private Label scoreP2;
    @FXML
    private Label empate;
    @FXML
    private Button btnForca;
    @FXML
    private Button btnResistencia;
    @FXML
    private Button btnIntel;
    @FXML
    private Button btnProxFase;
    @FXML
    private Button btnFadiga;
    @FXML
    private Button btnJogarDNV;
    @FXML
    private Button cartaP2;
    @FXML
    private Button cartaP1;
    @FXML
    private BorderPane panelInteiro;
    @FXML
    private FlowPane panelIniciar;

    private Player p1 = new Player();
    private Player p2 = new Player();

    private int i = 1;
    private final int MAX_CARTAS = 6;

    private void startUP() {
        btnJogarDNV.setVisible(false);
        btnProxFase.setVisible(false);
        ganhador.setVisible(false);

        empate.setVisible(false);
        panelInteiro.setVisible(false);

        cartaP1.setText(p1.monteCarta[i].exibirCarta());
    }

    private void update() {

        scoreP1.setText("P1:" + p1.score);
        scoreP2.setText("P2:" + p2.score);

        if (i == 6) {
            rodadas.setText(i - 1 + "/5");
        } else {
            rodadas.setText(i + "/5");
        }

        if (i == MAX_CARTAS) {

            bloqueioBTN();

            ganhador.setVisible(true);
            btnProxFase.setVisible(false);

            if (p1.score > p2.score) {
                ganhador.setText("P1 Venceu!");
            } else if (p1.score < p2.score) {
                ganhador.setText("P2 Venceu!");
            } else {
                ganhador.setText("Empate!");
            }
            btnJogarDNV.setVisible(true);
        }
    }

    private void validacao() {
        if (i < 5) {
            btnProxFase.setVisible(true);
            cartaP2.setFont(Font.font("System", FontWeight.BOLD, 18));
            cartaP2.setText(p2.monteCarta[i].exibirCarta());
        } else {
            i++;
            btnProxFase.setVisible(false);
            cartaP2.setFont(Font.font("System", FontWeight.BOLD, 18));
            cartaP2.setText(p2.monteCarta[i].exibirCarta());
            update();
        }
    }

    private void bloqueioBTN() {
        btnForca.setDisable(true);
        btnResistencia.setDisable(true);
        btnIntel.setDisable(true);
        btnFadiga.setDisable(true);
    }

    private void desbloqueio() {
        btnForca.setDisable(false);
        btnResistencia.setDisable(false);
        btnIntel.setDisable(false);
        btnFadiga.setDisable(false);
    }

    private void reset() {
        empate.setVisible(false);
        btnJogarDNV.setVisible(false);
        cartaP1.setText(p1.monteCarta[i].exibirCarta());
        cartaP2.setFont(Font.font("System", FontWeight.BOLD, 110));
        cartaP2.setText("?");
        ganhador.setVisible(false);
    }

    @FXML
    private void proximaFase(ActionEvent event) {
        i++;
        cartaP2.setFont(Font.font("System", FontWeight.BOLD, 110));
        cartaP2.setText("?");
        cartaP1.setText(p1.monteCarta[i].exibirCarta());
        btnProxFase.setVisible(false);
        desbloqueio();
        update();
    }

    @FXML
    private void jogarDNV(ActionEvent event) {
        p1 = new Player();
        p2 = new Player();
        i = 1;
        reset();
        desbloqueio();
        update();
    }

    @FXML
    private void iniciarJogo(ActionEvent event) {
        panelInteiro.setVisible(true);
        panelIniciar.setVisible(false);
    }

    @FXML
    private void botaoForca(ActionEvent event) {
        empate.setVisible(false);
        if (p1.monteCarta[i].forca > p2.monteCarta[i].forca) {
            p1.score++;
        } else if (p2.monteCarta[i].forca > p1.monteCarta[i].forca) {
            p2.score++;
        } else {
            empate.setVisible(true);
        }
        bloqueioBTN();
        validacao();
        update();
    }

    @FXML
    private void botaoResistencia(ActionEvent event) {
        empate.setVisible(false);
        if (p1.monteCarta[i].resistencia > p2.monteCarta[i].resistencia) {
            p1.score++;
        } else if (p2.monteCarta[i].resistencia > p1.monteCarta[i].resistencia) {
            p2.score++;
        } else {
            empate.setVisible(true);
        }
        bloqueioBTN();
        validacao();
        update();
    }

    @FXML
    private void botaoFadiga(ActionEvent event) {
        empate.setVisible(false);
        if (p1.monteCarta[i].fadiga > p2.monteCarta[i].fadiga) {
            p1.score++;
        } else if (p2.monteCarta[i].fadiga > p1.monteCarta[i].fadiga) {
            p2.score++;
        } else {
            empate.setVisible(true);
        }
        bloqueioBTN();
        validacao();
        update();
    }

    @FXML
    private void botaoIntel(ActionEvent event) {
        empate.setVisible(false);
        if (p1.monteCarta[i].inteligencia > p2.monteCarta[i].inteligencia) {
            p1.score++;
        } else if (p2.monteCarta[i].inteligencia > p1.monteCarta[i].inteligencia) {
            p2.score++;
        } else {
            empate.setVisible(true);
        }
        bloqueioBTN();
        validacao();
        update();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        startUP();
        update();
    }
}
