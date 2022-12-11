package subway.controller

import subway.CHOOSE_MENU
import subway.MAIN_MENU
import subway.domain.Line
import subway.domain.LineRepository
import subway.domain.Station
import subway.domain.StationRepository
import subway.view.InputView
import subway.view.OutputView

class SubwayController {
    val stationRepository = StationRepository()
    val lineRepository = LineRepository()

    fun start() {
        initialize()

        while (true) {
            OutputView().printSystem(MAIN_MENU)
            OutputView().printSystem(CHOOSE_MENU)
            val choice = InputView().readChosenMenu()
            choiceFunction(choice)
            if (choice == "Q")
                break
        }
    }

    private fun initialize() {
        val stations = listOf("교대역", "강남역", "역삼역", "남부터미널역",
            "양재역", "양재시민의숲역", "매봉역")
        for (name in stations)
            stationRepository.addStation(Station(name))
        val linesName = listOf("2호선", "3호선", "신분당선")
        for (name in linesName)
            lineRepository.addLine(Line(name))
        val lines = lineRepository.lines()
        lines[0].createLine(Station("교대역"), Station("역삼역"))
        lines[0].addSection(Station("강남역"),2)

        lines[1].createLine(Station("교대역"), Station("매봉역"))
        lines[1].addSection(Station("남부터미널역"), 2)
        lines[1].addSection(Station("양재역"), 3)

        lines[2].createLine(Station("강남역"), Station("양재시민의숲역"))
        lines[2].addSection(Station("양재역 "), 2)
    }

    private fun choiceFunction(choice: String) {
        if (choice == "1")
            StationController().manageStation(stationRepository)
        if (choice == "2")
            LineController().manageLine(lineRepository)
    }


}