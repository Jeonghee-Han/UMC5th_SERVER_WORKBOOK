package umc.heerang.umc5thstudy.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.heerang.umc5thstudy.domain.Member;
import umc.heerang.umc5thstudy.domain.Review;
import umc.heerang.umc5thstudy.domain.Store;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findAllByStore(Store store, PageRequest pageRequest);
    Page<Review> findAllByMember(Member member, PageRequest pageRequest);

}
