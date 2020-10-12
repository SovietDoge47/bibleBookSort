package bibleBookSort;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class Driver
{
	public static void main(String[] args)
	{
		BibleBookCollection theNewTestament = new BibleBookCollection("input.dat");
		try
		{
			//BibleBook answer = theNewTestament.getFirstBookGivenSearchTerm("Jesus");
			//answer.display();
			//theNewTestament.sortByNumberOfChapters();
			//theNewTestament.displaySortedCollection();
			
			theNewTestament.sortByName();
			theNewTestament.displaySortedCollection();
		}
		catch(Exception e)
		{
			System.out.println("No Book Found");
		}
	}
}
