package umc.heerang.umc5thstudy.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.heerang.umc5thstudy.base.ApiResponse;
import umc.heerang.umc5thstudy.converter.StoreConverter;
import umc.heerang.umc5thstudy.domain.Review;
import umc.heerang.umc5thstudy.service.StoreService.StoreCommandService;
import umc.heerang.umc5thstudy.service.StoreService.StoreQueryService;
import umc.heerang.umc5thstudy.validation.annotation.ExistMember;
import umc.heerang.umc5thstudy.validation.annotation.ExistStore;
import umc.heerang.umc5thstudy.web.dto.StoreRequestDTO;
import umc.heerang.umc5thstudy.web.dto.StoreResponseDTO;

import javax.validation.Valid;

import static umc.heerang.umc5thstudy.converter.StoreConverter.reviewPreViewListDTO;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;
    private final StoreQueryService storeQueryService;

    @PostMapping("/{storeId}/reviews")
    public ApiResponse<StoreResponseDTO.CreateReviewResultDTO> createReview(@RequestBody @Valid StoreRequestDTO.ReveiwDTO request,
                                                                            @ExistStore @PathVariable(name = "storeId") Long storeId,
                                                                            @ExistMember @RequestParam(name = "memberId") Long memberId){
        Review review = storeCommandService.createReview(memberId, storeId, request);
        return ApiResponse.onSuccess(StoreConverter.toCreateReviewResultDTO(review));
    }

    @GetMapping("/{storeId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!"),
            @Parameter(name= "page", description = "페이지 번호, 0번이 1페이지 입니다."),
    })
    public ApiResponse<StoreResponseDTO.ReviewPreViewListDTO> getReviewList(@ExistStore @PathVariable(name = "storeId") Long storeId,
                                                                            @PathVariable @RequestParam(name = "page") Integer page) {
        Page<Review> reviewPage = storeQueryService.getReviewList(storeId,page);
        return ApiResponse.onSuccess(StoreConverter.reviewPreViewListDTO(reviewPage));
    }
}