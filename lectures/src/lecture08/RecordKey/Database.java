package RecordKey;

public class Database {

    private Record[] base;
    private int count;

    public Database(int a) {
        base = new Record[a];
        count = 0;
    }

    public Record find(Key k) {
        Record result = null;
        for (int i = 0 ; i < base.length ; i++) {
            if (k.equals(base[i].getKey())) {
                result = base[i];
            }
        }
        return result;
    }

    public boolean delete(Key k) {
        boolean result = false;
        if (count > 0) {
            int c = count;
            while(c >= 0) {
                if (k.equals(base[c].getKey())) {
                    base[c] = null;
                    count -= 1;
                    result = true;
                    break;
                }
                c--;
            }
        }
        return result;
    }

    public boolean insert(Record r) {
        boolean result = false;
        if (count < base.length) {
            int c = count;
            while (c < base.length) {
                if(base[c] == null) {
                    base[c] = r;
                    result = true;
                    count++;
                    break;
                }
                c++;
            }
        }
        return result;
    }
}
