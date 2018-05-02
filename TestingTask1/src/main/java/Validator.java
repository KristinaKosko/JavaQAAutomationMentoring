import java.util.ArrayList;

public class Validator {


    //public boolean validateUserQuery(String userQuery, UserQueryManipulator queryManipulator) {
       // if (!validateExit(userQuery)) System.exit(0);
        //try {
       //     queryManipulator.setEnteredByUserNumbers(queryManipulator.splitInputOnNumbers(userQuery));
       // } catch (NoSuchOperationException e) {
       //     System.out.print(e.getMessage());
       //     System.out.println(e.getInput());
       //     return false;
       // }
      //  return false;
  //  }

    public void validateDivision (ArrayList<Double> numbers)throws DivideByZeroException{
        if (numbers.get(1) == 0){
            throw new DivideByZeroException("Division by zero is prohibited!") ;
        }
    }

    public boolean validateExit(String userQuery){
        if (userQuery.toLowerCase().equals("y")){
            return false;
        }
        return true;
    }
}
