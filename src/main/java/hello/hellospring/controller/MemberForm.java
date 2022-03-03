package hello.hellospring.controller;

public class MemberForm {
    private String name;

    public String getName() {
        return name;
    } // name을 꺼내서 쓴다.

    public void setName(String name) {
        this.name = name;
    } // form에서 들어온 name이 여기에 들어간다.
}
