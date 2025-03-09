package org.example

/*class ConsultaMedica (nombre : String, especie: String, edad : Int,peso : Double): Mascota( nombre, especie, edad, peso) {


    var mascota : String = ""
    var diagnosticoMedico: String = ""
    var costoConsulta: Double = 0.0
    var medicacion: Boolean = false*/
 class ConsultaMedica(
    var mascota: Mascota,
    var diagnosticoMedico: String,
    var medicacion: Boolean
){
    var costoConsulta: Double = 150000.0


    /*ConsultaMedica, que tendrá una referencia a un objeto de tipo Mascota,
    un diagnóstico médico y el costo de la consulta. Esta clase incluirá el métodocalcularCosto,
    que calculará el costo de la consulta médica, añadiendo un 15% si incluye medicación.
    El sistema permitirá gestionar una lista de mascotas, agregar nuevas, registrar consultas
    médicas para una mascota específica, y mostrar el historial de consultas con el diagnóstico
    y el costo. También debe permitir modificar los datos de las mascotas,
    como peso o edad, y calcular el costo total de todas las consultas realizadas para una mascota.*/


        fun calcularCosto(): Double {
            if (medicacion == true) {
                costoConsulta *= 1.15
                return  costoConsulta
            } else {
                return costoConsulta
            }
        }



    fun describirConsulta(){
        println("La consulta para ${mascota.nombre}, su diagnóstico: $diagnosticoMedico y su costo total: $${"%.1f".format(calcularCosto())}")

    }


}