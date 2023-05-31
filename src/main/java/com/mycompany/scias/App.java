package com.mycompany.scias;

import com.mycompany.scias.model.User;
import com.mycompany.scias.presenter.DBPersister;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.stage.StageStyle;

/**
 * JavaFX App
 */
//This is the main app where program starts from here. 
public class App extends Application {

    private static Scene scene;
    private static User user;

    @Override
    public void start(Stage stage) throws IOException {
       scene = new Scene(loadFXML("/fxml/login"), 640, 480);
        stage.setScene(scene);
        stage.setTitle("SCIAS Login");
        stage.initStyle(StageStyle.UTILITY);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    //get user
    public static User getUser() {
        return App.user;
    }
    
    //set user
    public static void setUser(User user) {
        App.user = user;
    }

    public static void main(String[] args) {
        DBPersister db = new DBPersister();
        db.createDatabase();
        db.createTables();
        db.addRole();
        db.addUser();
        launch();
    }

}
