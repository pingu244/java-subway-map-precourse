package subway.view

import subway.ENTER_AGAIN
import subway.Validator
import java.io.Console
import java.lang.IllegalArgumentException

class InputView {
    fun readChosenMenu(): String {
        return readLine().toString()
    }

    fun readStationName(): String {
        while (true) {
            val name = readLine().toString()
            if (catchException { Validator().validateStationName(name) })
                return name
        }
    }

    fun readLineName(): String {
        return readLine().toString()
    }

    fun readWhatSequence(): Int {
        return readLine().toString().toInt()
    }

    private fun catchException(validate: () -> Unit): Boolean {
        try {
            validate()
            return true
        } catch (e: IllegalArgumentException) {
            OutputView().printInfoMessage(ENTER_AGAIN)
        }
        return false
    }
}