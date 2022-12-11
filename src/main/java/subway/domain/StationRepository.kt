package subway.domain

import java.util.*

class StationRepository {
    private val stations: MutableList<Station> = ArrayList()
    fun stations(): List<Station> {
        return Collections.unmodifiableList(stations)
    }

    fun addStation(station: Station) {
        stations.add(station)
    }

    fun deleteStation(name: String?): Boolean {
        return stations.removeIf { station: Station -> station.name == name }
    }
}