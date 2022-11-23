package com.capgemini.controllers.rest;

import com.capgemini.entities.Member;
import com.capgemini.entities.converters.MemberConverter;
import com.capgemini.entities.dto.MemberDto;
import com.capgemini.repositories.MemberRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/member")
public class MemberRestController {

    private MemberRepository memberRepository;
    private static final Logger logger = LogManager.getLogger(MemberRestController.class);

    public MemberRestController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping("/all")
    public List<MemberDto> findAllMember() {

        logger.error("ERROR: Start data fetching");
        logger.fatal("FATAL: Start data fetching");
        logger.trace("TRACE: Start data fetching");
        logger.info("INFO: Start data fetching");
        logger.debug("DEBUG: Start data fetching");
        List<Member> membersList = memberRepository.getLastTen();
        return MemberConverter.toMemberDtoList(membersList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> findMember(@PathVariable("id") Long id) {
        Member member = memberRepository.findById(id).get();
        if (member == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

}
