package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
/*Desarrolla un sistema de gestión para una veterinaria que permita
    registrar mascotas, realizar consultas médicas y calcular los costos asociados.
    La clase Mascota debe incluir los atributos nombre, especie, edad y peso, y métodos
    como actualizarPeso para modificar el peso de la mascota, incrementarEdad() para sumar un año
    a la edad, y describirMascota() para devolver la información completa de la mascota. Además,
    se debe crear la clase ConsultaMedica, que tendrá una referencia a un objeto de tipo Mascota,
    un diagnóstico médico y el costo de la consulta. Esta clase incluirá el métodocalcularCosto,
    que calculará el costo de la consulta médica, añadiendo un 15% si incluye medicación.
    El sistema permitirá gestionar una lista de mascotas, agregar nuevas, registrar consultas
    médicas para una mascota específica, y mostrar el historial de consultas con el diagnóstico
    y el costo. También debe permitir modificar los datos de las mascotas,
    como peso o edad, y calcular el costo total de todas las consultas realizadas para una mascota.*/



    val veterinaria = mutableListOf<Mascota>()
    val consultaMedicas = mutableListOf<ConsultaMedica>()
    var opc: Int

    do {
        println(
            """
           Menu 
           1. Registrar o actualizar  
           2. Consultar  mascota individual o total 
           3. Registro de Consulta 
           4. Costo de Cita 
           5. Historial de Consulta 
           6. Salir
            """.trimIndent()
        )
        print("Seleccione una opción: ")
        opc = readln().toInt()

        when (opc) {
            1 -> {
                println(
                    """
           Menu 
           1. Registrar Mascota
           2. Actualizar peso 
            """.trimIndent()
                )
                print("Seleccione una opción: ")

            val opc1 = readln().toInt()
                when(opc1){
                     1->{   println("Ingrese los datos de la Mascota :")
                        print(" Ingresar el Nombre: ")
                        val nombre = readln()
                        print("Ingresar la Especie: ")
                        val especie = readln()
                        print(" Ingresar la Edad : ")
                        val edad = readln().toInt()
                        print("Cantidad de peso: ")
                        val peso = readln().toDouble()

                      val datosMasc = Mascota (nombre, especie, edad, peso)

                    veterinaria.add(datosMasc)
                    println("Mascota registrada correctamente!,Nombre: ${nombre}, Especie ${especie}, Edad: ${edad}, Peso: ${peso}")
                     }
                    2 ->{
                            print("Ingrese el nombre de la mascota para actualizar el peso: ")
                            val nombre = readln()
                            val mascota = veterinaria.find { it.nombre == nombre }

                            if (mascota != null) {
                                print("Ingrese el nuevo peso: ")
                                val actPeso = readln().toDouble()
                                mascota.actualizacionPeso(actPeso)
                            }
                        }
                    }
                }

            2-> {
                println(
                    """
           Menu 
           1. Consultar una mascota
           2. Consultar Todas 
            """.trimIndent()
                )
                print("Seleccione una opción: ")
                var opci = readln().toInt()
             when (opci){
               1->{ if (veterinaria.isEmpty())
                    {
                        println("No se ha encontrado ninguna mascota registrada!")
                    } else

                        print("Ingrese el nombre de la mascota a consultar: ")
                        val nombre = readln()
                        // find sirve para buscar la mascota en la lista veterinaria, (it.nombre) sirve para buscar que consida con el nombre ingresado por el usuario
                        // it objeto en la lista veterinaria que es lo mismo it = { mascota -> mascota.nombre == nombre } pero it rd abreviado
                        val mascota = veterinaria.find { it.nombre == nombre }
                        if (mascota != null) {
                            mascota.describirMascota()
                        } else {
                            println("No se encontró una mascota con ese nombre $nombre.")
                        }
                    }
               2->{if (veterinaria.isEmpty())
               {
                   println("No se ha encontrado ninguna mascota registrada!")
               } else
               {

                   println("Mascotas: ")
                   for ((i, Mascota ) in veterinaria.withIndex()) {
                       println("N° ${i + 1}.: Nombre ${Mascota.nombre}, especie${Mascota.especie}, edad${Mascota.edad}, Peso: ${Mascota.peso}}")
                   }
               }

               }
             }
            }
            3 ->{
                    if (consultaMedicas.isEmpty()) {
                        println("No se ha encontrado ningún historial registrado!")
                    } else {print("Ingrese el nombre de la mascota para registrar la consulta: ")
                    val nombre = readln()
                    val mascota = veterinaria.find { it.nombre == nombre }

                    if (mascota != null) {
                        print("Escribir Diagnóstico: ")
                        val diagnostico = readln()
                        print("¿Incluye medicación? (si/no): ")
                        val incluyeMedicacion = readln().toBoolean()

                        val consulta = ConsultaMedica(mascota, diagnostico, incluyeMedicacion)
                        consultaMedicas.add(consulta)
                        println("Consulta registrada correctamente.")
                    } else {
                        println("No se encontró una mascota con el nombre $nombre.")
                    }
                }
            }
            4->{

                    println(
                        """
               Menu 
               1. Consultar Costo de una Consulta
               2. Consultar Todo el Costo de la Consulta
                """.trimIndent()
                    )

                    print("Ingrese la opcion: ")
                    val opc = readln().toInt()
                    when(opc){

                       1->{
                           if (consultaMedicas.isEmpty()) {
                               println("No se ha encontrado ningún historial registrado!")
                           } else {
                           print("Ingrese el nombre de la mascota: ")
                           val nombre = readln()
                           val consultasMascota = consultaMedicas.filter { it.mascota.nombre == nombre }

                           // .lastOrNull() : Obtener el ultimo elemento de la lista
                           val consultaReciente = consultasMascota.lastOrNull()

                           if (consultaReciente != null) {
                               val costoTotal = consultaReciente.calcularCosto()
                               println("El costo de la última consulta para la mascota ${consultaReciente.mascota.nombre} es: $${"%.2f".format(costoTotal)}")
                           } else {
                               println("No se encontraron consultas para la mascota con el nombre: $nombre.")
                           }
                        }

                       }
                       2->{
                           if (consultaMedicas.isEmpty()) {
                               println("No se ha encontrado ningún historial registrado!")
                           } else {
                            print("Ingrese el nombre de la mascota para consultar su costo total de consultas: ")
                            val nombre = readln()

                            // Filtrar en la lista de consulta medicas, la mascota con el nombre ingresado
                            val consultasMascota = consultaMedicas.filter { it.mascota.nombre == nombre }


                            // isNotEmpty = la lista no esta vacia, por lo menos tiene un caracter
                            if (consultasMascota.isNotEmpty()) {
                                // Calcular el costo total de todas las consultas
                                // Llamar a calcularCosto sin parámetros
                                val costoTotal = consultasMascota.sumOf { it.calcularCosto() }
                                println("El costo total de las consultas para la mascota $nombre es: $${"%.2f".format(costoTotal)}")
                            } else {
                                println("No se encontraron consultas para la mascota con el nombre: $nombre.")
                            }
                           }
                       }
                    }
                }
            5->{
                println("El Historial de Consultas")

                if (consultaMedicas.isEmpty()) {
                    println("No se ha encontrado ningún historial registrado!")
                } else {
                    println("Mascotas: ")
                    for ((i, consulta) in consultaMedicas.withIndex())
                        println("N° ${i + 1}. ${consulta.mascota.nombre}, su diagnóstico: ${consulta.diagnosticoMedico} y su costo total: $${"%.1f".format(consulta.calcularCosto())}")
                    }
                }
            }

    } while (opc != 6)

}