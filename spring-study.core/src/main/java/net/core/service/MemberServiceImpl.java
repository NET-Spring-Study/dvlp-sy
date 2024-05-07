package net.core.service;

import net.core.domain.Member;
import net.core.repository.MemberRepository;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository)
    {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member)
    {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId)
    {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalStateException("Member Not Found"));
    }
}