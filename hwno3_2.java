package hw;

public class hwno3_2 {
	public static void main(String[] args) {
		int x = 10;
		int y = 20;
		int z = (++x) + (y--);
		// x�� 1 ������ �� ������ ���������� y�� ���� ���� ������ 1 �������� �ʴ´�.
		// ++ �Ǵ� --�� ��ġ�� ���� ���� ����ʿ� �ִ��Ŀ� ���� �ٸ���.
		//31
		
		System.out.println(z);
	}

}
