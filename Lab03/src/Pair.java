public class Pair<K, V> { // 두가지의 유형의 자료형을 인자로 사용할 수 있는 클래스 Pair

	private K key; 
	private V value; // Pair 객체가 갖고 있는 필드
	
	public void setKey(K key){ // key에 k값을 저장한다.
		this.key = key;
	}
	
	public void setValue(V value){ //value에 v값을 저장한다.
		this.value = value;
	}
	
	public K getKey(){ // key에 저장된 값을 반환한다.
		return key;
	}
	
	public V getValue(){ // value에 저장된 값을 반환한다.
		return value;
	}

}
