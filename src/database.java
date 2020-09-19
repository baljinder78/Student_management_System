import  java.sql.*;
public class database {
    public static void main(String[] args) {
        try{
            Class.forName("java.sql.DriverManager");
            //Class.forName("com.mysql.cj.jdbc.Driver");


            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","baljinder");

            Statement stmt=con.createStatement();
            PreparedStatement sm=con.prepareStatement("Update trying set name=? where id=?");
            System.out.println("pass1");
            sm.setString(1,"Killer");
            System.out.println("pass2");
            sm.setInt(2,1005);
            System.out.println("pass3");
            sm.executeUpdate();
            System.out.println("pass4");
            ResultSet rs=stmt.executeQuery("select * from trying");
rs.next();
                System.out.println(rs.getString(1)+" "+rs.getInt(2));

            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
}
