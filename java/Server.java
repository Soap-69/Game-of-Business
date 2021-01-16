
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mingz
 */
public class Server extends Application{
  @Override
    public void start(Stage primaryStage) {
        //Text area for displaying contents
        TextArea ta = new TextArea();

        //Create a scene and place it in the stage
        Scene scene = new Scene(new ScrollPane(ta), 450, 200);
        primaryStage.setTitle("Server"); // Set the stage title
        primaryStage.setScene(scene);
        primaryStage.show();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Create a server socket
                    ServerSocket serverSocket=new ServerSocket(8000);
                    Platform.runLater(()-> 
                     ta.appendText("Server started at " + new Date() + '\n'));
                    //Listen for a connection request
                    Socket socket = serverSocket.accept();
                    
                    //Create data input and output streams
                    DataInputStream inputFormClient = new DataInputStream(
                    socket.getInputStream());
                    DataOutputStream outputToClient = new DataOutputStream(
                    socket.getOutputStream());
                    
                    while(true) {
                        
                        Platform.runLater(()->{
                        ta.appendText("Received message from client: ");
                        });
                    }
                }
                catch(IOException ex){
                    ex.printStackTrace();
                }
            }
        }).start();                     
    }
}
