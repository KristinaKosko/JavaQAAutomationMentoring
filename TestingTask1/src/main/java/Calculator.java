public class Calculator {
    public static void main(String[] args){

        Builder builder = new Builder();
        Validator validator = new Validator();
        Utils utils = new Utils();
        DataReadersBuilder dataReadersBuilder = new DataReadersBuilder();

        UserQueryManipulator queryManipulator = new UserQueryManipulator(validator, builder, utils, dataReadersBuilder);

        while (true) {
            queryManipulator.action();
            queryManipulator.defineWantedOperation();
        }
    }
}
