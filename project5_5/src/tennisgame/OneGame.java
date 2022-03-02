package tennisgame;

import java.util.Random;

public class OneGame implements I {

	String[] score = { "0", "15", "30", "40", "GAME" };
	String[] deuceScore = { "0", "15", "30", "40", "40AD", "GAME" };
	
	int idxA, idxB;
	Random random = new Random();
	int rnd;
	
	public int winPoint(){
		
		// 한게임하는동안 포인트 얻는 방법 
		do {
			
			rnd = random.nextInt(2)+1; // 1이나 2 랜덤 발생 
			pointWinner(rnd);

			if ( idxA == 3 && idxB == 3 ) { // deucePoint 
				while( Math.abs(idxA-idxB) != 2 ) { // 2점 차이 
					dispScoreBoard();
					deucePointWinner(rnd);
					if( idxA == 4 && idxB == 4 ) {
						idxA--;
						idxB--;
					}
				}
			}
			dispScoreBoard();
	
		} while( idxA < 4 && idxB < 4 ); // point while
		
		int winner = (idxA == 4)? 1:2; 
		
		return winner;
	}

	public void deucePointWinner(int p) {
		if( p == 1 ) { // A팀 득점 
			idxA++;
			Set.point[p-1] = deuceScore[idxA];
		} else { // B팀 득점 
			idxB++;
			Set.point[p-1] = deuceScore[idxB];
		}
	}
	public void pointWinner(int p) { 
		/// p == 1 A팀 득점 p == 2 B팀 득점 
		if( p == 1 ) { // A팀 득점 
			idxA++;
			Set.point[p-1] = score[idxA];
		} else { // B팀 득점 
			idxB++;
			Set.point[p-1] = score[idxB];
		}
	}

	public void dispScoreBoard() {
		SaveTennisFile f = new SaveTennisFile();
		f.save(Set.prevGameInfo, Set.setPoint, Set.gamePoint, Set.point);
		ScoreBoard sb = new ScoreBoard();
		sb.dispScoreBoard(Set.prevGameInfo, Set.setPoint, Set.gamePoint, Set.point);
	}
	
}
