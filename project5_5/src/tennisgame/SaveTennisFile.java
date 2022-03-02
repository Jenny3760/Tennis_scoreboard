package tennisgame;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;

public class SaveTennisFile {
	
	public void save(int[][] prevGametInfo, int[] setPoint, int[] gamePoint, String[] point) {
		LocalDate today = LocalDate.now();  
		String fileName = "/Users/jenny/Documents/JAVA/자바 5조/" + today + " Tennis.txt";
		
		try ( FileWriter fw = new FileWriter(fileName, true);
				PrintWriter pw = new PrintWriter(fw);
				){
			pw.println("\t  이전세트정보\t\t\t 현재세트 \t 게임 점수 \t     포인트 ");
			pw.println("-".repeat(100));
			pw.print("teamA\t   ");
			for (int i = 0; i < prevGametInfo[0].length; i++) {
				pw.print(prevGametInfo[0][i] +"    ");
			}
			pw.println("\t\t"+setPoint[0]+"\t\t"+gamePoint[0]+"\t\t"+ point[0]);
			pw.println();
			pw.print("teamB\t   ");
			for (int i = 0; i < prevGametInfo[1].length; i++) {
				pw.print(prevGametInfo[1][i] +"    ");
			}
			pw.println("\t\t"+setPoint[1]+"\t\t"+gamePoint[1]+"\t\t"+ point[1]);
			pw.println("-".repeat(100));
			pw.println();
			pw.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
