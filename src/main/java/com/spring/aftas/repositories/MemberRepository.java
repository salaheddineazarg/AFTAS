package com.spring.aftas.repositories;

import com.spring.aftas.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member,Long> {

    List<Member>  findMemberByFamilyName(String familyName);
    List<Member> findMemberByName(String name);
    boolean existsMemberByName(String name);
    boolean existsMemberByFamilyName(String familyName);
    boolean existsMemberByIdentityNumber(String identityNumber);

}
