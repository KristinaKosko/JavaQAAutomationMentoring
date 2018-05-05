import java.util.InputMismatchException;
import java.util.Scanner;

public class MatrixGetter {
    public double[][] getMatrix(double[][] matrixForInput, Scanner in) {
        for (int i = 0; i < matrixForInput.length; i++) {
            for (int j = 0; j < matrixForInput[i].length; j++) {
                System.out.print("Введите элемент матрицы [" + i + "][" + j + "]: ");
                if (in.hasNext()) {
                    String element = in.next();
                    if (validateMatrixElement(element)) {
                        matrixForInput[i][j] = Double.parseDouble(element);
                    } else {
                        if (i != 0 & j != 0) {
                            i--;
                            j--;
                        }
                        getMatrix(matrixForInput, in);
                    }
                }
            }
        }
        return matrixForInput;
    }

    public int[] getSizeOfMatrix(Scanner in) {
        System.out.print("Введите количество строк матрицы: ");
        int[] size = new int[2];
        try {
            if (in.hasNextInt()) {
                size[0] = in.nextInt();
            }
            System.out.print("Введите количество столбцов матрицы: ");
            if (in.hasNextInt()) {
                size[1] = in.nextInt();
            }
            return size;
        } catch (InputMismatchException ex) {
            System.out.println("Введите целое число!");
            getSizeOfMatrix(in);
        }
        return null;
    }


    public boolean validateMatrixElement(String element){
        try {
            Double.parseDouble(element);
            return true;
        }
        catch (NumberFormatException ex){
            return false;
        }

    }
}
