package practice;

public class GenericMethod
{

	public static void main(String[] args) // 1.Main method is a caller method
	{
		// Normal hard coded
	/*	int a = 10;
		int b = 20;
		int c = a+b;
		System.out.println(c);*/
		
		//5.after return the value from additional method we can print it here as well
		int sum = add (15,20);
		System.out.println(sum);
		int data = sum+50;
		System.out.println(data);
		
		int sum1 = sub (100,50);
		System.out.println(sum1);
		
		int sum2 = mul (20*5, 10*10);
		System.out.println(sum2);
		
	}

		// Out side of main method creating additional methods 
	
		/*public static void add ()//2.Additional method is a called method 
		{
			int a= 10;
			int b = 20;
			int c = a+b;
		}*/
	
		//3.Generic method and other than that void like "int , double" these all are parameterized method
		/*public static void add(int a , int b) 
		
		{
			int c = a+b;
			System.out.println(c);
		}*/
	
		// 4.here it should return to main method so we are using return type " return c"
		public static int add(int a , int b)
		{
			int c = a+b;
			return c;
			
		}
		
		public static int sub (int e,int f) 
		{
			int g = e-f;
			return g;
		}
		
		public static int mul (int h,int i) 
		{
			int j = h*i;
			return j;
		}
	
}
