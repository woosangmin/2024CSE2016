// By the grace of the Lord

package stage2;

public class Database {

    private Record[] base;
    private int count;

    /** Constructor 데이터베이스 초기화
     * @param a - 배열의 길이
     * count - 배열에서 null이 아닌 원소의 갯수 */
    public Database(int a) {
        base = new Record[a];
        count = 0;
    }
    /** find - Key k를 가지고 있는 원소를 찾는다.
     * @param k - 찾고자 하는 키 
     * @return result - 검색 결과 */
    public Record find(Key k) {
        // 초기값 설정
        Record result = null;
        for (int i = 0 ; i < count ; i++) {
            if (base[i] != null) {
                // 배열의 원소가 null이 아닌 경우
                if (k.equals(base[i].getKey())) // 배열의 원소의 키가 k와 동일하면 result에 배열의 원소를 저장
                    result = base[i];
            }
        }
        return result;
    }

    /** delete - Key k를 가지고 있는 원소를 지운다.
     * @param k - 지우고자 하는 키
     * @return - 성공 여부 */
    public boolean delete(Key k) {
        boolean result = false;
        // 배열에 null이 아닌 원소가 하나라도 있으면
        if (count > 0) {
            // c를 현재 길이에서 1을 뺀 값으로 설정
            int c = count-1;
            // loop invariant : 배열에는 k를 key로 가지는 원소는 존재하지 않는다.
            // c를 1씩 줄여 가며 base[i]와 k를 비교 하고 같은 경우 삭제 하고 loop를 종료한다.
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

    /** insert - record r을 배열에 집어넣는다.
     * @param r - 배열에 집어 넣을 record
     * @return result - 성공 여부 */
    public boolean insert(Record r) {
        // 반환값 초기화
        boolean result = false;
        // 배열에 null이 아닌 원소의 갯수가 배열의 길이보다 작은 경우
        if (count < base.length) {
            // count = 배열에서 맨 끝에 존재하는 원소의 위치 + 1
            if( base[count] == null) {
                base[count] = r;
                result = true;
                count++;
                }
            }
        return result;
    }
}
