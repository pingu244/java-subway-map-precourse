package subway.controller

import subway.*
import subway.domain.Station
import subway.domain.StationRepository
import subway.view.InputView
import subway.view.OutputView

class StationController {
    fun manageStation(stationRepository: StationRepository) {
        OutputView().printSystem(STATION_MENU)
        OutputView().printSystem(CHOOSE_MENU)
        val choice = InputView().readChosenMenu()
        choiceFunction(choice, stationRepository)
        if (choice == "B")
            return
    }

    private fun choiceFunction(choice: String, stationRepository: StationRepository) {
        if (choice == "1")
            registerStation(stationRepository)
        if (choice == "2")
            deleteStation(stationRepository)
        if (choice == "3")
            showStation(stationRepository)
    }

    private fun registerStation(stationRepository: StationRepository) {
        OutputView().printSystem(INSERT_STATION_NAME)
        val station = Station(InputView().readStationName())
        stationRepository.addStation(station)
        OutputView().printInfoMessage(SUCCESS_REGISTER_STATION)
    }

    private fun deleteStation(stationRepository: StationRepository) {
        OutputView().printSystem(INSERT_DELETE_STATION_NAME)
        val station = InputView().readStationName()
        if (stationRepository.deleteStation(station))
            OutputView().printInfoMessage(SUCCESS_DELETE_STATION)
    }

    private fun showStation(stationRepository: StationRepository) {
        OutputView().printSystem(SHOW_STATION)
        for (station in stationRepository.stations())
            OutputView().printInfoMessage(station.name)
    }


}