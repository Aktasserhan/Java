
import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.util.ArrayList;



public class WorkerOperations {
    private Connection con = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    
    public ArrayList<Worker> bringWorkers(){
        
        ArrayList<Worker> output = new ArrayList<Worker>();
        try {
            statement = con.createStatement();
            String query = "Select * From calisanlar ";
            ResultSet rs = statement.executeQuery(query);
            
            while(rs.next()){
                int id = rs.getInt("id"); 
                String name = rs.getString("ad");
                String surname = rs.getString("soyad");
                String dept = rs.getString("departman");
                String salary = rs.getString("maas");
                
                output.add(new Worker(id, name, surname, dept, salary));
            }
            return output;
            
        } catch (SQLException ex) {
            Logger.getLogger(WorkerOperations.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public void deleteWorker(int id){
        String query = "Delete from calisanlar where id = ?";
        
        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(WorkerOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            
       
    }
    public void updateWorker(int id,String newName,String newSurname,String newDepartment,String newSalary){
        
        String query = "Update calisanlar set ad = ? , soyad = ? , departman = ? , maas = ? where id = ?";
        try {
            preparedStatement = con.prepareStatement(query);
            
            preparedStatement.setString(1,newName );
            preparedStatement.setString(2,newSurname );
            preparedStatement.setString(3,newDepartment );
            preparedStatement.setString(4,newSalary );
            
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(WorkerOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void addWorker(String name,String surname ,String department,String salary){
        
        String query = "Insert into calisanlar(ad,soyad,departman,maas) Values(?,?,?,?)";
        try {
            preparedStatement = con.prepareStatement(query);
            
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, department);
            preparedStatement.setString(4, salary);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(WorkerOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public boolean login(String userName, String password){
        String query ="Select * from adminler WHERE username = ? and password = ?";
        
        try {
            preparedStatement = con.prepareStatement(query);
            
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(WorkerOperations.class.getName()).log(Level.SEVERE, null, ex);
             return false; 
        }
       
        
    }
    public WorkerOperations(){
        
        String url = "jdbc:mysql://" + Database.host + ":" + Database.port + "/" + Database.db_name + "?useUnicode=true&characterEncoding=utf8";

        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Sürücü bulunamadı....");
        }
        try {
            con = DriverManager.getConnection(url, Database.userName, Database.Password);
            System.out.println("Connect is successfully");
        } catch (SQLException ex) {
            System.out.println("Connect is failed!!!");
        }
    }

}
