package com.capgemini.services;

import com.capgemini.entities.Member;
import org.springframework.data.domain.Page;

public interface IMemberService {
    Page<Member> membersPage(int pageNumber, int pageSize);

}