package assignment2;

import java.util.Scanner;

/**
 * @Class MatrixMain User interface based scanning and printing onto console
 */
public class MatrixMain implements Action{
	@Override
	public void performAction(int operator){
		MatrixOperations matrix = new MatrixOperations();
		matrix = scanMatrix("Enter elements of matrix, row by row: ", matrix);
		
		if(operator == 0){
			printMatrix("Your matrix is: ", matrix);
		}else if(operator == 1){
			printAdditionOfMatrices(matrix);
		}else if(operator == 2){
			printMultiplicationOfMatrices(matrix);
		}else if(operator == 3){
			printMatrix("Transpose of matrix: ", matrix.transposeMatrix());
		}
	}
	
	private static Scanner input;

	/**
	 * @Method printAdditionOfMatrices(MatrixOperations mtrx) Adding two Matrices
	 * @param mtrx
	 * @return type = void, prints onto console
	 */
	public static void printAdditionOfMatrices(MatrixOperations mtrx) {
		MatrixOperations add_matrix = new MatrixOperations(mtrx.row_size, mtrx.column_size);
		add_matrix = scanMatrix("Enter elements for addition: ", add_matrix);

		printMatrix("Addition Result: ", mtrx.addMatrix(add_matrix));
	}

	/**
	 * @Method printMultiplicationOfMatrices(MatrixOperations mtrx) Multiplying two
	 *         Matrices: Input user defined matrix to be multiplied with base matrix
	 * @param mtrx
	 * @return type = void, prints onto console
	 */
	public static void printMultiplicationOfMatrices(MatrixOperations mtrx) {
		System.out.println("Enter size of another matrix for multiplication: ");

		int row = input.nextInt();
		int column = input.nextInt();
		MatrixOperations multiply_matrix = new MatrixOperations(row, column);

		multiply_matrix = scanMatrix("Enter elements of matrix, row by row: ", multiply_matrix);
		printMatrix("Multiplication Result: ", mtrx.multiplyMatrix(multiply_matrix));
	}

	/**
	 * @Method printMatrix(String msg, Matrix view_matrix) print matrix in row x
	 *         column format
	 * @return type = void, display only
	 **/
	private static void printMatrix(String msg, Matrix view_matrix) {
		System.out.println(msg);

		for (int row_index = 0; row_index < view_matrix.row_size; row_index++) {
			for (int column_index = 0; column_index < view_matrix.column_size; column_index++) {
				System.out.print(view_matrix.matrix[row_index][column_index] + "\t");
			}
			System.out.println();
		}
	}

	/**
	 * @Method scanMatrix(String msg, MatrixOperations scan_matrix) scan element by
	 *         element input matrix
	 * @return type = MatrixOperations object, value = scanned matrix
	 */
	private static MatrixOperations scanMatrix(String msg, MatrixOperations scan_matrix) {
		System.out.println(msg);

		for (int row_index = 0; row_index < scan_matrix.row_size; row_index++) {
			for (int column_index = 0; column_index < scan_matrix.column_size; column_index++) {
				scan_matrix.addElements(row_index, column_index, input.nextInt());
			}
		}

		return scan_matrix;
	}
}
