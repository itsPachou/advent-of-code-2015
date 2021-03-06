package lights_d6;

import java.io.File;
import java.util.Scanner;

public class LightsGrid {

	public static void main(String[] args) throws Exception{
		File list = new File("input_d6.txt");
		Scanner sc = new Scanner(list);
		boolean[][] lights = new boolean[1000][1000];
		while(sc.hasNext()) {
			String[] words = sc.nextLine().split(" ");
			if(words[0].equals("toggle")) {
				int x = Integer.parseInt(words[1].split(",")[0]);
				int y = Integer.parseInt(words[1].split(",")[1]);
				int xMax = Integer.parseInt(words[3].split(",")[0]);
				int yMax = Integer.parseInt(words[3].split(",")[1]);
				for(int i=x; i<=xMax; i++) {
					for(int j=y; j<=yMax; j++) {
						lights[i][j] = !lights[i][j];
					}
				}
			} else if(words[1].equals("on")) {
				int x = Integer.parseInt(words[2].split(",")[0]);
				int y = Integer.parseInt(words[2].split(",")[1]);
				int xMax = Integer.parseInt(words[4].split(",")[0]);
				int yMax = Integer.parseInt(words[4].split(",")[1]);
				for(int i=x; i<=xMax; i++) {
					for(int j=y; j<=yMax; j++) {
						lights[i][j] = true;
					}
				}
			} else if(words[1].equals("off")) {
				int x = Integer.parseInt(words[2].split(",")[0]);
				int y = Integer.parseInt(words[2].split(",")[1]);
				int xMax = Integer.parseInt(words[4].split(",")[0]);
				int yMax = Integer.parseInt(words[4].split(",")[1]);
				for(int i=x; i<=xMax; i++) {
					for(int j=y; j<=yMax; j++) {
						lights[i][j] = false;
					}
				}
			}
		}
		int counter = 0;
		for(int i=0; i<1000; i++) {
			for(int j=0; j<1000; j++) {
				if(lights[i][j]) counter += 1;
			}
		}
		System.out.println(counter);
	}

}
