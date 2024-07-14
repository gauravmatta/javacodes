/*
 * You are tasked with developing a generic concurrent file reader program,that can read data from 
 * multiple text files concurrently using Java's thread pool and executor framework.
 * Your program should meet following criteria:
 * 1. The program should be able to read from multiple text files simultaneously.
 * 2. The Program should process and print each data entry.
 * 3. Each data entry that gets printed should be prefixed with the name of the thread that processed it.
 * 4. Utilize the Executor Service for managing the threads.
 * 5. Provide a mechanism to gracefully shut down all threads when all files have been read.
 */
package com.javaimplant.codingproblems;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;					
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.ReadOnlyFileSystemException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentFileReaderProgram {
	
	public static void main(String args[]) {
		String projectRoot = System.getProperty("user.dir");
        Path filePath1 = Path.of(projectRoot, "/resources/files/Apache_2k.log");		
        Path filePath2 = Path.of(projectRoot, "/resources/files/Apache_2k.log_structured.csv");	
        Path filePath3 = Path.of(projectRoot, "/resources/files/customers.csv");	
        Path filePath4 = Path.of(projectRoot, "/resources/files/sample-log.txt");
        List<Path> pathlist = new ArrayList<>();
        pathlist.add(filePath1);
        pathlist.add(filePath2);
        pathlist.add(filePath3);
        pathlist.add(filePath4);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        pathlist.forEach(p -> executorService.execute(() -> readFile(p.toString())));
        executorService.shutdown();
        
/**
 * Creating Threads manually not recommended		
 */
//		Thread file1Thread = new Thread(()->readFile(filePath1.toString()));
//		Thread file2Thread = new Thread(()->readFile(filePath2.toString()));
//		Thread file3Thread = new Thread(()->readFile(filePath3.toString()));
//		Thread file4Thread = new Thread(()->readFile(filePath4.toString()));
		
		
		
//		file1Thread.start();
//		file2Thread.start();
//		file3Thread.start();
//		file4Thread.start();
		
//		try {
//			file1Thread.join();
//			file2Thread.join();
//			file3Thread.join();
//			file4Thread.join();
//		} catch (InterruptedException e) {
//			Thread.currentThread().interrupt();
//			e.printStackTrace();
//		}
/**
 * Creating Threads manually not recommended		
 */
 }
	public static void readFile(String path) {
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String line;
			while((line= br.readLine())!= null) {
				System.out.println(Thread.currentThread().getName()+": reads line"+ line);
			}
		} catch (IOException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
				
	}

}
