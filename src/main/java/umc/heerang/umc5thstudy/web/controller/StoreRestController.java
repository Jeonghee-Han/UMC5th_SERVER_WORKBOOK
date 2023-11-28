package umc.heerang.umc5thstudy.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.heerang.umc5thstudy.base.ApiResponse;
import umc.heerang.umc5thstudy.converter.StoreConverter;
import umc.heerang.umc5thstudy.domain.Review;
import umc.heerang.umc5thstudy.service.StoreService.StoreCommandService;
import umc.heerang.umc5thstudy.validation.annotation.ExistMember;
import umc.heerang.umc5thstudy.validation.annotation.ExistStore;
import umc.heerang.umc5thstudy.web.dto.StoreRequestDTO;
import umc.heerang.umc5thstudy.web.dto.StoreResponseDTO;

import javax.validation.Valid;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/{storeId}/reviews")
    public ApiResponse<StoreResponseDTO.CreateReviewResultDTO> createReview(@RequestBody @Valid StoreRequestDTO.ReveiwDTO request,
                                                                            @ExistStore @PathVariable(name = "storeId") Long storeId,
                                                                            @ExistMember @RequestParam(name = "memberId") Long memberId){
        Review review = storeCommandService.createReview(memberId, storeId, request);
        return ApiResponse.onSuccess(StoreConverter.toCreateReviewResultDTO(review));
    }
}