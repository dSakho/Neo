package MatrixPkg;

public class MatrixClient {

	public static void main(String[] args) {
		
		Matrix aMatrix = new Matrix();
		
		aMatrix.fill(2);
		aMatrix.scale(5);
		
		System.out.println(aMatrix);
	}

}
