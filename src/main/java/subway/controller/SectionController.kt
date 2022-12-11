package subway.controller

import subway.*
import subway.domain.Line
import subway.domain.LineRepository
import subway.domain.Station
import subway.view.InputView
import subway.view.OutputView

class SectionController {
    fun manageSection(lineRepository: LineRepository) {
        OutputView().printSystem(SECTION_MENU)
        OutputView().printSystem(CHOOSE_MENU)
        val choice = InputView().readChosenMenu()
        choiceFunction(choice, lineRepository)
        if (choice == "B")
            return
    }

    private fun choiceFunction(choice: String, lineRepository: LineRepository) {
        if (choice == "1")
            registerSection(lineRepository)
        if (choice == "2")
            deleteSection(lineRepository)
    }

    private fun registerSection(lineRepository: LineRepository) {
        OutputView().printSystem(INSERT_LINE_FOR_SECTION)
        val lineName = Line(InputView().readLineName())
        OutputView().printSystem(INSERT_STATION_FOR_SECTION)
        val station = Station(InputView().readStationName())
        OutputView().printSystem(INSERT_WHAT_SEQUENCE)
        val sequence = InputView().readWhatSequence()
        val lines = lineRepository.lines()
        val line = lines[lines.indexOf(lineName)]
        line.addSection(station, sequence)
        OutputView().printInfoMessage(SUCCESS_REGISTER_SECTION)
    }

    private fun deleteSection(lineRepository: LineRepository) {
        OutputView().printSystem(INSERT_DELETE_SECTION_LINE)
        val lineName = Line(InputView().readLineName())
        OutputView().printSystem(INSERT_DELETE_SECTION_STATION)
        val station = Station(InputView().readStationName())
        val lines = lineRepository.lines()
        val line = lines[lines.indexOf(lineName)]
        line.deleteSection(station)
        OutputView().printInfoMessage(SUCCESS_DELETE_SECTION)
    }
}