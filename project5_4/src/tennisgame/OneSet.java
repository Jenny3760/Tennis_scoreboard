package tennisgame;

public class OneSet implements I{

	OneGame one = new OneGame();

	public int winGame() {
		int winner = 0;

		do {
			// 한 게임이 끝나고 나면 게임 포인트를 초기화 해줌 
			Set.point[0] = "0";
			Set.point[1] = "0";
			one.idxA = 0;
			one.idxB = 0;
			
			winner = one.winPoint();
			pointWinner(winner);
			dispScoreBoard();

		} while( Set.gamePoint[0] != 6 && Set.gamePoint[1] != 6 ); // game while 
		
		winner = (Set.gamePoint[0] == 6 )? 1:2; 

		return winner;
	}

	// 한게임에서 이긴 팀의 게임 점수 ++ 
	public void pointWinner(int p) {
		if( p == 1 ) { // A팀 승리 
			Set.gamePoint[p-1]++;
		} else {  // B팀 승리 
			Set.gamePoint[p-1]++;
		}

	}

	public void dispScoreBoard() {
		SaveTennisFile f = new SaveTennisFile();
		f.save(Set.prevGameInfo, Set.setPoint, Set.gamePoint, Set.point);
		ScoreBoard sb = new ScoreBoard();
		sb.dispScoreBoard(Set.prevGameInfo, Set.setPoint, Set.gamePoint, Set.point);
	}

}
