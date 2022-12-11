package subway.view

class OutputView {
    fun printSystem(msg: String) {
        println("## $msg")
    }

    fun printErrorMessage(msg: String) {
        println("[ERROR] $msg")
    }

    fun printInfoMessage(msg: String) {
        println("[INFO] $msg")
    }
}