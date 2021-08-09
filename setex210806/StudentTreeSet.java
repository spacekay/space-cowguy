package setex210806;
import java.util.*;

public class StudentTreeSet {
	TreeSet<Student> set;
	Scanner sc = new Scanner(System.in);
	boolean run = true;
	int x;

	public TreeSet<Student> getStudentTreeSet() {
		set = new TreeSet<Student>();
		set.add(new Student("pockyjr", "������"));
		set.add(new Student("nuestaron", "������"));
		set.add(new Student("realbaekho", "����ȣ"));
		set.add(new Student("optimushwang", "Ȳ����"));
		set.add(new Student("glorypath","�ֹα�"));
		return set;
	}

	public void setAdd(Set<Student> set) { // �ٸ� Ŭ������ �־ public�̸� ��� ����
		String id;
		String name;
		while(true) {
			try {
				System.out.print("���̵� �Է��ϼ���. > ");
				id = sc.next();
				System.out.print("�̸��� �Է��ϼ���. > ");
				name = sc.next();
			} catch (Exception e) {
				sc.nextLine();
				continue;
			}		
			boolean flag = set.add(new Student(id, name)); // ��ü�� �߰��� ���� ��ü�� ���� �����Ͽ� �־���

			if (flag) {
				System.out.println("** "+name+"("+id+")���� ȸ������ ����Ͽ����ϴ�.");
				System.out.println();
				break;
			} else { 
				System.out.println("** �Է��Ͻ� ���̵� "+id+"�� �̹� ��� ���Դϴ�.");
				System.out.println();
				continue;
			}
		}
	}

	public void setPrintAll(Set<Student> set) {
		if (set.isEmpty()) {
			System.out.println("** ���� ������ ȸ���� �����ϴ�.");
		} else {
			for(Student s : set) {
				System.out.println(s);
			}
		}
		System.out.println();
	}

	public void setSearch(TreeSet<Student> set) {
		String typed;
		Student student;
		Student foundStudent;
		int k = 0;
		if (set.isEmpty()) {
			System.out.println("** ���� ������ ȸ���� �����ϴ�.");
		} else {
			while (k < 5) {
				System.out.print("�˻��� ���̵� �Է��ϼ���. > ");
				typed = sc.next();
				k++;
				student = new Student(typed);
				foundStudent = set.floor(student);
				boolean flag = student.equals(foundStudent);

				if(flag) {
					System.out.println("** �˻� ���");
					System.out.println(foundStudent);
					break;
				} else {
					System.out.println("** �Է��Ͻ� ���̵� ã�� �� �����ϴ�.");
					if (k != 5)
						System.out.print("�ٽ� ");
				}
			}
		}
		if (k == 5)
			System.out.println("** 5���� �̻� �Է¿� ������ ��� ���� �޴��� �̵��մϴ�.");
		System.out.println();
	}

	public void setErase(Set<Student> set) {
		System.out.print("������ ȸ���� ���̵� �Է��ϼ���. > ");
		boolean done = false; // flag ���� (Ư�� ��� �����ߴ��� ���� Ȯ�� ��)
		int k = 0;
		String id;
		Student student;

		while (k < 5){
			if (k != 0)
				System.out.print("������ ȸ���� ���̵� �ٽ� �Է��ϼ���. > ");

			k++;
			id = sc.next();

			sc.nextLine();

			student = new Student(id);
			// ������ ��ȣ�θ� Set�� ��ü�� �����ϹǷ� �̸��� �ƹ��ų� ��� ��
			done = set.remove(student);
			if (done) {
				System.out.println("** "+id+"���� Ż�� �Ϸ�Ǿ����ϴ�.");
				break;
			} else {
				continue;
			}
		}
		if (k == 5)
			System.out.println("** 5���� �̻� �Է¿� ������ ��� ���� �޴��� �̵��մϴ�.");
		System.out.println();
	}

	public void mainPage() {
		TreeSet<Student> set = getStudentTreeSet();

		while (run) {
			System.out.println("�޴��� �����ϼ���.");
			System.out.println("____________________________________________________________");
			System.out.println();
			System.out.println("1. ȸ�� ���� | 2. ȸ�� ���� | 3. ȸ�� �˻� | 4. ��ü ȸ�� ��� | 5. ����");
			System.out.println("____________________________________________________________");
			System.out.print("> ");
			try {
				x = sc.nextInt();
			} catch(Exception e) {
				sc.nextLine();
				System.out.println();
				continue;
			} 
			switch (x) {
			case 1: 
				setAdd(set); // ��ɿ� �´� �̸� ����
				break;
			case 2:
				setErase(set);
				break;
			case 3:
				setSearch(set);
				break;
			case 4:
				setPrintAll(set);
				break;
			case 5:
				run = false;
				System.out.println("** ���α׷��� �����մϴ�.");
				break;
			}
		}
	}
}