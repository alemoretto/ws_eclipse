package it.prova;

import java.io.*;

public class TestLeggiScrivi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File mioFile = new File("file_da_scrivere.txt");
		
		try {
			
			mioFile.createNewFile();
			
			FileWriter fw = new FileWriter(mioFile);
			BufferedWriter bw = new BufferedWriter(fw);
			
			
			bw.write("Sto scrivendo col BuffereredWriter\r");
			bw.write("riga 2");
			bw.close();
			
			
			
			FileReader fr = new FileReader(mioFile);
			BufferedReader br = new BufferedReader(fr);
			
			String contFile = br.readLine();			
			System.out.println(contFile);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			// TODO: handle exception
		}

	}

}
