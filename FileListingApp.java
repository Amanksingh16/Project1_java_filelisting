import java.io.*;
import java.util.*;

public class FileListingApp {

	public static void main(String[] args) throws IOException
	{
		System.out.println("\t\t\t-----    WELCOME TO FILE LISTING APP    -----");
		Scanner sc = new Scanner(System.in);
		String path = sc.nextLine();
		File file = new File(path);
		FileReader f = null;
	try {
		  String a = "";
		  f = new FileReader(file);
		  int c;
		while ((c=f.read())!=10)
		{
				a = a + (char)c;
		} 
		 System.out.println(a);
		 File newpath = new File(a);            // The Path is fetched from the file
		 
		 File files[] = newpath.listFiles(); 
		     
		 int count1 = 0;
		 System.out.println();
		 System.out.println("The Files in the Root Folder are - ");
		 
		 for(int i=0;i<files.length;i++)
		 {			 
			 if(files[i].isFile())
			 {
				 count1++;
			 	 System.out.println("=> File "+count1+" - "+files[i].getName()+" | path : "+files[i].getAbsolutePath());		      
			 }
		 }
		 check(files , a);		
	} 
	            catch (Exception e) 
	            {		
				System.out.println("Error Occurred !");
			    }
	            finally
	            {
	            	f.close();
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
