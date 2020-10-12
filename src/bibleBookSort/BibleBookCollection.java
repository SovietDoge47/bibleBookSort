package bibleBookSort;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class BibleBookCollection 
{
	private ArrayList<BibleBook> theBooks;

	public BibleBookCollection()
	{
		this.theBooks = new ArrayList<BibleBook>();
	}

	public BibleBookCollection(String filename)
	{
		this();
		try
		{
			Scanner input = new Scanner(new File(System.getProperty("user.dir") + "/src/bibleBookSort/" + filename));
			while(input.hasNext())
			{
				this.theBooks.add(new BibleBook(input.nextLine()));
			}
			input.close();
		}
		catch(Exception e) { e.printStackTrace();}
	}

	public void addBibleBook(BibleBook b)
	{
		this.theBooks.add(b);
	}

	public void addBibleBook(String colonDelimitedData)
	{
		this.theBooks.add(new BibleBook(colonDelimitedData));
	}

	public BibleBook getFirstBookGivenSearchTerm(String term) throws Exception
	{
		for(BibleBook aBook : this.theBooks)
		{
			if(aBook.searchSummary(term))
			{
				return aBook;
			}
		}
		throw new Exception("Term not found exception");
	}
	
	public ArrayList<BibleBook> sortByName()
	{ 
		for (int i = 0; i < this.theBooks.size()-1; i++) 
            for (int j = 0; j < this.theBooks.size()-i-1; j++) 
                if (this.theBooks.get(j).getName().compareTo(this.theBooks.get(j+1).getName()) >= 0)
                { 
                    // swap arr[j+1] and arr[j] 
                    BibleBook temp = this.theBooks.get(j); 
                    this.theBooks.set(j, this.theBooks.get(j+1));
                    this.theBooks.set(j+1, temp); 
                }
        return(this.theBooks);
	}
	
	public ArrayList<BibleBook> sortByNumberOfChapters()
	{
		for (int i = 0; i < this.theBooks.size()-1; i++) 
            for (int j = 0; j < this.theBooks.size()-i-1; j++) 
                if (this.theBooks.get(j).getNumberOfChapters() > this.theBooks.get(j+1).getNumberOfChapters())
                { 
                    // swap this.theBooks(j+1) and this.theBooks(j) 
                    BibleBook temp = this.theBooks.get(j); 
                    this.theBooks.set(j, this.theBooks.get(j+1));
                    this.theBooks.set(j+1, temp); 
                }
		return(this.theBooks);
	}
	
	public void displaySortedCollection()
	{
		for (int i = 0; i < this.theBooks.size(); i++)
		{
			System.out.println("Book Name: " + this.theBooks.get(i).getName() + 
					"(" + this.theBooks.get(i).getNumberOfChapters() +
					" chapters) - " + this.theBooks.get(i).getSummary());
		}
	}
}
