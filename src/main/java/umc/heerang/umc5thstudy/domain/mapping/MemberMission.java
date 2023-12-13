package umc.heerang.umc5thstudy.domain.mapping;

import lombok.*;
import umc.heerang.umc5thstudy.domain.FoodCategory;
import umc.heerang.umc5thstudy.domain.Mission;
import umc.heerang.umc5thstudy.domain.Member;
import umc.heerang.umc5thstudy.domain.common.BaseEntity;
import umc.heerang.umc5thstudy.domain.enums.MissionStatus;

import javax.persistence.*;


@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MissionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;
}
