package subway

import subway.view.OutputView

class Validator {
    fun validateStationName(name: String) {
        if (name.length < 2) {
            OutputView().printErrorMessage(ERROR_STATION_NAME)
            throw IllegalArgumentException()
        }
    }

    fun checkDuplicationName(name: String) {

    }
}