package subway.controller

import subway.*
import subway.domain.Line
import subway.domain.LineRepository
import subway.domain.Station
import subway.view.InputView
import subway.view.OutputView

class LineController {
    fun manageLine(lineRepository: LineRepository) {
        OutputView().printSystem(LINE_MENU)
        OutputView().printSystem(CHOOSE_MENU)
        val choice = InputView().readChosenMenu()
        choiceFunction(choice, lineRepository)
        if (choice == "B")
            return
    }

    private fun choiceFunction(choice: String, lineRepository: LineRepository) {
        if (choice == "1")
            registerLine(lineRepository)
        if (choice == "2")
            deleteLine(lineRepository)
        if (choice == "3")
            showLine(lineRepository)
    }

    private fun registerLine(lineRepository: LineRepository) {
        OutputView().printSystem(INSERT_LINE_NAME)
        val lineName = Line(InputView().readLineName())
        OutputView().printSystem(INSERT_START_LINE)
        val start = Station(InputView().readStationName())
        OutputView().printSystem(INSERT_END_LINE)
        val end = Station(InputView().readStationName())
        lineName.createLine(start, end)
        lineRepository.addLine(lineName)
        OutputView().printInfoMessage(SUCCESS_REGISTER_LINE)
    }

    private fun deleteLine(lineRepository: LineRepository) {
        OutputView().printSystem(INSERT_DELETE_LINE_NAME)
        val line = InputView().readLineName()
        if (lineRepository.deleteLineByName(line))
            OutputView().printInfoMessage(SUCCESS_DELETE_LINE)
    }

    private fun showLine(lineRepository: LineRepository) {
        OutputView().printSystem(SHOW_LINE)
        for (line in lineRepository.lines())
            OutputView().printInfoMessage(line.name)
    }
}