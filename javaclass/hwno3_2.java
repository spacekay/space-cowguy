package hw;

public class hwno3_2 {
	public static void main(String[] args) {
		int x = 10;
		int y = 20;
		int z = (++x) + (y--);
		// x는 1 증가한 뒤 연산이 진행하지만 y는 연산 진행 전까지 1 감소하지 않는다.
		// ++ 또는 --의 위치가 변수 기준 어느쪽에 있느냐에 따라 다르다.
		//31
		
		System.out.println(z);
	}

}
