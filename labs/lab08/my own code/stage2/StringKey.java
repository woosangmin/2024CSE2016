// By the grace of the Lord

package stage2;

public class StringKey implements Key {
    private String s;

    public StringKey(String j) {
        s = j;
    }

    /** equals 인수로 제공된 키와 자신이 같은지 비교
     * @param m 비교 대상 키
     * @return 같으면 true. 다르면 false
     */
    public boolean equals(Key m) {
        if (m instanceof StringKey)
            return s.equals(((StringKey)m).getString());
        else return false;
        // return s == ((StringKey)m).getString(); // 에러 발생
    }

    public String getString() {
        return s;
    }
}
