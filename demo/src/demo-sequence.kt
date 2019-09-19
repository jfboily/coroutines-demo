fun main() {
    val seq = sequence {
        println("un")
        yield(1)

        println("deux")
        yield(2)

        println("trois")
        yield(3)

        println("quatre")
        yield(4)

        println("derniere valeur de la sequence")
    }

    for (value in seq) {
        println("la valeur est $value")
    }
}