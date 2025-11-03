package umc.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import umc.demo.domain.member.Member;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
    List<Member> findByNameAndCreatedAtIsNull(String name);

    // ✅ 일반 join (fetch 없이)
    @Query("SELECT DISTINCT m FROM Member m " +
            "JOIN m.memberFoods mf " +
            "JOIN mf.food f")
    List<Member> findAllWithJoin();

    // Member -> MemberFood -> Food 까지 한 번에 조회
    @Query("SELECT DISTINCT m FROM Member m " +
            "JOIN FETCH m.memberFoods mf " +
            "JOIN FETCH mf.food f")
    List<Member> findAllWithFoods();
}

