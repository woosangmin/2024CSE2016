package lecture09.scrollinglist;

public class Counter2 extends Counter {
	private int my_index;
	
	public Counter2(int start, int index) {
		super(start); 
		my_index = index;
	}
	
	public String toString() {
		return "Counter " + my_index + " has " + countOf();
	}
}
