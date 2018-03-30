
public class TestEvent {

	public static void main(String[] args) {
		// TODO Auto-generated methodEvent
		MyCalendar mycalendar = new MyCalendar(); // MyCalendar의 객체를 생성한다.

		mycalendar.add(2020, 11, 11, "빼빼로데이"); // mycalendar에 주어진 값을 추가하는 메소드이다.
		mycalendar.add(2000, 5, 5, "어린이날");
		mycalendar.add(2020, 1, 1, "새해");
		mycalendar.add(2100, 3, 1, "3.1절");

		mycalendar.EventPrint(2020, 1, 1); // 2020년 1월 1일의 event를 탐색하여 출력하는 메소드이다.

		mycalendar.del(2020, 1, 1); // 2020년 1월 1일의 event를 탐색하여 삭제하는 메소드이다.
		mycalendar.del(2020, 1, 2);

		mycalendar.EventPrint(2020, 1, 1);

		System.out.println("<<정렬전 모든 일정>>");
		mycalendar.EventAllPrint(); // mycalendar에 저장된 모든 event를 출력하는 메소드이다.

		mycalendar.sort(); // mycalendar에 저장된 모든 event들을 날짜 순서에 맞게 정렬하는 메소드이다.
		System.out.println("<<정렬후 모든 일정>>");
		mycalendar.EventAllPrint();
	}

}
