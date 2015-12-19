package nameless;

import java.util.Scanner;

public class Pallets {
	public static void main(String[] args)
	{
		Scanner myScanner = new Scanner(System.in);
		System.out.println("How many items do you want to send?");
		int number = myScanner.nextInt();
		int palletsXL = number/200 - (number%200)/200;
		int palletsL = (number%200)/100 - ((number%200)%100)/100;
		int palletsM = (number%200%100)/50 - ((number%200%100)%50)/50;
		int palletsS = (number%200%100%50)/10 - ((number%200%100%50)%10)/10;
		System.out.println(palletsXL + " " + palletsL + " " + palletsM + " " + ((number%200%100%50%10>0) ? (palletsS+1) : (palletsS)));
	}
}
