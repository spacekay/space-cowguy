package setex210806;
import java.util.*;

public class StudentTreeSet {
	TreeSet<Student> set;
	Scanner sc = new Scanner(System.in);
	boolean run = true;
	int x;

	public TreeSet<Student> getStudentTreeSet() {
		set = new TreeSet<Student>();
		set.add(new Student("pockyjr", "김종현"));
		set.add(new Student("nuestaron", "곽영민"));
		set.add(new Student("realbaekho", "강동호"));
		set.add(new Student("optimushwang", "황민현"));
		set.add(new Student("glorypath","최민기"));
		return set;
	}

	public void setAdd(Set<Student> set) { // 다른 클래스에 있어도 public이면 사용 가능
		String id;
		String name;
		while(true) {
			try {
				System.out.print("아이디를 입력하세요. > ");
				id = sc.next();
				System.out.print("이름을 입력하세요. > ");
				name = sc.next();
			} catch (Exception e) {
				sc.nextLine();
				continue;
			}		
			boolean flag = set.add(new Student(id, name)); // 객체를 추가할 때는 객체를 새로 생성하여 넣어줌

			if (flag) {
				System.out.println("** "+name+"("+id+")님을 회원으로 등록하였습니다.");
				System.out.println();
				break;
			} else { 
				System.out.println("** 입력하신 아이디 "+id+"는 이미 사용 중입니다.");
				System.out.println();
				continue;
			}
		}
	}

	public void setPrintAll(Set<Student> set) {
		if (set.isEmpty()) {
			System.out.println("** 현재 가입한 회원이 없습니다.");
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
			System.out.println("** 현재 가입한 회원이 없습니다.");
		} else {
			while (k < 5) {
				System.out.print("검색할 아이디를 입력하세요. > ");
				typed = sc.next();
				k++;
				student = new Student(typed);
				foundStudent = set.floor(student);
				boolean flag = student.equals(foundStudent);

				if(flag) {
					System.out.println("** 검색 결과");
					System.out.println(foundStudent);
					break;
				} else {
					System.out.println("** 입력하신 아이디를 찾을 수 없습니다.");
					if (k != 5)
						System.out.print("다시 ");
				}
			}
		}
		if (k == 5)
			System.out.println("** 5차례 이상 입력에 실패한 경우 메인 메뉴로 이동합니다.");
		System.out.println();
	}

	public void setErase(Set<Student> set) {
		System.out.print("삭제할 회원의 아이디를 입력하세요. > ");
		boolean done = false; // flag 변수 (특정 블록 진입했는지 여부 확인 등)
		int k = 0;
		String id;
		Student student;

		while (k < 5){
			if (k != 0)
				System.out.print("삭제할 회원의 아이디를 다시 입력하세요. > ");

			k++;
			id = sc.next();

			sc.nextLine();

			student = new Student(id);
			// 어차피 번호로만 Set은 객체를 구분하므로 이름은 아무거나 적어도 됨
			done = set.remove(student);
			if (done) {
				System.out.println("** "+id+"님의 탈퇴가 완료되었습니다.");
				break;
			} else {
				continue;
			}
		}
		if (k == 5)
			System.out.println("** 5차례 이상 입력에 실패한 경우 메인 메뉴로 이동합니다.");
		System.out.println();
	}

	public void mainPage() {
		TreeSet<Student> set = getStudentTreeSet();

		while (run) {
			System.out.println("메뉴를 선택하세요.");
			System.out.println("____________________________________________________________");
			System.out.println();
			System.out.println("1. 회원 가입 | 2. 회원 삭제 | 3. 회원 검색 | 4. 전체 회원 출력 | 5. 종료");
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
				setAdd(set); // 기능에 맞는 이름 짓기
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
				System.out.println("** 프로그램을 종료합니다.");
				break;
			}
		}
	}
}
