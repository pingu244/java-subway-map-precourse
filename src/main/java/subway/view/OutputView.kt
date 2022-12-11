package subway.view

import subway.DOTTED_LINE
import subway.SUBWAY_MAP
import subway.domain.Line
import subway.domain.LineRepository

class OutputView {
    fun printSystem(msg: String) {
        println("\n## $msg")
    }

    fun printErrorMessage(msg: String) {
        println("[ERROR] $msg")
    }

    fun printInfoMessage(msg: String) {
        println("[INFO] $msg")
    }

    fun printSubwayMap(lineRepository: LineRepository) {
        printSystem(SUBWAY_MAP)
        for (line in lineRepository.lines()) {
            printInfoMessage(line.name)
            printInfoMessage(DOTTED_LINE)
            printSections(line)
        }
    }

    private fun printSections(line: Line) {
        for (section in line.sections())
            printInfoMessage(section.name)
        println()
    }
}