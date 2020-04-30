package algorithm;

import java.util.Arrays;

public class MaxProduct {

	public static void main(String[] args) {
		int[] nums = {7, 3, 1, 0, 0, 6};
		
		int[] temp = {722,634,-504,-379,163,-613,-842,-578,750,951,-158,30,-238,-392,-487,-797,-157,-374,999,-5,-521,-879,-858,382,626,803,-347,903,-205,57,-342,186,-736,17,83,726,-960,343,-984,937,-758,-122,577,-595,-544,-559,903,-183,192,825,368,-674,57,-959,884,29,-681,-339,582,969,-95,-455,-275,205,-548,79,258,35,233,203,20,-936,878,-868,-458,-882,867,-664,-892,-687,322,844,-745,447,-909,-586,69,-88,88,445,-553,-666,130,-640,-918,-7,-420,-368,250,-786};
		MaxProduct maxProduct = new MaxProduct();
		int result = maxProduct.maximumProductsOfThree(temp);
		System.out.println(result);
	}
	
    public int maximumProduct(int[] nums) {
    	Arrays.sort(nums);
    	
    	int result = Integer.MIN_VALUE;
    	int product1 = 1, product2 = 1;
    	
    	
    	// given array contains all positive numbers
    	for (int i = nums.length - 1; nums.length - i <= 3; i--) {
    		product1 *= nums[i];
    	}
    	result = Math.max(result, product1);
    	
    	// given array contains negative numbers
    	product2 *= nums[nums.length - 1];

    	for (int j = 0; j < 2; j++) {
    		product2 *= nums[j];
    	}
    	result = Math.max(result, product2);
    	
    	return result;
    }
    
    public int maximumProductsOfThree(int[] nums) {
    	Arrays.sort(nums);
    	
    	return Math.max(nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3], nums[0] * nums[1] * nums[nums.length - 1]);
    }
}
