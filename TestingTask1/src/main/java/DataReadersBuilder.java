public class DataReadersBuilder {
    private DataGetterFromDB DataGetterFromDB = new DataGetterFromDB();
    public DataGetterFromDB getDataGetterFromDB() {
        return DataGetterFromDB;
    }

    private JsonParser JsonParser = new JsonParser();
    public JsonParser getJsonParser() {
        return JsonParser;
    }
}
