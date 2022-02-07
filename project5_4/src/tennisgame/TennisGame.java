package tennisgame;

public class TennisGame {

	public static void main(String[] args) {
		// 게임 시작하면 세팅을 해준다.
		// 세팅이 완료되면 게임을 진행시키고 과정을 출력
		// 게임 종료. 

		Player player = new Player();
		player.createNewPlayer();	
		
		ScoreBoard sb = new ScoreBoard(player);
		sb.disp();
		sb.startGame();
		
		Set set = new Set(player);
		set.winSet();

		
	}

}
