import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connecter {
    private String userName = "root";
    private String Password = "";
    private String db_name = "demo";
    private String host = "localhost";
    private int port = 3306;
    private Connection con = null;

    private Statement statement = null;
    private PreparedStatement preparedStatement = null;

    public Connecter() {
        String url = "jdbc:mysql://" + host + ":" + port + "/" + db_name + "?useUnicode=true&characterEncoding=utf8";

        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Sürücü bulunamadı....");
        }
        try {
            con = DriverManager.getConnection(url, userName, Password);
            System.out.println("Connect is successfully");
        } catch (SQLException ex) {
            System.out.println("Connect is failed!!!");
        }
    }

    public void deleteWorker() {
        try {
            statement = con.createStatement();
            String query = "Delete from workers where id = '3'";
            int value = statement.executeUpdate(query);
            System.out.println(value + " datas affected....");
        } catch (SQLException ex) {
            Logger.getLogger(Connecter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateWorker() {
        try {
            statement = con.createStatement();
            String query = "Update workers Set name = 'Walter', surname = 'White' where id = 9";
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Connecter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getpreparedWorkers(int id) {
        String query = "Select * From workers where id > ? and name like ?";

        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2,"M%");

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int Id = rs.getInt("id");
                String Name = rs.getString("name");
                String Surname = rs.getString("surname");
                String EMail = rs.getString("email");

                System.out.println("Id : " + Id + "   Name: " + Name + "   Surname: " + Surname + "   EMail: " + EMail);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connecter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void commitandrollback(){
        Scanner ss = new Scanner(System.in);
        try {
            con.setAutoCommit(false);
            
            String query1 = "Delete from workers where id = 10";
            String query2 = "Update workers set email  = 'exampleisdone@gmail.com' where id = 11";
            
            System.out.println("Before Updating");
            bringWorkers();
            Statement statement = con.createStatement();
            
            statement.executeUpdate(query1);
            statement.executeUpdate(query2);
            
            System.out.print("Is your procces saved? (yes or no) : ");
            String answer = ss.nextLine(); 
            
            if(answer.equals("yes")){
                con.commit();
                bringWorkers();
                System.out.println("Database is updated...");
            }else{
                con.rollback();
                System.out.println("Update proccess of database is canceled!!!!!!");
                bringWorkers();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Connecter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void bringWorkers() {
        String query = "Select * From workers";
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                int Id = rs.getInt("id");
                String Name = rs.getString("name");
                String Surname = rs.getString("surname");
                String EMail = rs.getString("email");

                System.out.println("Id : " + Id + "   Name: " + Name + "   Surname: " + Surname + "   EMail: " + EMail);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Connecter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        Connecter connect = new Connecter();
        //System.out.println("Before Bring worker...");
        //connect.getpreparedWorkers(7);
        //System.out.println("*********************************");
        //System.out.println("After Bring worker...");
        //connect.bringWorkers();
        
        connect.commitandrollback();
        
    }
}
