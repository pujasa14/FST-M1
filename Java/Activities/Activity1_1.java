package activities;

public class Activity1_1 {

	public static void main(String[] args) {

		Car Toyota = new Car();
		Toyota.Make = 2014;
		Toyota.Color = "Black";
		Toyota.Transmission = "Manual";
		
		Toyota.displayCharacterstics();
        Toyota.accelerate();
        Toyota.brake();
			
	}

}
