package com.paklog.customerx.domain.service;

import com.paklog.customerx.domain.aggregate.Feedback;
import com.paklog.customerx.domain.valueobject.FeedbackRating;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FeedbackAnalysisService {
    public double calculateNPS(List<Feedback> feedbacks) {
        if (feedbacks.isEmpty()) return 0.0;
        long promoters = feedbacks.stream().filter(f -> f.getRating().getValue() >= 9).count();
        long detractors = feedbacks.stream().filter(f -> f.getRating().getValue() <= 6).count();
        return ((double)(promoters - detractors) / feedbacks.size()) * 100.0;
    }

    public double calculateAverageRating(List<Feedback> feedbacks) {
        return feedbacks.stream().mapToInt(f -> f.getRating().getValue()).average().orElse(0.0);
    }
}
