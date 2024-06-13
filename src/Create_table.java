

    import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create_table  {

    public static void main(String[] args) {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=questiondb2";
        String user = "Project";
        String pass = "123456";

        String[] tableNames = {"Question1", "Question2", "Question3", "Question4", "Question5", "Question6", "Question7", "Question8", "Question9", "Question10","Question11", "Question12", "Question13", "Question14", "Question15", "Question16", "Question17", "Question18", "Question19", "Question20"
        ,"Question21" ,"Question22" ,"Question23" ,"Question24" ,"Question25" ,"Question26"};

        String sqlTemplate = "CREATE TABLE %s (" +
                             "Question NVARCHAR(MAX) NOT NULL, " +
                             "Option1 NVARCHAR(50) NOT NULL, " +
                             "Option2 NVARCHAR(50) NOT NULL, " +
                             "Option3 NVARCHAR(50) NOT NULL, " +
                             "Option4 NVARCHAR(50) NOT NULL, " +
                             "Answer NVARCHAR(50) NOT NULL, " +
                             "OptionPos NVARCHAR(1) NOT NULL, " +
                             "TrainingUsed INT NOT NULL, " +
                             "ExamUsed INT NOT NULL" +
                             ");";

        try (Connection con = DriverManager.getConnection(url, user, pass);
             Statement stmt = con.createStatement()) {

            for (String tableName : tableNames) {
                String sql = String.format(sqlTemplate, tableName);
                stmt.executeUpdate(sql);
                System.out.println("Table " + tableName + " created successfully.");
            }

        } catch (SQLException e) {
            System.err.println("SQL error while creating table: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
