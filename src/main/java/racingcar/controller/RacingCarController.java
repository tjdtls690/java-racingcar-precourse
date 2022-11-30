package racingcar.controller;

import racingcar.dto.CarsNameDTO;
import racingcar.dto.NumberOfTryDTO;
import racingcar.view.InputView;

public class RacingCarController {
    private final InputView inputView;
    
    public RacingCarController() {
        inputView = new InputView();
    }
    
    public void run() {
        final CarsNameDTO carsNameDTO = inputView.inputCarsName();
        final NumberOfTryDTO numberOfTryDTO = inputView.inputNumberOfTry();
    }
}