package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.movables.cars.CarCreator;
import racingcar.domain.movables.cars.CarsCreator;
import racingcar.domain.movables.factory.MovablesFactoryBean;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    @Test
    @DisplayName("게임 종료 확인")
    void isFinished() {
        final RacingGame racingGame = new RacingGame("jun, pobi", new MovablesFactoryBean().createMovablesCreator());
        racingGame.racing();
        racingGame.racing();
        racingGame.racing();
        
        assertThat(racingGame.isFinished(3)).isTrue();
    }
}