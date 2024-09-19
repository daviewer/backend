package com.daou.reviewer.domain.repository;

import com.daou.reviewer.domain.entity.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author : kingmj
 * @description :
 * @packageName : com.daou.reviewer.domain.repository
 * @fileName : MemberAndHistoryRepositoryTest
 * @date : 2024. 9. 19.
 */
@DataJpaTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("Member table insert test")
    public void insertMember() {
        Member member = Member.builder()
                .name("kingmj")
                .email("kingmj@daou.co.kr")
                .password("king123!")
                .build();

        Member savedMember = memberRepository.save(member);

        assertThat(savedMember.getId()).isNotNull();
        assertThat(savedMember.getName()).isEqualTo("kingmj");
        assertThat(savedMember.getEmail()).isEqualTo("kingmj@daou.co.kr");
        assertThat(savedMember.getPassword()).isEqualTo("king123!");
    }
}
