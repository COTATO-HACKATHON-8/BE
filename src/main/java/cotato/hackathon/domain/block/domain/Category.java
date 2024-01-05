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
    MOVIE("영화"),
    TRAVEL("여행"),
    MUSIC("음악");

    @JsonValue private final String category;

    @JsonCreator
    public static Category parsing(String inputValue) {
        return Stream.of(Category.values())
                .filter(category -> category.getCategory().equals(inputValue))
                .findFirst()
                .orElse(null);
    }
}
