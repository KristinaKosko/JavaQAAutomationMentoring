import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import java.io.FileReader;
import java.util.ArrayList;

public class JsonParser extends AbstractSource{

    private ArrayList<String> Data;

    @Override
    public ArrayList<String> getData() {
        return Data;
    }

    public void setData(ArrayList<String> data) {
        Data = data;
    }

    public void parseJsonFile(String pathToFile) {
        JSONParser jsonParser = new JSONParser();
        ArrayList<String> listOfExpressions = new ArrayList<String>();

        try {
            JSONArray arrayOfData = (JSONArray) jsonParser.parse(new FileReader(pathToFile));
            for (Object o : arrayOfData) {
                listOfExpressions.add ((String) ((JSONObject) o).get("firstOperand") + ((JSONObject) o).get("operation") + ((JSONObject) o).get("secondOperand"));
                setData(listOfExpressions);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
