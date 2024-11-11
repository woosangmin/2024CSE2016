package Persons;

public class Persons {

    public static void main(String[] args) {

        PersonFrom x = new PersonFrom("마음", "안산");
        System.out.println("이름 " + x.getName());
        System.out.println("출신 " + x.getCity());

        Person p = new Person("마음");
        Person q = new PersonFrom("소리", "서울");

        // System.out.println(p.getCity()); // 에러
        System.out.println(q.getName()); // "소리"
        System.out.println(p.sameName(p)); // true
        System.out.println(q.sameName(p)); // false
        // System.out.println(q.same(p)); // 에러
    }
}
