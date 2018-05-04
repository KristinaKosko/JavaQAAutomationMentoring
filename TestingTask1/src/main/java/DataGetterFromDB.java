import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class DataGetterFromDB extends AbstractSource {
    private static final String url = "";
    private static final String user = "root";
    private static final String password = "root";
    private static Connection connection;

    private ArrayList<String> Data;

    public void setData(ArrayList<String> data) {
        Data = data;
    }

    ArrayList<String> getData() {
        return null;
    }

    public void readDB() throws SQLException {
        String query = "select firstOperand, operation, secondOperand from calculatorData";
        ArrayList<String> dataFromDB = new ArrayList<String>();
            Statement statement = connectToDB(url, user, password);
        ResultSet result;
        try {
            result = statement.executeQuery(query);

            if (result != null) {
                while (result.next()) {
                    // Data Base should contain 3 columns, where:
                    // first column - first operand
                    // second column - second operand
                    // third column - operation sign
                    String expression = result.getString(1) + result.getString(3) + result.getString(2);
                    dataFromDB.add(expression);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        setData(dataFromDB);
        connection.close();
    }

    private Statement connectToDB(String url, String user, String password) {
        try {
            connection = DriverManager.getConnection(url, user, password);
            return connection.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
