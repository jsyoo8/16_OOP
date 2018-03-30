import java.util.Calendar;

public class Event implements Comparable<Object> {
	public Pair<Calendar, String> p = new Pair<Calendar, String>(); // Pair을 Calendar와 String값으로 인자를 갖게 생성한다.

	public Event(int year, int month, int date, String e) { // 이벤트객체를 생성하는 생성자
		// TODO Auto-generated constructor stub
		Calendar c = Calendar.getInstance(); // Calendar는 추상메소드이기 때문에 객체 생성을 위해 getInstance()를 사용한다.
		c.clear(); // 생성한 객체를 초기화시킨다.
		c.set(year, month, date); // c에 연, 월, 일을 저장시킨다.
		p.setKey(c); // c를 key에 저장한다.
		p.setValue(e); // e를 value에 저장한다.
	}

	@Override
	public int compareTo(Object o) { // 이벤트끼리 우선순위를 정하는 메소드
		// TODO Auto-generated method stub
		Event other = (Event) o;

		if (this.p.getKey().get(Calendar.YEAR) >= other.p.getKey().get(Calendar.YEAR)) { // this의 year값이 other의 year값 보다 크거나 같다면 if구문 안으로 들어가 같은지 큰지 구별을 한다.
			if (this.p.getKey().get(Calendar.YEAR) == other.p.getKey().get(Calendar.YEAR)) {
				if (this.p.getKey().get(Calendar.MONTH) >= other.p.getKey().get(Calendar.MONTH)) {
					if (this.p.getKey().get(Calendar.MONTH) == other.p.getKey().get(Calendar.MONTH)) {
						if (this.p.getKey().get(Calendar.DATE) >= other.p.getKey().get(Calendar.DATE)) {
							if (this.p.getKey().get(Calendar.DATE) == other.p.getKey().get(Calendar.DATE)) {
								return 0; // this의 year값이 other의 year값과 같다면 0이 출력된다.
							} else {
								return 1;
							}
						} else {
							return -1;
						}
					} else {
						return 1;
					}
				} else {
					return -1;
				}
			} else {
				return 1; // this의 year값이 other의 year값 보다 크다면 -1이 출력된다.
			}
		} else {
			return -1; // this의 year값이 other의 year값 보다 작다면 -1이 출력된다.
		}
	}
}
