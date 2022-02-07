package tennisgame;

import java.io.IOException;
import java.util.Arrays;

public class ScoreBoard {
	// 이전세트경기정보 , 선수명, 현재세트, 게임점수, 포인트 
	
	Player p = null;

	// 생성자 
	public ScoreBoard() {}
	
	public ScoreBoard(Player p) {	this.p = p;		}
	
	void startGame() {
		try {
			System.out.println("게임을 시작하려면 Enter를 누르세요. ");
			System.in.read();
			System.in.skip(System.in.available());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	void disp() {
		System.out.print(" A팀 : ");
		for (int i = 0; i < p.players.length/2; i++) {
			System.out.printf("%s ", p.players[i]);
		}
		System.out.println();
		System.out.print(" B팀 : ");
		for (int i = p.players.length/2; i < p.players.length; i++) {
			System.out.printf("%s ", p.players[i]);
		}
		System.out.println();
		System.out.println();
	}
	
	void dispScoreBoard(int[][] prevGametInfo, int[] setPoint, int[] gamePoint, String[] point) {
	
		System.out.println("\t  이전세트정보\t\t\t 현재세트 \t 게임 점수 \t     포인트 ");
		System.out.println("-".repeat(100));
		System.out.print("teamA\t   ");
		for (int i = 0; i < prevGametInfo[0].length; i++) {
			System.out.print(prevGametInfo[0][i] +"    ");
		}
		System.out.println("\t\t"+setPoint[0]+"\t\t"+gamePoint[0]+"\t\t"+ point[0]);
		System.out.println();
		System.out.print("teamB\t   ");
		for (int i = 0; i < prevGametInfo[1].length; i++) {
			System.out.print(prevGametInfo[1][i] +"    ");
		}
		System.out.println("\t\t"+setPoint[1]+"\t\t"+gamePoint[1]+"\t\t"+ point[1]);
		System.out.println("-".repeat(100));
		clearScrean();
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	void clearScrean() {
		for (int i = 0; i < 10; i++) {
			System.out.println();
		}
	}
	
}
