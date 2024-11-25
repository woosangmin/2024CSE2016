
public class Database {
	
	private Record[] base;
	
	public Database(int n) {
		if (n > 0)
			base = new Record[n];
		else
			base = new Record[1];
	}
	
	

}
