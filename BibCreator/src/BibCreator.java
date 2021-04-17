
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BibCreator {
	//create this static variable to count the total number of invalid files!
	public static int counter = 0;
	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		System.out.println("Welcome to BibCreator!\n\n");
		
		//Open 10 given files
		for(int i = 1; i <= 10; i++) {
			OpenFile("Latex"+i+".bib");
		}
		
		//Create all 30 output files
		for(int i = 1; i <= 10; i++) {
			CreateFile("IEEE"+i+".json");
			CreateFile("ACM"+i+".json");
			CreateFile("NJ"+i+".json");
			
		}
		//check if the input file is valid
		//for(int i = 1; i <= 10; i++) {
			try {
				processFilesForValidation("Latex"+5+".bib", 5);
			} catch (FileInvalidException e) {
				System.out.println(e.getMessage());
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		//}
		
		
		//System.out.println("A total of " + counter + " files were invalid, and could not be processed. All other " + (10-counter) + " \"Valid\" files have been created.");
		

	}

	
	private static void processFilesForValidation(String file, int n) throws FileNotFoundException, FileInvalidException {
		// TODO Auto-generated method stub
		
		//create an arrayList to store articles of each file
		ArrayList<String> articles = new ArrayList<String>();
		
		//Read the file
		Scanner fileReader = new Scanner(new FileInputStream(file));
		//split the file by "@ARTICLE"
		fileReader.useDelimiter("@ARTICLE");
		//put all the articles into the arrayList
		while(fileReader.hasNext()) {
			articles.add(fileReader.next().trim());//remove the leading and trailing spaces of each article
		}
				
		
		//create an arraylist to store HashMap
		ArrayList<HashMap<String, String>> pendingArticles = new ArrayList<HashMap<String, String>>();
		boolean flag = true;
		
		//traverse every article in the arrayList
		//outer:
		for(int i = 0; i < articles.size(); i++) {
			//create a hashmap to store valid fields of each article
			HashMap<String, String> article = new HashMap<String, String>();
	
		
			String[] fields = articles.get(i).split(",");
//			for(int l=0; l<fields.length;l++) {
//				System.out.println(fields[l]);
//			}

			//traverse each filed of the article except the first field and the last "}"
			for(int j = 1; j < fields.length - 1; j++) {
				String[] fieldSeperation = fields[j].trim().split("[={}]");
				//System.out.println(fieldSeperation.length);
				//this shows it is invalid file, do something here
				if(fieldSeperation.length == 1) {
					System.out.println(fields[j].trim());
					flag = false;
					counter ++;
					//delete corresponding invalid files, to   
					File file1= new File("IEEE"+n+".json");
					file1.delete();
					File file2= new File("ACM"+n+".json");
					file2.delete();
					File file3= new File("NJ"+n+".json");
					file3.delete();
					
					String msg = "Error : Detected Empty Field!\n" + "====================================================\n\n" + 
					"Problem detected with input file: " + file + "\n" + "File is Invalid: Field \"" + fieldSeperation[0] + 
					"\" is Empty. Processing stopped at this point. Other empty fields may be present as well!\n\n";
					throw new FileInvalidException(msg);
				}else {
					//Here is the valid file
					//seperate each filed's key and value
					
					article.put(fieldSeperation[0], fieldSeperation[2]);// according to test, the second parameter should be fieldSeperation[2]
				}
//				if(!flag) {
//					System.out.println("Hello....");
//					
//					break outer;//breaks the first for loop
//				}
//				
			}
			pendingArticles.add(article);
		
		}
		
		if(flag) {
			createIEEE(pendingArticles, n);
			createACM(pendingArticles, n);
			createNJ(pendingArticles, n);	
		}
		
		
	}


	private static void createNJ(ArrayList<HashMap<String, String>> pendingArticles, int n) {
		// TODO Auto-generated method stub
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileOutputStream("NJ"+n+".json"));
			for(int i = 0; i < pendingArticles.size();i++ ) {
				//replace " and" to "&" in the author string
				String author = pendingArticles.get(i).get("author").trim().replaceAll("and", "&");
				//NJ standard
				String str = author + ". " + pendingArticles.get(i).get("title").trim() + ". " + pendingArticles.get(i).get("journal").trim() + 
						". " + pendingArticles.get(i).get("volume").trim() + ", " + pendingArticles.get(i).get("pages").trim() + "(" + 
						pendingArticles.get(i).get("year").trim() + ")." + "\n";
				
				pw.write(str);
						
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pw.close();	
		
	}


	private static void createACM(ArrayList<HashMap<String, String>> pendingArticles, int n) {
		// TODO Auto-generated method stub
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileOutputStream("ACM"+n+".json"));
			for(int i = 0; i < pendingArticles.size();i++ ) {
				//Get the first author name
				String author = pendingArticles.get(i).get("author").trim().replaceAll("and", "&");
				StringTokenizer st = new StringTokenizer(author, "&");
				String firstAuthor = st.nextToken().trim();
				//ACM standard
				String str = "[" + (i+1) + "] " + firstAuthor + "et al. " + pendingArticles.get(i).get("year").trim() + ". " + pendingArticles.get(i).get("title").trim() + 
						". " + pendingArticles.get(i).get("journal").trim() + ". " + pendingArticles.get(i).get("volume").trim() + ", " + 
						pendingArticles.get(i).get("number").trim() + "(" + pendingArticles.get(i).get("year").trim()+ "), " + pendingArticles.get(i).get("pages").trim() 
						+ ". DOI:https://doi.org/"+ pendingArticles.get(i).get("doi").trim() +  "." + "\n";
				
				pw.write(str);
						
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pw.close();	
	}


	private static void createIEEE(ArrayList<HashMap<String, String>> pendingArticles, int n) {
		// TODO Auto-generated method stub
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileOutputStream("IEEE"+n+".json"));
			for(int i = 0; i < pendingArticles.size();i++ ) {
				//replace " and" to "," in the author string
				String author = pendingArticles.get(i).get("author").trim().replaceAll(" and", ",");
				//IEEE standard
				String str = author + ". \"" + pendingArticles.get(i).get("title").trim() + "\", " + pendingArticles.get(i).get("journal").trim() + 
						", vol. " + pendingArticles.get(i).get("volume").trim() + ", no. " + pendingArticles.get(i).get("number").trim() + 
						", p. " + pendingArticles.get(i).get("pages").trim() + ", " + pendingArticles.get(i).get("month").trim() + " " + 
						pendingArticles.get(i).get("year").trim() + "." + "\n";
				
				pw.write(str);
						
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pw.close();	
	}


	//This method is to create 30 output files(IEEE, ACM, NJ)
	private static void CreateFile(String file) {
		// TODO Auto-generated method stub
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileOutputStream(file));
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("\n" + file + " could not be created.");
			//Delete all created files before
			//
			System.out.println("The program will terminate.");
			System.exit(0);
		}
		pw.close();
		
	}


	//This method is to open input files, and if the file does not exist, it will throw an exception
	private static void OpenFile(String file) {
		// TODO Auto-generated method stub
		Scanner fileReader = null;
		
		try {
			fileReader = new Scanner(new FileInputStream(file));
			
		}catch(FileNotFoundException e) {
			System.out.println("\nCould not open input file " + file + " for reading." + "\nPlease check if file exists! "
					+ "Program will terminate after closing any opened files." );
			//fileReader.close();//close all opened files
			System.exit(0); // exit the program
		}
		
		
	}

}
