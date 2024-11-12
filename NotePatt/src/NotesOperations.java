
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class NotesOperations {
    private Connection con = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    
    public ArrayList<User> bringWorkers(){
        
        ArrayList<User> output = new ArrayList<User>();
        try {
            statement = con.createStatement();
            String query = "Select * From notes ";
            ResultSet rs = statement.executeQuery(query);
            
            while(rs.next()){
                int id = rs.getInt("id"); 
                String title = rs.getString("title");
                String note = rs.getString("note");
                String date = rs.getString("date");
                
                output.add(new User(id, title, note, date));
            }
            return output;
            
        } catch (SQLException ex) {
            Logger.getLogger(NotesOperations.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public void deleteNote(int id){
        String query = "Delete from notes where id = ?";
        
        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NotesOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            
       
    }
    public void updateNote(int id,String newTitle,String newNote,String newDate){
        
        String query = "Update notes set title = ? , note = ? , date = ? where id = ?";
        try {
            preparedStatement = con.prepareStatement(query);
            
            preparedStatement.setString(1,newTitle );
            preparedStatement.setString(2,newNote );
            preparedStatement.setString(3,newDate );
            
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NotesOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void addNote(String newTitle,String newNote,String newDate){
        
        String query = "Insert into notes(title,note,date) Values(?,?,?)";
            try {
                preparedStatement = con.prepareStatement(query);

                preparedStatement.setString(1, newTitle);
                preparedStatement.setString(2, newNote);
                preparedStatement.setString(3, newDate);

                preparedStatement.executeUpdate();
                System.out.println("Note added successfully!");
            } catch (SQLException ex) {
                Logger.getLogger(NotesOperations.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error adding note.");
            }
        
    }
public boolean login(String userName, String password) {
    if (con == null) {
        System.out.println("Bağlantı yok, login yapılamıyor.");
        return false;
    }
    
    String query = "Select * from admins WHERE Username = ? and Password = ?";
    
    try {
        preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, userName);
        preparedStatement.setString(2, password);
        
        ResultSet rs = preparedStatement.executeQuery();
        
        return rs.next();
    } catch (SQLException ex) {
        Logger.getLogger(NotesOperations.class.getName()).log(Level.SEVERE, null, ex);
        return false;
    }
}

    
  public NotesOperations() {
    String url = "jdbc:mysql://" + Database.host + ":" + Database.port + "/" + Database.db_name + "?useUnicode=true&characterEncoding=utf8";
    
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException ex) {
        System.out.println("Sürücü bulunamadı...");
        ex.printStackTrace();
    }

    try {
        con = DriverManager.getConnection(url, Database.userName, Database.Password);
        System.out.println("Connect is successfully");
    } catch (SQLException ex) {
        System.out.println("Connect is failed!!!");
        ex.printStackTrace();
    }
}

    
 
}
