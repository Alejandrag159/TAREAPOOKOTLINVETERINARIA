package org.example


open class Mascota(
    var nombre: String = "",
    var especie: String = "",
    var edad: Int = 0,
    var peso: Double = 0.0
)
{


    override fun toString(): String {
        return "Mascota(nombre='$nombre', especie='$especie', edad=$edad, peso='$peso')"
    }

    fun actualizacionPeso (actPeso:Double){
        peso = actPeso
        println("El peso actualizado ${edad}")
    }
    fun incrementarEdad() {
        edad++
        println("La edad actualizada ${edad}")
    }
    fun describirMascota(){

        println("Mascota(nombre=$nombre, especie=$especie, edad=$edad, peso='$peso')")
    }


}