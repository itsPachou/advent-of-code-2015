package wrappingPaper_d2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class WrappingPaper {

	public static void main(String[] args) throws FileNotFoundException {
		
		int totalWrap = 0;
		int totalRibbon = 0;
		File dimensions = new File("input_d2.txt");
		Scanner sc = new Scanner(dimensions);
		while(sc.hasNext()) {
			String[] line = sc.next().trim().split("x");
			int[] dim = new int[3];
			for(int i=0; i<line.length; i++) {
				dim[i] = Integer.parseInt(line[i]);
			}
			Arrays.parallelSort(dim);
			totalRibbon = totalRibbon + 2*dim[0] + 2*dim[1] + dim[0]*dim[1]*dim[2];
			int smallestSide = dim[0]*dim[2];
			for(int i=0; i<dim.length; i++) {
				int side = dim[i]*dim[(i+1)%3];
				if(side<smallestSide) {
					smallestSide = side;
				}
				totalWrap = totalWrap + 2*side;
			}
			totalWrap += smallestSide;
		}
		sc.close();
		System.out.println("Total needed wrapping in square feet is " + totalWrap);
		System.out.println("Total needed ribbon in feet is " + totalRibbon);
	}

}
