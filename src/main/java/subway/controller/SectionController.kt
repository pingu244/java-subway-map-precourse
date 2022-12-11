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
            deleteSectionAsk(lineRepository)
    }

    private fun registerSection(lineRepository: LineRepository) {
        OutputView().printSystem(INSERT_LINE_FOR_SECTION)
        val lineName = Line(InputView().readLineName())
        OutputView().printSystem(INSERT_STATION_FOR_SECTION)
        val station = Station(InputView().readStationName())
        addSection(lineName, station, lineRepository.lines())
    }

    private fun addSection(lineName: Line, station: Station, lines: List<Line>) {
        OutputView().printSystem(INSERT_WHAT_SEQUENCE)
        val sequence = InputView().readWhatSequence()
//        val line = lines[lines.indexOf(lineName)]
        val line = lines.find { line -> line == lineName }
        line?.addSection(station, sequence)
        OutputView().printInfoMessage(SUCCESS_REGISTER_SECTION)
    }

    private fun deleteSectionAsk(lineRepository: LineRepository) {
        OutputView().printSystem(INSERT_DELETE_SECTION_LINE)
        val lineName = Line(InputView().readLineName())
        OutputView().printSystem(INSERT_DELETE_SECTION_STATION)
        val station = Station(InputView().readStationName())
        deleteSection(lineName, station, lineRepository.lines())
    }

    private fun deleteSection(lineName: Line, station: Station, lines: List<Line>) {
//        val line = lines[lines.indexOf(lineName)]
        val line = lines.find { line -> line == lineName }
        line?.deleteSection(station)
        OutputView().printInfoMessage(SUCCESS_DELETE_SECTION)
    }
}