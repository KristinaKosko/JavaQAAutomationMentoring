public class Calculator {
    public static void main(String[] args){

        Builder builder = new Builder();
        Validator validator = new Validator();
        Utils utils = new Utils();

        UserQueryManipulator queryManipulator = new UserQueryManipulator(validator, builder, utils);

        while (true) {
            queryManipulator.action();
            queryManipulator.defineWantedOperation();
        }
    }
}
