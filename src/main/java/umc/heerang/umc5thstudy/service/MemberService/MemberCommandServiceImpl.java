package umc.heerang.umc5thstudy.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.heerang.umc5thstudy.base.code.status.ErrorStatus;

import umc.heerang.umc5thstudy.base.exception.handler.FoodCategoryHandler;
import umc.heerang.umc5thstudy.converter.MemberConverter;
import umc.heerang.umc5thstudy.converter.MemberPreferConverter;
import umc.heerang.umc5thstudy.domain.FoodCategory;
import umc.heerang.umc5thstudy.domain.Member;
import umc.heerang.umc5thstudy.domain.mapping.MemberPrefer;
import umc.heerang.umc5thstudy.repository.FoodCategoryRepository;
import umc.heerang.umc5thstudy.repository.MemberRepository;
import umc.heerang.umc5thstudy.web.dto.MemberRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}