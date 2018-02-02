import java.io.*;
import java.util.*;

public class FileListingApp {

	public static void main(String[] args)
	{
		System.out.println("\t\t\t-----    WELCOME TO FILE LISTING APP    -----");
		
		FileApp();         // This Function is for reading and listing the files and folders
	}
	
	
	public static void FileApp()
	{
		File file = new File("C:\\Users\\Aman Singh\\Desktop\\Java Assignments GITHUB\\Project1\\abc.txt");
	try {
		Scanner sc = new Scanner(file);
		String path1 = sc.nextLine();               // To Read the first line in the file
		
		 File newpath = new File(path1);            // The Path is fetched from the file
		 
		 File files[] = newpath.listFiles();
		     
		 int count = 0;
		 System.out.println();
		 System.out.println(" The Files in the Root Folder are - ");
		 for(int i=0;i<files.length;i++)
		 {
			 
			 if(files[i].isFile())
			 {
				 count++;
			 	 System.out.println("=> File "+count+" - "+files[i].getName()+" | path : "+files[i].getAbsolutePath());		      
			 }
		 }
		 
		 check(files , path1);
		 
	} 
	            catch (FileNotFoundException e) 
	            {		
				System.out.println("File not found !");
			    }
	}
	// Checks if it is a directory , then list all the inside files and folders with their name and absolute path
	// else list all the files in that root folder with their name and path
	
	public static void check(File files1[] , String path1)        //  The Root Folder files are already printed, 
	                                                              //  so to avoid printing it again this newpath1 is used in line 73
	{
		int count = 0;
		for(int i=0 ; i<files1.length; i++)   
		{ 
		 if(files1[i].isDirectory())            // Checks whether a file is a directory
		 {
			 File files2[] = files1[i].listFiles();
			 System.out.println();
			 System.out.println("Name of the folder - "+files1[i].getName() + " | Folder Path - "+files1[i].getAbsolutePath());
		
			 check(files2 , path1);                 // function calls itself , it runs until all the inside files are found
		 }
		 else
		 {
		 				 if(files1[i].isFile())
		 				 {
		 					 count++;                    // For counting the number of files in the folder
		 				 }
		 				 
		 			/*   
		 			        The below Statement says that if the parent folder of these files
		 			        is equal not equal to the root folder , then print it 
		 			*/
		 				 
		 				 if(!(files1[i].getParent()).equals(path1))    
		 				 {
		 		 /*
		 	       Here all the files of every directory in the given path is printed according to their containing folders 
    			  */
		 					 	 
			                   System.out.println("=> File " +count+ " in this folder - "+files1[i].getName() + " | Path - "+files1[i].getAbsolutePath());			 
		 				 
		 				 
		 				 }
		 				 }
		}
	}
}
