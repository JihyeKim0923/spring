package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository=new MemoryMemberRepository();

    // 각 메서드가 끝날 때 마다 실행되는 메서드
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){ //save 기능이 동작하는지 테스트
        Member member =new Member();
        member.setName("spring");

        repository.save(member); //리포지토리에 저장

        Member result=repository.findById(member.getId()).get(); //optional에서 값을 꺼낼 땐 get 사용
        Assertions.assertEquals(member,result); // 같으면 녹색불
        // 요즘 방식
        // assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 =new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 =new Member(); //이름만 다를 때 shift+f6으로 빠르게 변경 가능
        member2.setName("spring2");
        repository.save(member2);

        //when
        Member result = repository.findByName("spring1").get();
        //then
        assertThat(result).isEqualTo(member1);

    }

    @Test
    public void findAll() {
        //given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        //when
        List<Member> result = repository.findAll();
        //then
        assertThat(result.size()).isEqualTo(2); //멤버가 두개라 사이즈 2개
    }
}
