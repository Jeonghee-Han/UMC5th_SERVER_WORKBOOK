package umc.heerang.umc5thstudy.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.heerang.umc5thstudy.domain.Mission;
import umc.heerang.umc5thstudy.domain.Review;
import umc.heerang.umc5thstudy.domain.Store;
import umc.heerang.umc5thstudy.repository.MissionRepository;
import umc.heerang.umc5thstudy.repository.ReviewRepository;
import umc.heerang.umc5thstudy.repository.StoreRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService{

    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    private final MissionRepository missionRepository;

    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public Page<Review> getReviewList(Long StoreId, Integer page){
        Store store =storeRepository.findById(StoreId).get();
        Page<Review> StorePage = reviewRepository.findAllByStore(store, PageRequest.of(page,10));
        return StorePage;
    }

    @Override
    public Page<Mission> getMissionList(Long StoreId, Integer page) {
        Store store = storeRepository.findById(StoreId).get();
        Page<Mission> MissionPage = missionRepository.findAllByStore(store, PageRequest.of(page, 10));
        return MissionPage;
    }
}
