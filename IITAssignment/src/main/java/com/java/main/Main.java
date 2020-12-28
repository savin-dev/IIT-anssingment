package com.java.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import com.java.ui.controller.GymManager;
import com.java.ui.controller.impl.MyGymManager;

import java.util.Scanner;

public class Main extends Application {

    Scanner scanner;
    GymManager manager;

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainApp();
    }

    public void mainApp() throws Exception{
        scanner=new Scanner(System.in);
        manager=new MyGymManager(scanner);

        System.out.println("Welcome to MyGym");
        System.out.println("================\n");

        while (true){
            System.out.println("Select option from menu");
            System.out.println("\t1.List Members");
            System.out.println("\t2.Add Member");
            System.out.println("\t3.Remove Members");
            System.out.println("\t4.List Members in GUI");
            System.out.println("\t5.Save members");
            System.out.println("\t6.Sort members");
            System.out.println("\n\t10.Exit\n");

            System.out.print("Option\t: ");

            int option=0;
            try {
                option= scanner.nextInt();
            }catch (Exception e){
                System.out.println("Invalid input please retry\n");
            }
            switch (option){
                case 1: {
                    manager.listMembers();
                    break;
                }
                case 2: {
                    manager.registerMember();
                    break;
                }
                case 3: {
                    manager.removeMember();
                    break;
                }
                case 4: {
                    Stage st = new Stage();
                    st.setTitle("Gym Manager");
                    AnchorPane root = FXMLLoader.load(getClass().getResource("/fxml/Screen.fxml"));
                    st.setScene(new Scene(root));
                    st.showAndWait();
                }
                case 5: {
                    manager.save();
                    break;
                }
                case 6:{
                    manager.sortMembersByName();
                    break;
                }
                default:
                    continue;
            }

            if (option==10)
                System.exit(0);
        }
    }

}
