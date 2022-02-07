package tennisgame;

import java.util.Scanner;

public class Player {

	Scanner scanner = new Scanner(System.in);
	String[] players; // 뽑힌 플레이어 저장 
	private String gender; // 1 남자 2 여자 
	private String gameType; // 1 단식 2 복식 3 혼합복식 
	private int teamNum ; // 1번팀 2번팀 
	int numOfSet;
	
	String[][][] names = { // names[팀][성별][이름] 팀이 0 이면 1팀, 팀이 1이면 2팀 성별이 0이면 남자, 1이면 여자. 
			{
				{"김길동","홍길동","이길동","최길동"},
				{"김춘향","이춘향","최춘향","홍춘향"}
			},
			{
				{"김철수","이철수","홍철수","최철수"},
				{"김영희","이영희","홍영희","최영희"}
			}
	};
	
	// Game 종류설정하고 세트 수를 넘주는 함수 
	public void setGame() { 

		do {
			System.out.println("게임 타입을 선택하세요 [ 1. 단식 2. 복식 3. 혼합복식 ]");
			gameType = scanner.next();
		} while ( !( gameType.equals("1") || gameType.equals("2") || gameType.equals("3") ));

		if ( !gameType.equals("3") ) {
			do {

				System.out.println("성별 입력 [ 1.남자 2.여자 ]");
				gender = scanner.next();

			} while ( ! ( gender.equals("1") || gender.equals("2") ));
		}

		if( gameType.equals("1") ) { // 단식 
			if (gender.equals("2") )	numOfSet = 3;  // 단식, 여자면 3세트 
			else	numOfSet = 5; // 단식, 남자면 5세트 
		} else {  // 복식 
			numOfSet = 3; // 복식은 3세트 
		}
	}

	// 경기할 플레이어를 뽑는 함수 
	void createNewPlayer(){
		setGame();
		int n = 0;
		
		if( gameType.equals("1")) { // 단식 
			players = new String[2];
			
			for (int i = 0; i < players.length; i++) {
				teamNum = i+1;
				playerInfo(teamNum);
				System.out.printf("%d번팀의 %s 플레이어 선택하세요 > ", teamNum , (gender.equals("1")? "남자":"여자"));
				n = scanner.nextInt();
				players[i] = names[teamNum-1][Integer.parseInt(gender)-1][n-1];
			}
			
		} else if( gameType.equals("2") ){ // 복식 
			players = new String[4];
			
			for (int i = 0; i < players.length; i++) {
				
				teamNum = (i==0)? 1 : 2;
				playerInfo(teamNum);
				System.out.printf("%d번팀의 %s 플레이어 선택하세요 > ", teamNum , (gender.equals("1")? "남자":"여자"));
				n = scanner.nextInt();
				players[i] = names[teamNum-1][Integer.parseInt(gender)-1][n-1];
				do {
					System.out.printf("%d번팀의 %s 플레이어 선택하세요 > ", teamNum , (gender.equals("1")? "남자":"여자"));
					n = scanner.nextInt();
					players[i+1] = names[teamNum-1][Integer.parseInt(gender)-1][n-1];
				} while( players[1].equals(players[0]) );
				i++;
			}

		} else { // 혼합 복식 
			players = new String[4];
			
			for (int i = 0; i < players.length; i++) {
				
				teamNum = (i==0)? 1 : 2;
				gender = "1";
				playerInfo(teamNum);
				System.out.printf("%d번팀의 %s 플레이어 선택하세요 > ", teamNum , (gender.equals("1")? "남자":"여자"));			
				n = scanner.nextInt();
				players[i] = names[teamNum-1][Integer.parseInt(gender)-1][n-1];

				gender = "2";
				playerInfo(teamNum);
				System.out.printf("%d번팀의 %s 플레이어 선택하세요 > ", teamNum , (gender.equals("1")? "남자":"여자"));			
				n = scanner.nextInt();
				players[i+1] = names[teamNum-1][Integer.parseInt(gender)-1][n-1];
				i++;
			}

		}
	} // createNewPlayer() 

	private void playerInfo(int teamNum) {

		if ( gender.equals("1") ) {
			System.out.print("[");
			for (int i = 0; i < names[teamNum-1][0].length; i++) {
				System.out.printf(" %d. %s ", i+1, names[teamNum-1][0][i]);
			}
			System.out.println("]");
		}
		if ( gender.equals("2") ) {
			System.out.print("[");
			for (int i = 0; i < names[teamNum-1][1].length; i++) {
				System.out.printf(" %d. %s ", i+1, names[teamNum-1][1][i]);
			}
			System.out.println("]");
		}
	}

} // class
