package setex210805;

import java.util.*;

public class MemHashSet { // List ������ �ڵ差 ����! �� ��ɵ� ����.
	Set<Member> set;
	Scanner sc = new Scanner(System.in);
	boolean run = true;
	int x;
	// ���α׷��� ���� ������ �ǰ� �Ϸ��� �ش� ������ ���� ������ �Ἥ �����´ٰ�
	// ���߿� �ٽ� �Ӷ� input�ϴ� �۾��� �ʿ��� �� ����.

	// ��ĳ�� ���� �Ŵ� �� Ŭ���� ��ü���� ����?

	public Set<Member> getMemberSet() {
		// �̸� ������� database
		set = new HashSet<Member>();
		set.add(new Member(1, "������"));
		set.add(new Member(2, "������"));
		set.add(new Member(3, "����ȣ"));
		set.add(new Member(4, "Ȳ����"));
		set.add(new Member(5, "�ֹα�"));

		return set;
	}

	public void setAdd(Set<Member> set) { // �ٸ� Ŭ������ �־ public�̸� ��� ����
		int no;
		String name;
		while(true) {
			try {
				System.out.print("ȸ����ȣ�� �Է��ϼ���. > ");
				no = sc.nextInt();
				System.out.print("�̸��� �Է��ϼ���. > ");
				name = sc.next();
			} catch (Exception e) {
				sc.nextLine();
				continue;
			}		
			boolean flag = set.add(new Member(no, name)); // ��ü�� �߰��� ���� ��ü�� ���� �����Ͽ� �־���

			if (flag) {
				System.out.println("** "+name+"���� "+no+"�� ȸ������ ��ϵǾ����ϴ�.");
				System.out.println();
				break;
			} else { 
				System.out.println("** "+no+"������ ����� �� �����ϴ�.");
				System.out.println("** �ߺ��� ȸ����ȣ�� �����մϴ�.");
				System.out.println();
				continue;
			}
		}
	}

	public void setPrint(Set<Member> set) {
		if (set.isEmpty()) {
			System.out.println("** ���� ������ ȸ���� �����ϴ�.");
		} else {

			Iterator<Member> iter = set.iterator();

			while(iter.hasNext()) {
				Member one = iter.next();
				System.out.println(one);
			}			
		}
		System.out.println();
	}

	public void setErase(Set<Member> set) {
		System.out.print("������ ȸ���� ��ȣ�� �Է��ϼ���. > ");
		boolean done = false; // flag ���� (Ư�� ��� �����ߴ��� ���� Ȯ�� ��)
		int k = 0;
		int no;
		Member member;
		String name = "Unknown";

		while (k < 5){
			if (k != 0)
				System.out.print("������ ȸ���� ��ȣ�� �ٽ� �Է��ϼ���. > ");
			try {
				k++;
				no = sc.nextInt();
			} catch (Exception e) {
				sc.nextLine();
				continue;
			}
			sc.nextLine();

			member = new Member(no, name);
			// ������ ��ȣ�θ� HashSet�� ��ü�� �����ϹǷ� �̸��� �ƹ��ų� ��� ��
			done = set.remove(member);
			if (done) {
				System.out.println("** "+no+"�� ȸ������ Ż�� �Ϸ�Ǿ����ϴ�.");
				break;
			} else {
				continue;
			}
		}
		if (k == 5&& !done)
			System.out.println("** 5���� �̻� �Է¿� ������ ��� ���� �޴��� �̵��մϴ�.");
		System.out.println();
	}

	public void mainPage() {
		Set<Member> set = getMemberSet();

		while (run) {
			System.out.println("�޴��� �����ϼ���.");
			System.out.println("_________________________________________________");
			System.out.println();
			System.out.println("1. ȸ�� ���� | 2. ȸ�� ���� | 3. ��ü ȸ�� ��� | 4. ����");
			System.out.println("_________________________________________________");
			System.out.print("> ");
			try {
				x = sc.nextInt();
			} catch(Exception e) {
				sc.nextLine();
				System.out.println();
				continue;
			} 
			// ���α׷��� ���ȭ�ϱ� : main method�� �ܼ��ϰ�
			switch (x) {
			case 1: // user-defined method �̸� ���� ��, API�� �ִ� �̸��� ���� �ʱ�
				setAdd(set); // ���� ��ɿ� �´� �̸� ����
				break;
			case 2:
				setErase(set);
				break;
			case 3:
				setPrint(set);
				break;
			case 4:
				run = false;
				System.out.println("** ���α׷��� �����մϴ�.");
				break;
			}
		}	
	}
}

