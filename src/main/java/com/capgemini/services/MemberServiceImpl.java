package com.capgemini.services;

import com.capgemini.entities.Member;
import com.capgemini.repositories.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements IMemberService {

    private MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Page<Member> membersPage(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        return this.memberRepository.findAll(pageable);
    }

    @Override
    public void saveMember(Member member) {
        memberRepository.save(member);
    }

}
