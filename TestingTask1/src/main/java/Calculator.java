public class Calculator {
    public static void main(String[] args){
        Builder builder = new Builder();
        Validator validator = new Validator();
        UserQueryManipulator queryManipulator = new UserQueryManipulator(validator, builder);

        queryManipulator.action();
        queryManipulator.defineWantedOperation();
    }
}
