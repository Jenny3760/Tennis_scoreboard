package tennisgame;

import java.io.IOException;
import java.util.Arrays;

public class Set implements I {

	Player p = null;

	static String[] point = new String[2]; // 포인트점수 
	static int[] gamePoint = new int[2]; // 게임 점수 
	static int[] setPoint = new int[2]; // 세트 점수

	public Set(Player p) {	this.p = p;	}
	
	static int[][] prevGameInfo = new int[2][5]; // prevGameInfo[팀][세트당 점수] 
	
	OneSet one = new OneSet();

	void winSet() {
		
		int winner = 0;
		int idx = 0;
		do{
			Set.gamePoint[0] = 0;
			Set.gamePoint[1] = 0;

			winner = one.winGame();
			pointWinner(winner);
			prevGameInfo[0][idx] = gamePoint[0];
			prevGameInfo[1][idx] = gamePoint[1];
			idx++;
			
			dispScoreBoard();
			
		} while( setPoint[0] != p.numOfSet/2+1 && setPoint[1]!= p.numOfSet/2+1 );// set while 
		
		System.out.printf("이긴 팀은 %s 입니다.\n", (setPoint[0] == p.numOfSet/2+1)? "teamA" : "teamB");
		endGame();
	} 
	
	void endGame() {
		try {
			System.out.println("게임을 끝내려면 Enter를 누르세요. ");
			System.in.read();
			System.in.skip(System.in.available());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 한게임에서 이긴 팀의 세트 점수 ++ 
	public void pointWinner(int p) {
		if( p == 1 ) { // A팀 승리 
			setPoint[p-1]++;
		} else {  // B팀 
			setPoint[p-1]++;
		}
	}

	public void dispScoreBoard() {
		SaveTennisFile f = new SaveTennisFile();
		f.save(prevGameInfo, setPoint, gamePoint, point);
		ScoreBoard sb = new ScoreBoard();
		sb.dispScoreBoard(prevGameInfo, setPoint, gamePoint, point);
	}

}
