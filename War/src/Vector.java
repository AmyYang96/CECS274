import java.util.*;
public class Vector {
	public static void main ( String[] args )
	{
		Scanner in = new Scanner(System.in);
		double n1,n2,n3, mag;
		
		System.out.println("Num1: ");
		n1 = in.nextDouble();
		System.out.println("Num2: ");
		n2 = in.nextDouble();
		System.out.println("Num3: ");
		n3= in.nextDouble();
		
		while(n1 != -2)
		{
			mag = Mag(n1,n2,n3);
			System.out.println("Mag: " + mag );
			
			System.out.println("Num1: ");
			n1 = in.nextDouble();
			System.out.println("Num2: ");
			n2 = in.nextDouble();
			System.out.println("Num3: ");
			n3= in.nextDouble();
			
		}
	}

	public static double Mag(double n1, double n2, double n3)
	{
		double mag;
		
		mag = (n1 * n1) + (n2 * n2) + (n3 * n3);
		return mag;
	}
}
