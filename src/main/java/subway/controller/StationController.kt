package subway.controller

import subway.CHOOSE_MENU
import subway.INSERT_STAION_NAME
import subway.STATION_MENU
import subway.domain.LineRepository
import subway.domain.Station
import subway.domain.StationRepository
import subway.view.InputView
import subway.view.OutputView

class StationController {


    fun manageStation() {
        OutputView().printSystem(STATION_MENU)
        OutputView().printSystem(CHOOSE_MENU)
        val choice = InputView().readChosenMenu()
        choiceFunction(choice)
        if (choice == "B")
            return
    }



    fun choiceFunction(choice: String) {
        if (choice == "1")
            registerStation()
    }

    fun registerStation() {
        OutputView().printSystem(INSERT_STAION_NAME)
        val station = Station(InputView().readStationName())
    }
}