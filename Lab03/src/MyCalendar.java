import java.util.Calendar;
import java.util.LinkedList;

public class MyCalendar {
	LinkedList<Event> _event; // Event객체를 원소로 갖는 Linked List _event이다.

	public MyCalendar() {
		_event = new LinkedList<Event>(); // MyCalendar의 객체가 생성될 때 생성된다.
	}

	public void add(int year, int month, int date, String event) { // list에 원소로 저장하는 메소드
		// TODO Auto-generated method stub
		Event e = new Event(year, month, date, event); // 주어진 값을 원소로 갖는 Event 객체 e를 생성한다.
		_event.add(e); // e를 list에 추가한다.
	}

	public boolean EventPrint(int year, int month, int date) { // 해당 일자의 값을 탐색하여 event를 출력하는 메소드이다.
		// TODO Auto-generated method stub
		Calendar c = Calendar.getInstance();
		c.clear();
		c.set(year, month, date);
		boolean eq = false; // 주어진 값이 _event의 c값과 동일한지 비교하기 위한 boolean 변수이다.
		for (int i = 0; i < _event.size(); i++) {
			eq = _event.get(i).p.getKey().equals(c);
			if (eq) { // eq가 true값이라면 if 안으로 들어간다.
				System.out.println(_event.get(i).p.getKey().get(Calendar.YEAR) + "년"
						+ _event.get(i).p.getKey().get(Calendar.MONTH) + "월"
						+ _event.get(i).p.getKey().get(Calendar.DATE) + "일 : " + _event.get(i).p.getValue());
				return true; // 같은 값을 찾았다면 여기에서 메소드가 종료된다.
			}
		}
		System.out.println("일정을 찾지 못했습니다."); // 같은 값을 찾지 못할경우 실행되는 출력구문이다.
		return false;
	}

	public boolean del(int year, int month, int date) { // 해당 일자의 값을 탐색하여 event를 삭제하는 메소드이다.
		// TODO Auto-generated method stub
		Calendar c = Calendar.getInstance();
		c.clear();
		c.set(year, month, date);
		boolean eq = false;
		for (int i = 0; i < _event.size(); i++) {
			eq = _event.get(i).p.getKey().equals(c);
			if (eq) {
				_event.remove(i); // 주어진 값과 동일한 값을 찾았다면 삭제한다.
				return true;
			}
		}
		System.out.println("삭제하고자 하는 일정이 없습니다.");
		return false;
	}

	public void EventAllPrint() { // list에 있는 모든 event를 출력하는 메소드이다.
		// TODO Auto-generated method stub
		for (int i = 0; i < _event.size(); i++) { // list의 size만큼 index i를 이용하여 반복한다.
			System.out.println(
					_event.get(i).p.getKey().get(Calendar.YEAR) + "년" + _event.get(i).p.getKey().get(Calendar.MONTH)
							+ "월" + _event.get(i).p.getKey().get(Calendar.DATE) + "일 : " + _event.get(i).p.getValue());
		}
	}

	public void sort() { // list에 있는 event들을 날짜 순서에 맞게 정렬하는 메소드이다.
		LinkedList<Event> ll = new LinkedList<Event>(); // event를 원소로 가질 수 있는 list ll을 지역객체로 생성한다.
		// TODO Auto-generated method stub
		int com = 0; // 우선순위를 비교하기 위한 정수형 변수이다.
		for (int i = 0; i < _event.size() - 1; i++) {
			com = _event.get(i).compareTo(_event.get(i + 1)); // i와 i+1의 날짜를 비교하여 com에 저장한다.
			if (com > 0) { // i의 날짜가 i+1보다 느릴경우 위치를 바꾸기 위해 if구문 안으로 들어간다.
				ll.add(_event.remove(i)); // _event에서 i의 값을 삭제하며 ll에 저장한다.
				_event.add(i + 1, ll.removeFirst()); // ll의 처음 값을 _event에서 당겨진 i의 다음 i+1의 자리에 추가한다.
				sort(); // 처음부터 다시 비교하기 위해서 sort를 다시 반복한다. 최종적으로 정렬이 된다면 if를 들어오지 않고 종료된다.
			}
		}
	}

}
