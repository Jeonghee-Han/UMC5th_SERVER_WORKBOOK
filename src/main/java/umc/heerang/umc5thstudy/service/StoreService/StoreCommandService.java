package umc.heerang.umc5thstudy.service.StoreService;

import umc.heerang.umc5thstudy.domain.Review;
import umc.heerang.umc5thstudy.web.dto.StoreRequestDTO;

public interface StoreCommandService {
    Review createReview(Long memberId, Long storeId, StoreRequestDTO.ReveiwDTO request);
}
