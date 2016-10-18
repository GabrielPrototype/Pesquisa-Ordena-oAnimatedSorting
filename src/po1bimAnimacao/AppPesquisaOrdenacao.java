/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package po1bimAnimacao;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author titan
 */
public class AppPesquisaOrdenacao extends Application {
    Button botaoIniciar, botao;
    
    public static void main(String[] args){
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        
        stage.setTitle("Pesquisa e Ordenacao");
        AnchorPane pane = new AnchorPane();
        botaoIniciar = new Button();
        botaoIniciar.setLayoutX(10); botaoIniciar.setLayoutY(100);
        botaoIniciar.setText("Inicia...");
        
        botaoIniciar.setOnAction( 
                
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    animacao();
                }
            }
        );
        
        botao = new Button();
        botao.setLayoutX(30); botao.setLayoutY(30);
        botao.setText("0");
        pane.getChildren().addAll(botaoIniciar, botao);
        Scene scene = new Scene(pane, 640, 480);
        stage.setScene(scene);
        stage.show();
    }
    
    public void animacao() {
        
        Task task = new Task<Void>() {
            
            @Override
            public Void call() throws Exception {
                
                for (int i = 1; i < 200; i++) {
                    
                    final int finalI = i;
                    Platform.runLater(() -> botao.setText("" + finalI));
                    Platform.runLater(() -> botao.setLayoutX(30 + finalI * 4));
                    Thread.sleep(100);
                }
                return null;
            }
        };
        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();
    }
}