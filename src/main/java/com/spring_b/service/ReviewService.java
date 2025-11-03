package umc.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.demo.domain.member.Member;
import umc.demo.domain.review.Review;
import umc.demo.domain.store.Store;
import umc.demo.repository.MemberRepository;
import umc.demo.repository.ReviewRepository;
import umc.demo.repository.StoreRepository;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;

    @Transactional
    public void createReview(Long memberId, Long storeId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException("Store not found"));
        String mock_title = "최고의 맛";
        String mock_body = "너무 맛있어요. 인생 맛집 대박";
        Float mock_score = 5f;
        Review review=Review.builder()
                .member(member)
                .store(store)
                .title(mock_title)
                .body(mock_body)
                .score(mock_score)
                .build();

        reviewRepository.save(review);
    }
}
