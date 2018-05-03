import java.util.ArrayList;

public class Validator {

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
