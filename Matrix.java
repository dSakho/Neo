/**
 * Matrix.java
 * Purpose: To implement basic matrix operations
 * 
 * @author d_sakho
 * @version 1.0 03/06/13
 */
package MatrixPkg;

public class Matrix implements Scalable {

	// 2-dimensional array representing the matrix
	private int[][] matrix = null;
	
	//row length and column length variables
	private int numberOfRows;
	private int numberOfColumns;
	
	// Private set functions - client shouldn't be able to set these values
	/**
	 * Sets the amount of rows for the matrix
	 * @param m	An integer
	 * @result	sets the variable m to numberOfRows
	 */
	private void setnumberOfRows(int m) {
	numberOfRows = m;
	}
	
	/**
	 * Sets the amount of columns for the matrix
	 * @param n	An integer
	 * @result	sets the variable n to numberOfColumns
	 */
	private void setnumberOfColumns(int n) {
		numberOfColumns = n;
	}
	
	/**
	 * Default constructor
	 * @return 	Creates an empty 3 x 3 matrix
	 * 			where default values for all 
	 * 			elements are 0.
	 */
	public Matrix() {
		this(3, 3);
	}
	
	/**
	 * Double parameter constructor
	 * @param m	row length
	 * @param n column length
	 * @result 	Creates an m x n matrix where all elements
	 * 			are analogous.
	 */
	public Matrix(int m, int n) {
		matrix = new int[m][m];
		setnumberOfRows(m);
		setnumberOfColumns(n);
	}
	
	/**
	 * Compares this matrix with Matrix b
	 * @param b Matrix b
	 * @return 	Tests whether this matrix and Matrix b
	 * 			have the same number of rows and columns
	 */
	public boolean equals(Matrix b) {
		return ((this.getNumberOfRows() == b.getNumberOfRows()) &&
				(this.getNumberOfColumns() == b.getNumberOfColumns()));
	}
	
	/**
	 * Determines whether the matrix is a 
	 * square matrix or not.  That is, if the 
	 * row length == column length
	 * @return true if the matrix is a square matrix
	 */
	public boolean isSquareMatrix() {
		return (getNumberOfRows() == getNumberOfColumns());
	}
	/**
	 * @return	Returns the row length
	 */
	final public int getNumberOfRows() {
		return numberOfRows;
	}
	
	/**
	 * @return Returns the column length
	 */
	final public int getNumberOfColumns() {
		return numberOfColumns;
	}
	
	/**
	 * sets the value k at position [m][n]
	 * @param m	Row m
	 * @param n	Column n
	 * @param k Integer value
	 */
	public void setAtPosition(int m, int n, int k) {
		matrix[m][n] = k;
	}
	
	/**
	 * 
	 * @param m - row index
	 * @param n	 - column index
	 * @return	Element at position [m][n]
	 */
	public int getAtPosition(int i, int j) {
		return matrix[i][j];
	}
	
	public int[] getRowAT(int i) {
		return matrix[i];
	}
	
	public int[] getColumnAt(int i) {
		int size = getNumberOfRows();
		int[] arr = new int[size];
		
		for (int m = 0; m < size; m++)
			arr[m] = matrix[m][i];
		
		return arr;
	}
	
	public void fill(int k) {
		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < numberOfColumns; j++) {
				setAtPosition(i, j, k);
			}
		}
	}
	

	/**
	 * Transposes the matrix
	 * @param a	- Matrix a
	 * @return	Matrix c that is the inverse of Matrix a
	 * 			where a[m][n] becomes c[n][m]
	 */
	public static Matrix transpose(Matrix a) {
		Matrix c = new Matrix(a.getNumberOfColumns(), a.getNumberOfRows());
		for(int i = 0; i < c.getNumberOfRows(); i++)
			for(int j = 0; j < c.getNumberOfColumns(); j++)
				c.setAtPosition(i, j, a.getAtPosition(j, i));
		
		return c;
	}
	
	/**
	 * Performs scaler multiplication on the matrix
	 * @param 
	 * @param rowNum - an integer
	 * @return	Multiplies all elements in mMatrix by k
	 */
	@Override
	public void scale(int alpha) {
		for (int i = 0; i < numberOfRows; i ++) {
			for (int j = 0; j < numberOfColumns; j++) {
				matrix[i][j] *= alpha;
			}
		}
	}
		
	public static Matrix add(Matrix a, Matrix b) {
		
		Matrix c = new Matrix(a.getNumberOfRows(), a.getNumberOfColumns());
		
		for (int i = 0; i < c.getNumberOfRows(); i++)
			for (int j = 0; j < c.getNumberOfColumns(); j++)
				c.setAtPosition(i, j, (a.getAtPosition(i, j) + b.getAtPosition(i, j)));
		
		return c;
	} 
	
	public static Matrix subtract(Matrix a, Matrix b) {
		
		Matrix c = new Matrix(a.getNumberOfRows(), a.getNumberOfColumns());
		
		for (int i = 0; i < c.getNumberOfRows(); i++)
			for (int j = 0; j < c.getNumberOfColumns(); j++)
				c.setAtPosition(i, j, (a.getAtPosition(i, j) - b.getAtPosition(i, j)));
		
		return c;
	} 
	
	/**
	 * @return Returns the object's string representation
	 */
	@Override
	public String toString() {
		String s = "";
		
		for(int i = 0; i < getNumberOfRows(); i++) {
			for(int j = 0; j < getNumberOfColumns(); j++) {
				s += getAtPosition(i, j) + " ";
			}
			s += "\n";
		}
		
		return s;
	}
}