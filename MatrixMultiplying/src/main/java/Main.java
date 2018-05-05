import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MatrixGetter getterOfMatrix = new MatrixGetter();
        MultiplyerOfMatrices multiplier = new MultiplyerOfMatrices();
        int[] sizeOfFirstMatrix = new int[2];
        int[] sizeOfSecondMatrix = new int[2];

        Scanner in = new Scanner(System.in);
        sizeOfFirstMatrix = getterOfMatrix.getSizeOfMatrix(in);
        double[][] firstMatrix = new double[sizeOfFirstMatrix[0]][sizeOfFirstMatrix[1]];
        firstMatrix = getterOfMatrix.getMatrix(firstMatrix, in);

        sizeOfSecondMatrix = getterOfMatrix.getSizeOfMatrix(in);
        double[][] secondMatrix = new double[sizeOfSecondMatrix[0]][sizeOfSecondMatrix[1]];
        secondMatrix = getterOfMatrix.getMatrix(secondMatrix, in);

        double[][] result = multiplier.multiplyMatrices(firstMatrix, secondMatrix);
        multiplier.printResultMatrix(result);

        in.close();
    }
}
