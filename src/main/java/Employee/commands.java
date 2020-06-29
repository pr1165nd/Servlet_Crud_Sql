package Employee;

import java.sql.SQLException;

public interface commands {
    void listEmployee( ) throws SQLException;
    void addEmployee(Employee e ) throws SQLException;
    void deleteEmployee(int id) throws SQLException;
    void UpdateEmployee(int id,String name,String Address)throws SQLException;
    void createDatabase(String Db_name)throws SQLException;
    void createTable(String tbl_name) throws SQLException;
    Employee getEmployeebyid(int id) throws SQLException;
}
