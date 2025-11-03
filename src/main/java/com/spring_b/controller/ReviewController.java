//package umc.demo.controller;
//
//import lombok.AllArgsConstructor;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import umc.demo.dto.ReviewRequestDto;
//import umc.demo.service.ReviewService;
//
//@Controller
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api/reviews")
//public class ReviewController {
//
//    private final ReviewService reviewService;
//
//    @PostMapping
//    public String createReview(@RequestBody ReviewRequestDto requestDto) {
//        reviewService.createReview(requestDto);
//        return "✅ Review created successfully!";
//    }
//}
