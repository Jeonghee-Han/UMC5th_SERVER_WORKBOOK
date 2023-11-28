package umc.heerang.umc5thstudy.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.heerang.umc5thstudy.base.code.status.ErrorStatus;
import umc.heerang.umc5thstudy.base.exception.handler.StoreHandler;
import umc.heerang.umc5thstudy.converter.MissionConverter;
import umc.heerang.umc5thstudy.domain.Mission;
import umc.heerang.umc5thstudy.domain.Store;
import umc.heerang.umc5thstudy.repository.MissionRepository;
import umc.heerang.umc5thstudy.repository.StoreRepository;
import umc.heerang.umc5thstudy.web.dto.MissionRequestDTO;



@Service
@RequiredArgsConstructor
public class MissionCreateServiceImpl implements MissionCreateService {
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Override
    public Mission createMission(MissionRequestDTO.MissionDTO form){
        Store store = storeRepository.findById(form.getStoreId())
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        Mission mission = MissionConverter.toMission(form, store);

        return missionRepository.save(mission);
    }

}
