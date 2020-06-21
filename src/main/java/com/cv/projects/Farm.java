package com.cv.projects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Farm {
	byte farmland[][];

	Farm (int rows, int cols, String[] barrens) {
		farmland = new byte[rows][cols];


		ArrayList<int[]> barrenRects = new ArrayList<>();
		
		for (int i=0; i<barrens.length; i++) {

			String[] splitVertices = barrens[i].split(" ");
			barrenRects.add(new int[splitVertices.length]);

			for (int j=0; j<splitVertices.length; j++) {
				barrenRects.get(i)[j] = Integer.parseInt(splitVertices[j]);
			}

//			System.out.println("***** barrenRects[" + i + "]:" + Arrays.toString(barrenRects.get(i)));


			//Mark barren land-units as 1
			for (int k = barrenRects.get(i)[0]; k<=barrenRects.get(i)[2]; k++)
				for (int l = barrenRects.get(i)[1]; l<=barrenRects.get(i)[3]; l++)
					farmland[k][l] = 1;

		}

//		System.out.println("***** Initial farm *****");
//		printFarm();
//		System.out.println("***** ============ *****");
	}

	List<Integer> getAllFertileAreas() {
		List<Integer> fertileAreaSizes = new ArrayList<>();

		for (int i=0; i<farmland.length; i++) {
			for(int j=0; j<farmland[0].length; j++) {
				if (farmland[i][j] == 0) {
//					System.out.println("***** Computing area of land at i="+i+" and j="+j);
					fertileAreaSizes.add(getFertileAreaSizeDFS(i, j));					

//					System.out.println("***** Farm for row:" + i + " and col:" + j); 
//					System.out.println("***** ============= *****");
//					printFarm();
				}
			}
		}

		Collections.sort(fertileAreaSizes);

//		System.out.println("***** fertileAreaSizes: " + fertileAreaSizes);
		return fertileAreaSizes;
	}

	private int getFertileAreaSizeDFS(int row, int col) {
		if (row<0 || row>=farmland.length || col<0 || col>=farmland[0].length || farmland[row][col]==1)
			return 0;

		int size = 1;
		farmland[row][col] = 1; //mark visited by marking barren. other numbers than the 1 or 0 can be used if distinction was needed for keeping the farmland for any further processing. Here we do not need so marking 1 is sufficient.

		if (isValid(row+1, col)) size+=getFertileAreaSizeDFS(row+1, col);
		if (isValid(row, col+1)) size+=getFertileAreaSizeDFS(row, col+1);
		if (isValid(row-1, col)) size+=getFertileAreaSizeDFS(row-1, col);
		if (isValid(row, col-1)) size+=getFertileAreaSizeDFS(row, col-1);

//		System.out.println ("***** size = "+size);

		return size;
	}
	
	boolean isValid(int row, int col) {
		if (row<0 || row>=farmland.length || col<0 || col>=farmland[row].length || farmland[row][col]==1)
			return false;
		return true;
	}

	void printFarm() {
		System.out.println("[");
		for(byte[] arr:farmland) {
			System.out.println(Arrays.toString(arr));
		}
		System.out.println("]");
		System.out.println();
	}
}