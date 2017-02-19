//program to display files with Recursion

package com.demo;

import java.io.*;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.FileStatus;

public class FileListWithRecursion {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Pass one argument");
			System.exit(1);
		}
		
		Path path = new Path(args[0]);
		
		try
		{
			Configuration conf = new Configuration();
			FileSystem fileSystem = FileSystem.get(path.toUri(), conf);
			RemoteIterator<LocatedFileStatus> fileList=fileSystem.listFiles(path,true);//true here specifies the Recursion
			System.out.println("The List of File in the given path"+args[0]);
			while(fileList.hasNext())
			{
			LocateFileStatus file1=fileList.next();
			
			System.out.println(file1.toString());
			
			}
			
			

		}
		catch (IOException e)
		{
            e.printStackTrace();
		}
	}
}
