var money = 0;
		var input;
		var t = 0;
		var flag = false;
		while (!flag) {
			input = prompt("돈을 얼마 넣으시나요?", "");
			switch (input) {
			case "500":
			case "1000":
			case "5000":
			case "10000":
				money = eval("parseInt(input)+money");
				t++;
				if (t >= 2) {
					flag = confirm("돈을 그만 넣을까요?");
				}
				if (flag) {
					break;
				}
				continue;
			default:
				alert("입력할 수 없는 금액입니다.");
				continue;
			}
		}	
		while (flag) {
			input = prompt("몇 개의 음료수를 구매할까요?", "");
			var n = parseInt(input);
			if (n*1000 > money) {
				alert("금액이 부족합니다.");
				continue;
			}
			flag = false;
			var spentMoney = eval("n*1000");
			var leftMoney = eval("money-spentMoney");

			document.write("투입 총 금액 : "+money+"원<br>");
			document.write("구매 총 금액 : "+spentMoney+"원<br>");
			document.write("거스름돈 : "+leftMoney+"원<br>");
			document.write("구매한 음료수 개수 : "+n+"개<br>");
			break;
		}
