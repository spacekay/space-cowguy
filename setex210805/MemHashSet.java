package setex210805;

import java.util.*;

public class MemHashSet { // List 때보다 코드량 감소! 단 기능도 감소.
	Set<Member> set;
	Scanner sc = new Scanner(System.in);
	boolean run = true;
	int x;
	// 프로그램을 꺼도 저장이 되게 하려면 해당 내용을 파일 같은데 써서 내보냈다가
	// 나중에 다시 켤때 input하는 작업이 필요할 것 같다.

	// 스캐너 같은 거는 이 클래스 자체에서 쓸까?

	public Set<Member> getMemberSet() {
		// 미리 만들어진 database
		set = new HashSet<Member>();
		set.add(new Member(1, "곽영민"));
		set.add(new Member(2, "김종현"));
		set.add(new Member(3, "강동호"));
		set.add(new Member(4, "황민현"));
		set.add(new Member(5, "최민기"));

		return set;
	}

	public void setAdd(Set<Member> set) { // 다른 클래스에 있어도 public이면 사용 가능
		int no;
		String name;
		while(true) {
			try {
				System.out.print("회원번호를 입력하세요. > ");
				no = sc.nextInt();
				System.out.print("이름을 입력하세요. > ");
				name = sc.next();
			} catch (Exception e) {
				sc.nextLine();
				continue;
			}		
			boolean flag = set.add(new Member(no, name)); // 객체를 추가할 때는 객체를 새로 생성하여 넣어줌

			if (flag) {
				System.out.println("** "+name+"님이 "+no+"번 회원으로 등록되었습니다.");
				System.out.println();
				break;
			} else { 
				System.out.println("** "+no+"번으로 등록할 수 없습니다.");
				System.out.println("** 중복된 회원번호가 존재합니다.");
				System.out.println();
				continue;
			}
		}
	}

	public void setPrint(Set<Member> set) {
		if (set.isEmpty()) {
			System.out.println("** 현재 가입한 회원이 없습니다.");
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
		System.out.print("삭제할 회원의 번호를 입력하세요. > ");
		boolean done = false; // flag 변수 (특정 블록 진입했는지 여부 확인 등)
		int k = 0;
		int no;
		Member member;
		String name = "Unknown";

		while (k < 5){
			if (k != 0)
				System.out.print("삭제할 회원의 번호를 다시 입력하세요. > ");
			try {
				k++;
				no = sc.nextInt();
			} catch (Exception e) {
				sc.nextLine();
				continue;
			}
			sc.nextLine();

			member = new Member(no, name);
			// 어차피 번호로만 HashSet은 객체를 구분하므로 이름은 아무거나 적어도 됨
			done = set.remove(member);
			if (done) {
				System.out.println("** "+no+"번 회원님의 탈퇴가 완료되었습니다.");
				break;
			} else {
				continue;
			}
		}
		if (k == 5&& !done)
			System.out.println("** 5차례 이상 입력에 실패한 경우 메인 메뉴로 이동합니다.");
		System.out.println();
	}

	public void mainPage() {
		Set<Member> set = getMemberSet();

		while (run) {
			System.out.println("메뉴를 선택하세요.");
			System.out.println("_________________________________________________");
			System.out.println();
			System.out.println("1. 회원 가입 | 2. 회원 삭제 | 3. 전체 회원 출력 | 4. 종료");
			System.out.println("_________________________________________________");
			System.out.print("> ");
			try {
				x = sc.nextInt();
			} catch(Exception e) {
				sc.nextLine();
				System.out.println();
				continue;
			} 
			// 프로그램을 모듈화하기 : main method는 단순하게
			switch (x) {
			case 1: // user-defined method 이름 지을 때, API에 있는 이름은 쓰지 않기
				setAdd(set); // 또한 기능에 맞는 이름 짓기
				break;
			case 2:
				setErase(set);
				break;
			case 3:
				setPrint(set);
				break;
			case 4:
				run = false;
				System.out.println("** 프로그램을 종료합니다.");
				break;
			}
		}	
	}
}

