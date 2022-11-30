package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import racingcar.constants.ErrorMessageConstant;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class InputCarsNameValidatorTest {
    @DisplayName("자동차 이름 정상 입력")
    @ParameterizedTest(name = "{displayName} : carsName => {0}")
    @CsvSource(value = {"jun", "jun,pobi", "j", "jun,pobi,crong"}, delimiter = ':')
    void normalInput(final String carsName) {
        assertThatNoException()
                .isThrownBy(() -> InputCarsNameValidator.validate(carsName));
    }
    
    @DisplayName("예외 처리 : null or empty 입력 시")
    @ParameterizedTest(name = "{displayName} : carsName => {0}")
    @NullAndEmptySource
    void nullOrEmptyInput(final String carsName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputCarsNameValidator.validate(carsName))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("예외 처리 : 공백 입력 시")
    @ParameterizedTest(name = "{displayName} : carsName => {0}")
    @CsvSource(value = {"jun, pobi", "ju n,pobi", "j un", "jun, ,pobi"}, delimiter = ':')
    void spaceInput(final String carsName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputCarsNameValidator.validate(carsName))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("예외 처리 : 특수 문자 입력 시")
    @ParameterizedTest(name = "{displayName} : carsName => {0}")
    @CsvSource(value = {"@", "%", "$", "j@n"})
    void specialCharactersInput(final String carsName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputCarsNameValidator.validate(carsName))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("예외 처리 : 숫자 입력 시")
    @ParameterizedTest(name = "{displayName} : carsName => {0}")
    @CsvSource(value = {"-1", "0", "1", "100"})
    void numberInput(final String carsName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputCarsNameValidator.validate(carsName))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("예외 처리 : 한글 입력 시")
    @ParameterizedTest(name = "{displayName} : carsName => {0}")
    @CsvSource(value = {"ㄱ", "ㅏ", "가", "강"})
    void koreanInput(final String carsName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputCarsNameValidator.validate(carsName))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("예외 처리 : 영어 대문자 입력 시")
    @ParameterizedTest(name = "{displayName} : carsName => {0}")
    @CsvSource(value = {"A", "B", "Z"})
    void upperCaseInput(final String carsName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputCarsNameValidator.validate(carsName))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("예외 처리 : 구분자가 쉼표 하나가 아닐 시")
    @ParameterizedTest(name = "{displayName} : carsName => {0}")
    @CsvSource(value = {"jun.pobi", "jun;pobi", "jun\\pobi", "jun,,pobi"}, delimiter = ':')
    void notCommaDelimiterInput(final String carsName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputCarsNameValidator.validate(carsName))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("예외 처리 : 5자를 초과한 경우")
    @ParameterizedTest(name = "{displayName} : carsName => {0}")
    @CsvSource(value = {"jun,pobiab", "pobiab"}, delimiter = ':')
    void overFiveLengths(final String carsName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputCarsNameValidator.validate(carsName))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
}