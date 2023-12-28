import java.util.Arrays;
public class CodeReuse {
        //1st method//
    public void sortDescending(int[] array) {
            int n = array.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (array[j] < array[j + 1]) {
                        int var = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = var;
                    }
                }
            }
        }
        //2nd method//

    public double[] calculateStatistics(int[] data) {
        if (data.length == 0) {
            return new double[]{0, 0, 0, 0};
        }
        double median;
        Arrays.sort(data);
        if (data.length % 2 == 0) {
            median = ((double) data[data.length / 2] + (double) data[data.length / 2 - 1]) / 2;
        } else {
            median = (double) data[data.length / 2];
        }
        double mean = Arrays.stream(data).average().orElse(Double.NaN);
        double sumOfSquares = 0;
        for (int num : data) {
            sumOfSquares += Math.pow(num - mean, 2);
        }
        double variance = sumOfSquares / data.length;
        double stdDev = Math.sqrt(variance);

        return new double[]{median, variance, stdDev, sumOfSquares};
    }
  
            
    //3rd method//
    public int[][] matrixMultiplication(int[][] matrixA, int[][] matrixB, int rowsA, int columnsA, int columnsB) {
        if (columnsA != matrixB.length) {
            throw new IllegalArgumentException("Invalid matrix dimensions ");
        }

        int[][] result = new int[rowsA][columnsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < columnsB; j++) {
                int sum = 0;
                for (int k = 0; k < columnsA; k++) {
                    sum += matrixA[i][k] * matrixB[k][j];
                }
                result[i][j] = sum;
            }
        }

        return result;
    }
}