import java.util.Scanner;

public class Homework2 {
	public static void main(String[] args){
	
		Scanner input =new Scanner(System.in);

		
		while(true){
			System.out.println("1: 5개의 총점, 평균계산 하는 프로그램");
			System.out.println("2: 섭씨를 화씨로 변경하는 프로그램");
			System.out.println("3: BMI를 계산하는 프로그램");
			System.out.println("4: 종료");
			System.out.print("원하는 프로그램을 선택하세요 : ");
			int select = input.nextInt();
			if(select==1){
				System.out.println("5개의 점수를 입력하세요");
				int score1=input.nextInt();
				int score2=input.nextInt();
				int score3=input.nextInt();
				int score4=input.nextInt();
				int score5=input.nextInt();
				int sum=score1+score2+score3+score4+score5;
				double avg = sum/5.0;
				String message = String.format("총점은 %d 평균은 %.2f점 입니다",sum,avg);
				System.out.println(message);
			}
			else if(select==2){
				System.out.println("섭씨 온도를 입력하세요");
				int C = input.nextInt();
				double result = (C*1.8)+32;
				String message = String.format("화씨 %.2fºF 입니다",result);
				System.out.println(message);
			}
			else if(select==3){
				System.out.println("몸무게를 입력하세요(kg)");
				int kg = input.nextInt();
				System.out.println("키를 입력하세요(m)");
				double cm = input.nextDouble();
				double result = (double) kg / (cm*cm);
				String message = String.format("BMI는 %.2f 입니다",result);
				System.out.println(message);
			}
			else if(select==4) {
				break;
			}
		}
		
	}
}
