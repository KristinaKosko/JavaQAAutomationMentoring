public class MultiplyerOfMatrices {
    public double[][] multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix){
        int numberOfRowsInFirstMatrix = firstMatrix.length;
        int numberOfRowsInSecondMatrix = secondMatrix.length;
        int numberOfColumnsInSecondMatrix = secondMatrix[0].length;
        double resultMatrix[][] = new double[numberOfRowsInFirstMatrix][numberOfColumnsInSecondMatrix];

        for (int i = 0; i < numberOfRowsInFirstMatrix; i++){
            for (int j = 0; j < numberOfColumnsInSecondMatrix; j++){
                for (int k = 0; k  <numberOfRowsInSecondMatrix; k++){
                    resultMatrix[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
            }
        }
        return resultMatrix;
    }

    public void printResultMatrix(double[][] result){
        System.out.println("Результат перемножения Ваших матриц:");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.format("%4f.2 ", result[i][j]);
            }
            System.out.println();
        }
    }
}
