import javax.swing.JOptionPane;
import java.util.Scanner; 

public class HotelBilling {

	final static float SALES_TAX = 0.13f; 
	
	public static void main(String[] args) {

		double roomRate = 95.00; 
		double couponRate = 0.10; 
		int rooms = 3;
		double totalBill; 
		
		totalBill = calculateBill(roomRate); 
		JOptionPane.showMessageDialog(null, "Your total bill with tax comes to: " + totalBill); 
		
		totalBill = calculateBill(roomRate, rooms); 
		JOptionPane.showMessageDialog(null, "Your total with tax for " + rooms + " room(s) is $ " + totalBill);
		
		totalBill = calculateBill(roomRate, rooms, couponRate); 
		JOptionPane.showMessageDialog(null, "Your total with tax for " + rooms + " room(s) is $ " + totalBill 
				+ " This includes a discount of " + couponRate*100 + "%"); 
		
		
	}
	
	public static double calculateBill(double rate, int rooms, double coupon) {
		double tax = rate * SALES_TAX; 
		double finalRate = rate + tax; 
		finalRate = finalRate * rooms * (1 - coupon); 
		finalRate = twoDecimalRounding(finalRate); 
		return finalRate; 
	}
	
	public static double calculateBill(double rate, double rooms) {
		double tax = rate * SALES_TAX; 
		double finalRate = rate + tax; 
		finalRate = finalRate * rooms;  
		finalRate = twoDecimalRounding(finalRate); 
		return finalRate; 
	}
	
	public static double calculateBill(double rate) {
		double tax = rate * SALES_TAX; 
		double finalRate = rate + tax; 
		finalRate = twoDecimalRounding(finalRate); 
		return finalRate; 
	}

	private static double twoDecimalRounding(double decimal) {
		decimal = decimal*100; 
		decimal = decimal + 0.5; 
		decimal = (int) decimal; 
		decimal = decimal/100; 
		return decimal;
	}
}
