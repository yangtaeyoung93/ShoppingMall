package com.shop.mall.repository;

import com.shop.mall.domain.member.Member;
import com.shop.mall.domain.member.MemberForm;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class MemberRepository {

    @PersistenceContext
    private  EntityManager em;


    public void save(Member member){
        if(member.getId() == null){
            em.persist(member);
        }else{
            em.merge(member);
        }

    }

    public Member findOne(Long id){
        return em.find(Member.class, id);
    }

    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> findById(String loginId) {
        return em.createQuery("select m from Member m where m.loginId = :loginId", Member.class)
                .setParameter("loginId",loginId)
                .getResultList();
    }

    public Optional<Member> findByLoginId(String loginId) {
        Optional<Member> first = findAll().stream()
                .filter(m -> m.getId().equals(loginId))
                .findFirst();
        return first;
    }

}
