package activities;

public class Activity1_2 {
	
	public static void main(String[] args) {
		int[] num = {10,77,10,54,-11,10};
		int sum=0;
		for (int i=0;i<=num.length-1;i++)
		{
			
		if (num[i]==10)
		{
			sum=sum+ num[i];
			}
		/*else 
		{
			System.out.println("The number is not 10");
		}*/
	
		}
	System.out.println("The value of sum is  :" + sum)	;
	result(sum);
	 
	}
public static boolean result(int sumResult) {
	if ( sumResult ==30) 
	{
		return true;
		}
	
	else
	{
		return false;
	}
}
}