package umc.heerang.umc5thstudy.service.StoreService;

import umc.heerang.umc5thstudy.domain.Store;

import java.util.Optional;

public interface StoreQueryService {
    Optional<Store> findStore(Long id);
}
