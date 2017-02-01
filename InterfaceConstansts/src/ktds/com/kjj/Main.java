package ktds.com.kjj;

//MemeberGradeConst인터페이스 안에 있는 모든 상수를 한번에 가져옴
import static ktds.com.kjj.constants.MemberGradeConst.*; 

public class Main {
	
	public void start(){
		
		int grade = 0;
	
		if( grade == ADMIN ) {
			System.out.println("관리자님 환영합니다!");
		}
		else if ( grade == MEMBER ){
			System.out.println("회원님 환영합니다!");
		}
	
	}
	
	public static void main(String[] args){
		new Main().start();
	}

}
