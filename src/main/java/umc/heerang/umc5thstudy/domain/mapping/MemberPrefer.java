package umc.heerang.umc5thstudy.domain.mapping;

import lombok.*;
import umc.heerang.umc5thstudy.domain.FoodCategory;
import umc.heerang.umc5thstudy.domain.Member;
import umc.heerang.umc5thstudy.domain.common.BaseEntity;
import javax.persistence.*;


@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberPrefer extends BaseEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private FoodCategory foodCategory;
}