package umc.heerang.umc5thstudy.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.heerang.umc5thstudy.converter.StoreConverter;
import umc.heerang.umc5thstudy.domain.Review;
import umc.heerang.umc5thstudy.repository.MemberRepository;
import umc.heerang.umc5thstudy.repository.ReviewRepository;
import umc.heerang.umc5thstudy.repository.StoreRepository;
import umc.heerang.umc5thstudy.web.dto.StoreRequestDTO;

@Service
@Transactional
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService{

    private final ReviewRepository reviewRepository;

    private final MemberRepository memberRepository;

    private final StoreRepository storeRepository;

    @Override
    public Review createReview(Long memberId, Long storeId, StoreRequestDTO.ReveiwDTO request) {

        Review review = StoreConverter.toReview(request);

        review.setMember(memberRepository.findById(memberId).get());
        review.setStore(storeRepository.findById(storeId).get());

        return reviewRepository.save(review);
    }
}
