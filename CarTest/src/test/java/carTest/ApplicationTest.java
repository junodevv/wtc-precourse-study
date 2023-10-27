package carTest;

import car.Car;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ApplicationTest {
    @Test
    @DisplayName("자동차는 명령을 받은 만큼 이동거리가 증가한다")
    void car_moves_as_ordered() {
        // given ( 주어진 값 )
        int orderedCount = 10;
        Car car = new Car();
        // when (기능 작동)
        car.moveAsOrdered(orderedCount);
        int distanceResult = car.getPosition();
        // then (기능 작동 후 검증)
        assertThat(distanceResult).isEqualTo(orderedCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 11, 12})
    @DisplayName("자동차를 이동 시킬 거리가 1 이상 0 이하의 수가 아니면 예외가 발생한다.")
    void throws_exception_when_order_count_invalid(int givenOrderCount) {
        // given
        String expectedErrorMassage = "이동 시킬 거리는 1 이상 10 이하의 수만 가능합니다.";
        Car car = new Car();
        //when & then
        assertThatThrownBy(() -> car.moveAsOrdered(givenOrderCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedErrorMassage);
    }
}
