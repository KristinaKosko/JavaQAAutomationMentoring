public class Validator {


    public boolean validateUserQuery(String userQuery, UserQueryManipulator queryManipulator) {
        String[] subStrings;
        boolean check = false;
        try {
            subStrings = queryManipulator.splitInputOnNumbers(userQuery);
        } catch (NoSuchOperationException e) {
            System.out.print(e.getMessage());
            System.out.println(e.getOperator());
            return false;
        }
        try {
            if (subStrings != null) {
                for (String item : subStrings) {
                    try{
                        Double.parseDouble(item);
                        check = true;
                    }
                    catch (NumberFormatException e){
                        check = false;
                    }
                }
                return check;
            }
        } catch (NumberFormatException ex) {
            return false;
        }
        return false;
    }

    public void validateDivision (double[] numbers)throws DivideByZeroException{
        if (numbers[1] == 0){
            throw new DivideByZeroException("Division by zero is prohibited!") ;
        }
    }
}
