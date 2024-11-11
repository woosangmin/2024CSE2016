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
            for (int i = 0; i < base.length; i++) {
                if (k.equals(base[i].getKey())) {
                    base[i] = null;
                    count -= 1;
                    result = true;
                }
            }
        }
        return result;
    }

    public boolean insert(Record r) {
        boolean result = false;
        if (count < base.length) {
            for (int i = 0 ; i < base.length ; i++) {
                if (!(base[i] == null)) {
                    base[i] = r;
                    result = true;
                }
            }
        }
        return result;
    }
}
