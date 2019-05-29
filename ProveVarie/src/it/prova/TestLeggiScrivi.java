package it.prova;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class TestLeggiScrivi {

	public static void main(String[] args) {

		String directory = "C:\\ws_corso_java\\ws_eclipse\\ProveVarie";
		String fileName = "prova.txt";
		String absolutePath = directory + File.separator + fileName;

		String daScrivere = "Questo è stato scritto \r\ncon Java";
		
		// legge/scrive i testi
//		usaBufferedWriter(fileName, daScrivere);
//		usaBufferedReader(fileName);

		// legge/scrive raw data
//		usaBufferedOutputStream(fileName, daScrivere);
//		usaBufferedInputStream(fileName);
		
		usaFilesPerScrivere(absolutePath, daScrivere);
		usaFilesPerLeggere(absolutePath);
		
	}

	public static void usaBufferedWriter(String absolutePath, String daScrivere) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(absolutePath))) {

			System.out.println("......... inizio scrittura ..........");
			
			bw.write(daScrivere);

			System.out.println("......... fine scrittura ..........\n");
		} catch (IOException e) {
			System.out.println(" !!!   WRITE Error   !!!");
		}
	}

	public static void usaBufferedReader(String absolutePath) {
		try (BufferedReader br = new BufferedReader(new FileReader(absolutePath))) {

			System.out.println("......... inizio lettura ..........");
			
			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}

			System.out.println("......... fine lettura ..........\n");
		} catch (FileNotFoundException e) {
			System.out.println(" !!!   READ Error: unable to open file    !!!");
		} catch (IOException e) {
			System.out.println(" !!!   READ Error   !!!");
		}
	}

	public static void usaBufferedOutputStream(String absolutePath, String daScrivere) {
		try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(absolutePath))) {

			System.out.println("......... inizio scrittura ..........");

			bos.write(daScrivere.getBytes());

			System.out.println("......... fine scrittura ..........\n");
		} catch (IOException e) {
			System.out.println(" !!!   WRITE Error   !!!");
		}
	}

	public static void usaBufferedInputStream(String absolutePath) {
		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(absolutePath))) {

			System.out.println("......... inizio lettura ..........");

			int ch = bis.read();
			while (ch != -1) {
				System.out.print((char) ch);
				ch = bis.read();
			}
			System.out.println("\n......... fine lettura ..........\n");
		} catch (FileNotFoundException e) {
			System.out.println(" !!!   READ Error: unable to open file    !!!");
		} catch (IOException e) {
			System.out.println(" !!!   READ Error   !!!");
		}
	}

	public static void usaFilesPerScrivere(String absolutePath, String daScrivere) {
		try {  
			Path path = Paths.get(absolutePath);
		    Files.write(path, daScrivere.getBytes(), StandardOpenOption.CREATE);
		} catch (IOException e) {
			System.out.println(" !!!   WRITE Error   !!!");
		}
	}
	
	public static void usaFilesPerLeggere(String absolutePath) {
		try {  
			Path path = Paths.get(absolutePath);
			List<String> list = Files.readAllLines(path);
		    list.forEach(line -> System.out.println(line));
		} catch (IOException e) {
			System.out.println(" !!!   READ Error   !!!");
		}
	}
}
