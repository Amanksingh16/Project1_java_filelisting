import java.io.*;
import java.util.*;

public class FileListingApp {

	public static void main(String[] args) throws IOException {
		System.out.println("\t\t\t\t-----    WELCOME TO FILE LISTING APP    -----");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the path of the file which contains two paths");
		String path = sc.nextLine();
		String a = "" , b = "";                             // These all string values are used to read both of those two paths written in a text file
		String path1 = "" , path2 = "";
		File file = new File(path);
		FileReader f = null;
	try {
		  int count = 0;
		  f = new FileReader(file);
		  int c;
		while ((c=f.read())!=-1)
		{
			if((c)==10)
			{
				count++;
			}
			if(count == 0)
			{
				a = a + (char)c;
				path1 = a.substring(0, a.length()-1);                // This Substring is used as the value of c is also reading the newline character
			}
			if(count == 1)
			{
				b = b + (char)c;
			}
		} 
		path2 = b.substring(1, b.length()-1);                        /* This Substring is used outside the if statement as the starting value of b is 
		                                                              taking new line character of a , so it starts from 1 to read exact path*/

		 File newpath = new File(path1);            // The Path is fetched from the file
		 
		 File files[] = newpath.listFiles(); 
		 
		 check(files , path1 , path2);	
		 System.out.println("Your all information is Written in a file at : "+path2);
	} 
	            
	            finally
	            {
	            	f.close();
	            }
	
	}
	// Checks if it is a directory , then list all the inside files and folders with their name and absolute path
	// else list all the files in that root folder with their name and path
	
	public static void check(File files1[] , String path1 , String path2) throws IOException        	                                                              //  so to avoid printing it again this newpath1 is used in line 73
	{
		ArrayList <File> files = new ArrayList<File>();                  // To store the files details in a list
		Iterator<File> itr = null;                                       // To read from that list
		BufferedWriter bw = null;                                        // This is used to write all file details in a CSV file whose path is given in path2
		File f = null;
		for(int i=0 ; i<files1.length; i++)   
		{ 
		 if(files1[i].isDirectory())            // Checks whether a file is a directory
		 {
			 File files2[] = files1[i].listFiles();
			 check(files2 , path1 , path2);                 // function calls itself , it runs until all the inside files are found
		 }
		 else
		 {		 				 		 					 					 	 
			                   files.add(files1[i]);			                 			                   
	     }
		}
		try {
			itr = files.iterator();
			FileOutputStream fos = new FileOutputStream(path2,true);                   // Used to write in the files that appends the value
      	    bw = new BufferedWriter(new OutputStreamWriter(fos));                      /* This Buffered Writer is used for the function newline and 
			                                                                              can also be used as a buffer storage*/  
            while(itr.hasNext())
            {
         	   f = (File) itr.next();        	                                        
         	   bw.write("Name of the File :- "+f.getName());                       /* Print both file names and file paths to the CSV file */
         	   bw.write(" | ");
         	   bw.write("Path :- "+f.getAbsolutePath()); 
         	   bw.newLine();
         	   bw.newLine();
            }     			
		}		
		catch(Exception e)
		{
			System.out.println("Error Occurred");
		}
		finally 
		{
			if(bw!=null)
			{				
		        bw.flush();
				bw.close();
			}
		}
	}

}


