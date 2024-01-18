class Robot(val nombre: String) {
    var posX: Int = 0
    var posY: Int = 0
    var dir: Int = 0

    fun mover(movimientos: IntArray) {

        for (valor in movimientos) {
            when (this.dir) {
                0 -> this.posY += valor
                1 -> this.posX += valor
                2 -> this.posY += valor
                3 -> this.posX += valor
            }

            if (this.dir < 3) this.dir += 1 else  this.dir = 0
        }
    }

    fun mostrarPosicion() {
        println("$nombre está en ($posX, $posY) ${obtenerDireccion()}")
    }

    fun obtenerDireccion(): String {
        return when (this.dir) {
            0 -> "PositiveY"
            1 -> "NegativeX"
            2 -> "NegativeY"
            3 -> "PositiveX"
            else -> throw IllegalArgumentException("Dirección no válida: $dir")
        }
    }

}

fun main() {
    val robot1 = Robot("R2D2")

    val movimientos = arrayOf(
        intArrayOf(1, -5, 0, -9),
        intArrayOf(3, 3, 5, 6, 1, 0, 0, -7),
        intArrayOf(2, 1, 0, -1, 1, 1, -4),
        intArrayOf(),
        intArrayOf(3, 5)
    )

    for (movimiento in movimientos) {
        robot1.mover(movimiento)
        robot1.mostrarPosicion()
    }
}