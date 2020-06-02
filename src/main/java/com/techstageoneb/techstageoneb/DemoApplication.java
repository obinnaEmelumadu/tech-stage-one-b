package com.techstageoneb.techstageoneb;

import java.util.List;
import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static int noOfWashes;
	public static List<Integer> cleanPile;
	public static List<Integer> dirtyPile;

	public static int checkForPairs(List<Integer> arr, int index, int value){
		for (int i=0; i<arr.size(); i++) 
		{
			if (value == -1)
				return -1; 
			if (i != index){
				int acc = arr.get(i);
				if (acc == value && acc != -1)
					return i;
			}
		}
		return -1; //if no value
	}
	public static void main(String[] args) {
		// set the parts
		noOfWashes = 2;
		cleanPile = new ArrayList<Integer>();
		cleanPile.add(1);
		cleanPile.add(2);
		cleanPile.add(1);
		cleanPile.add(1);

		dirtyPile = new ArrayList<Integer>();
		dirtyPile.add(1);
		dirtyPile.add(4);
		dirtyPile.add(3);
		dirtyPile.add(2);
		dirtyPile.add(4);

		
		System.out.println("Before wash:");
		System.out.println("Maximum washes: "+noOfWashes);
		System.out.println("cleanPile: "+cleanPile);
		System.out.println("dirtyPile: "+dirtyPile);
		System.out.println();

		//set the pait count
		int pairCount = 0;

		//check for pairs in clean draw
		int i = 0;
		while(i < cleanPile.size()){
			int duplicateIndex = checkForPairs(cleanPile,i,cleanPile.get(i));
			if (duplicateIndex != -1){
				pairCount++;
				cleanPile.set(i,-1);
				cleanPile.set(duplicateIndex,-1);
			}
			i++;
		}

		//merge the tweo draws
		for( int jobj : cleanPile) {
			dirtyPile.add((int) jobj);
		}

		i = 0;
		while (i < dirtyPile.size()){
			if (noOfWashes == 0)
				break;

			int duplicateIndex = checkForPairs(dirtyPile,i,dirtyPile.get(i));
			if (duplicateIndex != -1){
				pairCount++;
				noOfWashes--;
				dirtyPile.set(i,-1);
				dirtyPile.set(duplicateIndex,-1);
			}
			i++;
		}
		
		System.out.println("After wash:");
		System.out.println("Pairs of socks: " + pairCount);

	}

}
