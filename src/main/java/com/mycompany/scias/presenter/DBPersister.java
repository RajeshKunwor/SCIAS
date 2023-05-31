/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.scias.presenter;

import com.mycompany.scias.App;
import com.mycompany.scias.model.Role;
import com.mycompany.scias.model.SCI;
import com.mycompany.scias.model.SoftwareComponent;
import com.mycompany.scias.model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author rajes
 */
//this is database utility class
public class DBPersister {

    private final String MYSQL_URL;
    private final String DB_URL;
    private final String USERNAME;
    private final String PASSWORD;

    private Connection sqlConnection;
    private Connection dbConnection;
    private PreparedStatement createDB;
    private PreparedStatement createTableUser;
    private PreparedStatement createTableRole;
    private PreparedStatement createTableSoftwareComponent;
    private PreparedStatement createTableSCI;

    private PreparedStatement insertUser;
    private PreparedStatement insertSoftware;
    private PreparedStatement insertSoftwareComponent;
    private PreparedStatement insertSCI;
    private PreparedStatement insertRole;

    private PreparedStatement getAllUser;
    private PreparedStatement getAllSoftwareComponent;
    private PreparedStatement getAllSCI;
    private PreparedStatement getAllRole;

    private PreparedStatement selectUserFromId;
    private PreparedStatement selectRolefromId;
    private PreparedStatement getSoftwareComponentFromSoftwareId;
    private PreparedStatement selectSoftwaareComponentFromId;
    private PreparedStatement selectSCIFromId;

    private PreparedStatement getRoleId;
    private PreparedStatement selectUser;
    private PreparedStatement selectRole;

    public DBPersister() {
        MYSQL_URL = "jdbc:mysql://localhost:3306";
        DB_URL = MYSQL_URL + "/scias";
        USERNAME = "root";
        PASSWORD = "Rjhkwr@2053";

    }

    //create database as SCIAS
    public void createDatabase() {

        try {
            //Connects to the SQL instance
            sqlConnection = DriverManager.getConnection(MYSQL_URL, USERNAME, PASSWORD);
            //Creates the database if not exists
            createDB = sqlConnection.prepareStatement("create database if not exists scias");
            createDB.executeUpdate();
            if (sqlConnection != null) {
                sqlConnection.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBPersister.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //create tables
    public void createTables() {
        try {
            //Connects to database
            dbConnection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            //create role
            String roleQuery = "CREATE TABLE  IF NOT EXISTS Role "
                    + "(id INT not NULL AUTO_INCREMENT,"
                    + " type VARCHAR(255) not NULL UNIQUE, "
                    + " PRIMARY KEY ( id ))";
            createTableRole = dbConnection.prepareStatement(roleQuery);
            createTableRole.executeUpdate();

            //create user
            String userQuery = "CREATE TABLE IF NOT EXISTS User"
                    + "(id int NOT NULL AUTO_INCREMENT,"
                    + "fullname VARCHAR(255) NOT NULL,"
                    + " username VARCHAR (255) NOT NULL UNIQUE,"
                    + "email VARCHAR(255) NOT NULL,"
                    + "phonenumber long NOT NULL,"
                    + " password VARCHAR(255) NOT NULL,"
                    + "role int,"
                    + "PRIMARY KEY (id),"
                    + "FOREIGN KEY (role) REFERENCES Role(id) ON DELETE CASCADE ON UPDATE CASCADE)";
            createTableUser = dbConnection.prepareStatement(userQuery);
            createTableUser.executeUpdate(userQuery);

            //create softwareComponent table
            String softwareComponentQuery = "CREATE TABLE  IF NOT EXISTS SoftwareComponent "
                    + "(id INT not NULL AUTO_INCREMENT,"
                    + " component VARCHAR(255) not NULL UNIQUE,"
                    + " PRIMARY KEY ( id ))";
            createTableSoftwareComponent = dbConnection.prepareStatement(softwareComponentQuery);
            createTableSoftwareComponent.executeUpdate();

            //create SCI table
            String SCIQuery = "CREATE TABLE  IF NOT EXISTS SCI "
                    + "(id INT not NULL AUTO_INCREMENT,"
                    + " e float NOT NULL,"
                    + "m float NOT NULL,"
                    + "i float NOT NULL,"
                    + "r VARCHAR(255),"
                    + " softwareComponent int UNIQUE,"
                    + " PRIMARY KEY ( id ),"
                    + "FOREIGN KEY (softwareComponent) REFERENCES SoftwareComponent(id) ON DELETE CASCADE ON UPDATE CASCADE)";
            createTableSCI = dbConnection.prepareStatement(SCIQuery);
            createTableSCI.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DBPersister.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //insert initial role data
    public void addRole() {
        try {
            //insert role data
            List<Role> role = new ArrayList<>();
            role.add(new Role("Admin"));
            role.add(new Role("Staff"));
            role.add(new Role("Manager"));
            String query = "insert ignore into role(type) values(?)";
            dbConnection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            insertRole = dbConnection.prepareStatement(query);
            for (Role r : role) {
                insertRole.setString(1, r.getType());
                insertRole.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBPersister.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //insert admin user data
    public void addUser() {
        try {
            //insert user data
            Role admin = new Role(1, "Admin");
            User user = new User("Amin", "admin", "admin@gmail.com", 04522030, "admin", admin);
            String query = "insert ignore into User(fullname, username, email, phoneNumber, password, role) values(?,?,?,?,?,?)";
            dbConnection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            insertUser = dbConnection.prepareStatement(query);
            insertUser.setString(1, user.getFullName());
            insertUser.setString(2, user.getUserName());
            insertUser.setString(3, user.getEmail());
            insertUser.setLong(4, user.getPhoneNumber());
            insertUser.setString(5, user.getPassword());
            insertUser.setInt(6, user.getRole().getId());

            insertUser.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBPersister.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //check user
    public boolean checkUser(User user) {
        try {
            dbConnection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            PreparedStatement checkUser = dbConnection.prepareStatement("select username from user where username = ? ");
            checkUser.setString(1, user.getUserName());
            ResultSet result = checkUser.executeQuery();
            if (result.next()) {
                System.out.println("Already registered.");
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBPersister.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    //insert user data
    public boolean addUser(User user) {
        try {
            //insert user data 
            dbConnection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String query = "insert into User(fullname, username, email, phoneNumber, password, role) values(?,?,?,?,?,?)";
            insertUser = dbConnection.prepareStatement(query);
            insertUser.setString(1, user.getFullName());
            insertUser.setString(2, user.getUserName());
            insertUser.setString(3, user.getEmail());
            insertUser.setLong(4, user.getPhoneNumber());
            insertUser.setString(5, user.getPassword());
            insertUser.setInt(6, user.getRole().getId());

            insertUser.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBPersister.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    //insert software components data
    public boolean addSoftwareComponent(SoftwareComponent sc) {
        try {
            String query = "insert into softwarecomponent(component) values(?)";
            dbConnection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            insertSoftwareComponent = dbConnection.prepareStatement(query);
            insertSoftwareComponent.setString(1, sc.getComponent());
            insertSoftwareComponent.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBPersister.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    //get software components
    public ArrayList<String> getSoftwareComponents() {
        ArrayList<String> components = new ArrayList<>();
        try {
            String query = "select component from softwarecomponent ";
            dbConnection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            PreparedStatement ptr = dbConnection.prepareStatement(query);
            ResultSet result = ptr.executeQuery();
            while (result.next()) {
                components.add(result.getString(1));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBPersister.class.getName()).log(Level.SEVERE, null, ex);
        }
        return components;
    }
    
    //check software component
    public boolean checkSoftwaresComponent(SoftwareComponent component) {
        try {
            dbConnection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            PreparedStatement checkComponent = dbConnection.prepareStatement("select component from softwarecomponent where component = ? ");
            checkComponent.setString(1, component.getComponent());
            ResultSet result = checkComponent.executeQuery();
            if (result.next()) {
                System.out.println("Already added.");
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBPersister.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    //check software component id
    public boolean checkSoftwaresComponentID(SoftwareComponent component) {
        try {
            int id = getSoftwareComponentIdByComponent(component.getComponent());
            dbConnection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            PreparedStatement checkComponent = dbConnection.prepareStatement("select softwareComponent from sci where softwareComponent = ? ");
            checkComponent.setInt(1, id);
            ResultSet result = checkComponent.executeQuery();
            if (result.next()) {
                System.out.println("Already added.");
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBPersister.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    //get software componet id 
    public int getSoftwareComponentIdByComponent(String component) {
        int id = 0;
        try {
            String query = "select id from softwarecomponent where component = ? ";
            dbConnection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            PreparedStatement ptr = dbConnection.prepareStatement(query);
            ptr.setString(1, component);
            ResultSet result = ptr.executeQuery();
            if (result.next()) {
                id = result.getInt(1);
            }
            return id;
        } catch (SQLException ex) {
            Logger.getLogger(DBPersister.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    //insert SCI data
    public boolean addSCI(SCI sci) {
        try {
            String query = "insert into sci(e,m,i,r, softwareComponent) values(?,?,?,?,?)";
            dbConnection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            insertSCI = dbConnection.prepareStatement(query);
            insertSCI.setFloat(1, sci.getE());
            insertSCI.setFloat(2, sci.getM());
            insertSCI.setFloat(3, sci.getI());
            insertSCI.setString(4, sci.getR());
            insertSCI.setInt(5, sci.getComponent().getId());
            insertSCI.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(DBPersister.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    //check user credentials
    public boolean login(User user) {
        try {
            String query = "select role, username, password from user where username=? and password=?";
            dbConnection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            PreparedStatement stmt = dbConnection.prepareStatement(query);
            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getPassword());
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                user.setRole(new Role(result.getInt(1)));
                App.setUser(user);
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBPersister.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    //get all users
    public ObservableList getAllUsers() {
        ObservableList<User> userList = FXCollections.observableArrayList();
        try {
            String query = "select *from user where role != ?";
            dbConnection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            getAllUser = dbConnection.prepareStatement(query);
            getAllUser.setInt(1, 1);
            ResultSet result = getAllUser.executeQuery();
            while (result.next()) {
                User user = new User();
                user.setFullName(result.getString("fullname"));
                user.setEmail(result.getString("email"));
                user.setPhoneNumber(result.getLong("phonenumber"));
                user.setPassword(result.getString("password"));
                user.setUserName(result.getString("username"));
                userList.add(user);

            }
            return userList;
        } catch (SQLException ex) {
            Logger.getLogger(DBPersister.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userList;
    }

    //get all softwareComponent based on software
    public ObservableList getSoftwareComponentById(int id) {
        ObservableList<SoftwareComponent> softwareComponentList = FXCollections.observableArrayList();
        try {
            String query = "select *from softwarecomponent where softwarecomponent = ?";
            dbConnection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            getSoftwareComponentFromSoftwareId = dbConnection.prepareStatement(query);
            getSoftwareComponentFromSoftwareId.setInt(1, id);
            ResultSet result = getSoftwareComponentFromSoftwareId.executeQuery();
            while (result.next()) {
                SoftwareComponent sc = new SoftwareComponent();
                sc.setComponent(result.getString("component"));
                softwareComponentList.add(sc);
            }
            return softwareComponentList;
        } catch (SQLException ex) {
            Logger.getLogger(DBPersister.class.getName()).log(Level.SEVERE, null, ex);
        }
        return softwareComponentList;
    }

    //get all softwareComponents
    public ObservableList getAllSoftwareComponents() {
        ObservableList<SoftwareComponent> softwareComponentList = FXCollections.observableArrayList();
        try {
            String query = "select *from softwarecomponent";
            dbConnection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            getAllSoftwareComponent = dbConnection.prepareStatement(query);
            ResultSet result = getAllSoftwareComponent.executeQuery();
            while (result.next()) {
                SoftwareComponent sc = new SoftwareComponent(result.getInt("id"), result.getString("component"));
                sc.setComponent(result.getString("component"));
                softwareComponentList.add(sc);
            }
            return softwareComponentList;
        } catch (SQLException ex) {
            Logger.getLogger(DBPersister.class.getName()).log(Level.SEVERE, null, ex);
        }
        return softwareComponentList;
    }

    //get all sci data
    public ObservableList getAllSCI() {
        ObservableList<SCI> sciList = FXCollections.observableArrayList();
        float totalSCIScore = 0;
        try {
            String query = "select e,i,m,r,component from sci inner join softwarecomponent on sci.softwareComponent = softwarecomponent.id";
            dbConnection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            getAllSCI = dbConnection.prepareStatement(query);
            ResultSet result = getAllSCI.executeQuery();
            while (result.next()) {
                SCI sci = new SCI();
                sci.setE(result.getFloat("e"));
                sci.setI(result.getFloat("i"));
                sci.setM(result.getFloat("m"));
                sci.setR(result.getString("r"));
                float total = (sci.getE() * sci.getI()) + sci.getM();
                totalSCIScore = totalSCIScore + total;
                sci.setComponent(new SoftwareComponent(result.getString("component")));
                sci.calculateSCI();
                sciList.add(sci);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBPersister.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sciList;
    }

    //setTotalSCIScore
    public float getTotalSCIScore() {
        float totalSCIScore = 0;
        try {
            String query = "select e,i,m from sci";
            dbConnection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            getAllSCI = dbConnection.prepareStatement(query);
            ResultSet result = getAllSCI.executeQuery();
            while (result.next()) {
                float total = (result.getFloat("e") * result.getFloat("i")) + result.getFloat("m");
                totalSCIScore = totalSCIScore + total;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBPersister.class.getName()).log(Level.SEVERE, null, ex);
        }
        return totalSCIScore;
    }

}
