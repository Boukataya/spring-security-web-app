package com.capgemini.repositories;

import com.capgemini.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query(value = "SELECT * FROM member ORDER BY id DESC LIMIT 2", nativeQuery = true)
    List<Member> getLastTen();
}
