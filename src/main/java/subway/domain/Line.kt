package subway.domain

import java.util.*

class Line(val name: String) {
    private val sections = mutableListOf<Station>()

    fun sections(): List<Station> {
        return Collections.unmodifiableList(sections)
    }

    fun createLine(startStation: Station, endStation: Station) {
        sections.add(startStation)
        sections.add(endStation)
    }
    fun addSection(station: Station, sequence: Int) {
        sections.add(sequence-1, station)
    }

    fun deleteSection(station: Station) {
        if (sections.size <= 2)
            throw IllegalArgumentException()
        sections.remove(station)
    }
}