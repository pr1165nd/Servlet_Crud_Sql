package Employee;

import java.sql.*;

public class sqlcommands implements commands  {
    static String name;
    static String address;
    private static final String URL ="jdbc:mysql://localhost:3306/demo_db?useSSL=false";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";
    Statement st=null;
    {
        try {
            st = DriverManager.getConnection(URL,USER_NAME,PASSWORD).createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void listEmployee( ) throws SQLException {
        ResultSet rs=st.executeQuery("Select * from demo_tbl");
        System.out.println("Employee list:");
        while (rs.next()){
            System.out.println("Id is: "+rs.getInt("id"));
            System.out.println("Name is: "+rs.getString("name"));
            System.out.println("Address is: "+rs.getString("address"));
            System.out.println("=======================");
        }
    }


    @Override
    public Employee getEmployeebyid(int id) throws SQLException {
        ResultSet rs=st.executeQuery("Select * from demo_tbl where id="+id);

        while (rs.next()){
            id=rs.getInt("id");
            name=rs.getString("name");
            address=rs.getString("address");
        }
        Employee e=new Employee(id,name,address);
        return e;
    }
    @Override
    public void addEmployee(Employee e ) throws SQLException {
        st.executeUpdate("insert into demo_tbl(id,name,address)values("+e.getId()+",'"+e.getName()+"','"+e.getAddress()+"')");
    }

    @Override
    public void deleteEmployee(int id) throws SQLException {
        st.executeUpdate("delete from demo_tbl where id="+id);

    }

    @Override
    public void UpdateEmployee(int id, String name, String Address) throws SQLException {
        st.executeUpdate("update demo_tbl set name='"+name+"',address='"+Address+"' where id="+id);
    }

    @Override
    public void createDatabase(String SQL) throws SQLException {
        st.executeUpdate("create database "+SQL);
    }

    @Override
    public void createTable(String SQL) throws SQLException {
        st.executeUpdate("create table "+SQL+"(id int not null auto_increment, user_name varchar(50), age int, primary key(id))");
    }


}
