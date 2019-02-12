
public class Ex06_Operation {

	public static void main(String[] args) {
		
		// == 연산자 (값(value)비교하는 연산자)
		//javascript(===)
		if(10==10.0f) {
			System.out.println("True");
		}else {
			System.out.println("False");
		}
		
		//! 부정연산자
		if('A' != 65) { //같지 않니?
			System.out.println("어 같은 값이 아니야");
		}else {
			System.out.println("같은 값인데");
		}//char 는 정수값을 갖는다

		// ***암기하자 (POINT)***
		// 제어문처럼 쓰는 연산자(삼항연산자)
		int p = 10;
		int k = -10;
		int result = (p==k)? p : k;
		//? 앞에있는 조건식이 true 라면 : 앞에 있는 값을
		//? 앞에있는 조석식이 false라면 : 뒤에 있는 값을
		System.out.println("result : "+result);
		
		//위 삼항 연산자를 if 문 바꾸어 보세요
		if(p==k) {
			result = p;
		}else {
			result = k;
		}System.out.println("result : "+result);
		//같은 값이 나온다면 짧은 코드
		
		/*
		 진리표
		 0 : false
		 1 : true
		 		 OR		AND
		 0 0	 0		0
		 0 1	 1		0
		 1 0	 1		0
		 1 1	 1		1
		 
		 sql(oracle)
		 select *
		 from emp
		 where job='sales' and sal > 2000;  
		 둘 다 만족
		 
		 select *
		 from emp
		 where job='sales' or sal > 2000;
		 둘 중 하나만 만족하면
		 */
		
		//연산자( | (or), & (and) )
		//0 과 1의 bit 연산
		int x = 3;
		int y = 5;
		System.out.println("x|y : " + (x|y));
		System.out.println("x&y : " + (x&y));
		//십진수 3을 -> 2진수 값으로 변환
		//128 64 32 16 8 4 2 1 
		//             0 0 1 1 (2진수:3)
		//             0 1 0 1 (2진수:5)
		//OR           0 1 1 1 > 1+2+4 > 7
		//AND          0 0 0 1 > 1
		
		//***POINT 논리연산 (||(or),&&(and)) 연산자 return boolean
		//왜 중요할까?
		//if(10>0 && -1>1 && 100>2 && 1>-1){실행문}
		//if(10>0 || -1>1 || 100>2 || 1>-1){실행문}
		
		
		
		
		
		
		
		
		
	}

}
