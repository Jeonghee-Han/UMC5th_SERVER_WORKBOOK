package umc.heerang.umc5thstudy.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.heerang.umc5thstudy.base.code.status.ErrorStatus;
import umc.heerang.umc5thstudy.domain.Mission;
import umc.heerang.umc5thstudy.domain.enums.MissionStatus;
import umc.heerang.umc5thstudy.repository.MemberMissionRepository;
import umc.heerang.umc5thstudy.service.MemberService.MemberQueryService;
import umc.heerang.umc5thstudy.service.MissionService.MissionQueryService;
import umc.heerang.umc5thstudy.validation.annotation.ExistOngoingMission;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class ExistOngoingMissionValidator implements ConstraintValidator<ExistOngoingMission, Object> {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public void initialize(ExistOngoingMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }

        // value가 Long 타입인 경우 memberId로 간주
        Long memberId = (value instanceof Long) ? (Long) value : null;

        if (memberId == null) {
            return false;
        }

        // value가 Mission 타입인 경우 missionId로 간주
        Long missionId = (value instanceof Mission) ? ((Mission) value).getId() : null;

        if (missionId == null) {
            return false;
        }

        boolean isMemberInMission= memberMissionRepository.existsByMemberIdAndMissionIdAndStatus(memberId,missionId, MissionStatus.CHALLENGING);
        return isMemberInMission;
    }
}
