package com.daou.reviewer.domain.repository;

import com.daou.reviewer.domain.entity.BranchHistory;
import com.daou.reviewer.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : kingmj
 * @description :
 * @packageName : com.daou.reviewer.domain.repository
 * @fileName : MemberRepository
 * @date : 2024. 9. 19.
 */
@Repository
public interface BranchHistoryRepository extends JpaRepository<BranchHistory, Long> {
}
