package cotato.hackathon.domain.block.domain;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@Getter
@RequiredArgsConstructor
public enum Category {
    EXERCISE("운동"),
    TRAVEL("여행"),
    MOVIE("영화"),
    BOOK("책"),
    PERFORMANCE("공연"),
    PHOTO("사진"),
    MUSIC("음악"),
    INSTRUMENT("악기"),
    FOOD("음식"),
    DIY("DIY"),
    STUDY("공부"),
    GAME("게임"),
    ART("예술"),
    COLLECTION("수집"),
    ETC("기타");

    @JsonValue
    private final String category;

    @JsonCreator
    public static Category parsing(String inputValue) {
        return Stream.of(Category.values())
                .filter(category -> category.getCategory().equals(inputValue))
                .findFirst()
                .orElse(null);
    }
}
