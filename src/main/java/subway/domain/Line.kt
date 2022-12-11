package subway.domain

class Line(val name: String) {
    val section = mutableListOf<Station>()

    fun createLine(startStation: Station, endStation: Station) {
        section.add(startStation)
        section.add(endStation)
    }
    fun addSection(station: Station, sequence: Int) {
        section.add(sequence-1, station)
    }

    fun deleteSection(station: Station) {
        if (section.size <= 2)
            throw IllegalArgumentException()
        section.remove(station)
    }
}