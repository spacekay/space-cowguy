<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Prototype 만들기</title>
<script>
	function Employee(code, name, dept, date) {
		this.code = code;
		this.name = name;
		this.dept = dept;
		this.phone = "010-0000-0000";
		this.salary = 100;
		this.startDate = new Date("2020-03-21");
		this.birthday = new Date(date);

		this.getCode = function() {
			return this.code;
		}
		this.getName = function() {
			return this.name;
		}
		this.getDept = function() {
			return this.dept;
		}
		this.setPhone = function(phone) {
			this.phone = phone;
		}
		this.setSalary = function(salary) {
			this.salary = salary;
		}
		this.getSalary = function() {
			return this.salary;
		}
		this.setStartDate = function(date) {
			this.startDate = date;
		}
		this.increaseSalary = function() {
			this.salary *= 1.5;
		}
		this.internSalary = function() {
			this.salary *= 0.5;
		}
		this.toString = function() {
			var forReturn = "사번 : " + this.code + "<br>이름 : " + this.name;
			forReturn += "<br>부서 : " + this.dept + "<br>전화번호 : " + this.phone;
			forReturn += "<br>월별 급여 : " + this.salary + "만원<br>입사일 : ";
			forReturn += this.startDate.toString() + "<br>생일 : "
					+ this.birthday.toString();
			return forReturn;
		}
	}

	function printAll(emp) {
		for (i = 0; i < emp.length; i++) {
			if (emp[i] != null) {
				document.write(emp[i].toString());
			document.write("<hr>");
			}
		}
	}

	function addEmp(emp) {
		var code = prompt("사번을 입력하세요.", "");
		var name = prompt("이름을 입력하세요.", "");
		var dept = prompt("부서를 입력하세요.", "");
		var date = prompt("생년월일을 입력하세요. (yyyy-MM-dd)", "");
		
		for (i = 0; i < emp.length; i++) {
			if (emp[i] == null) {
				emp[emp.length] = new Employee(code, name, dept, date);
				break;
			} else if (i == emp.length-1) {
				emp[emp.length] = new Employee(code, name, dept, date);
				break;
			}
		}		
		return emp;
	}

	function deleteEmp(emp) {
		var input = prompt("삭제할 직원의 사번을 입력하세요.", "E");
		var flag = false;
		for (i = 0; i < emp.length; i++) {
			if (emp[i].getCode() == input)
				flag = true;
			if (flag)
				emp[i] = emp[i + 1];
		}
		return emp;
	}

	function highSalary(emp) {
		var max = 0;
		for (i = 0; i < emp.length; i++) {
			if (emp[i] == null)
				continue;
			if (eval(emp[i].getSalary() > max)) {
				max = emp[i].getSalary();
			}
		}
		document.write("<h4>\<상위 소득자 목록\></h4>");
		for (i = 0; i < emp.length; i++) {
			if (emp[i] == null)
				continue;
			if (eval(emp[i].getSalary() === max)) {
				document.write(emp[i].toString());
				document.write("<hr>");
			}

		}
	}
</script>
</head>
<body>
	<h3>Prototype 만들기</h3>
	<hr>
	<script>
		var emp1 = new Employee("E001", "김종희", "설계팀", "1994-03-11");
		var emp2 = new Employee("E002", "배승준", "설계팀", "1994-05-05");
		var emp3 = new Employee("E003", "장여진", "해석팀", "1997-06-06");
		var emp4 = new Employee("E004", "한승용", "개발팀", "1993-09-09");
		var emp5 = new Employee("E005", "김수교", "개발팀", "1994-10-10");
		var emp6 = new Employee("E006", "이수훈", "선행팀", "1996-08-08");
		var emp7 = new Employee("E007", "정문석", "공정팀", "1993-11-11");
		var emp8 = new Employee("E008", "김상욱", "선행팀", "1992-12-12");
		var emp = [ emp1, emp2, emp3, emp4, emp5, emp6, emp7, emp8 ];

		emp = addEmp(emp);
		emp = deleteEmp(emp);
		emp = addEmp(emp);
		for (i = 0; i < emp.length; i++) {
			if (emp[i] == null)
				continue;
			if (emp[i].getDept() === "개발팀" || emp[i].getDept() === "공정팀")
				emp[i].increaseSalary();
			else if (emp[i].getDept() === "인턴")
				emp[i].internSalary();
		}
		printAll(emp);
		highSalary(emp);
		// 이름이나 사번으로 검색하여 객체 정보 출력
	</script>
</body>
</html>
