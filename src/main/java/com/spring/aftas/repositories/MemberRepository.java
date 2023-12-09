package com.spring.aftas.repositories;

import com.spring.aftas.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member,Long> {

    List<Member>  findMemberByName(String name);
    List<Member> findMemberByFamilyName(String familyName);

}
