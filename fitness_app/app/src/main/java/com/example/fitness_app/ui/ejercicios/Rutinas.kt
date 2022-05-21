package com.example.fitness_app.ui.ejercicios

import com.example.fitness_app.R

class Rutinas {



    companion object{
        val abdominales = listOf<Ejercicio>(
            Ejercicio("Saltos de tijeras","00:20", R.raw.saltode,false,false),
            Ejercicio("Crunch Abdominales","x16", R.raw.crunch_abdominales,false,false),
            Ejercicio("Twist Ruso","x20", R.raw.twist_ruso,false,false),
            Ejercicio("Escalada de montaña","x16", R.raw.escalada,false,false),
            Ejercicio("Elevaciones de Piernas","x16", R.raw.elevaciones_de_piernas,false,false),
            Ejercicio("Toque al Talon","x20", R.raw.toque_al_talon,false,false),
            Ejercicio("Tablon","00:20", R.raw.tablon,false,false),
            Ejercicio("Estiramiento de cobra","00:30", R.raw.esterinamiento_de_cobra,false,false)
        )

        val pecho = listOf<Ejercicio>(
            Ejercicio("Saltos de tijeras","00:30", R.raw.saltode,false,false),
            Ejercicio("Flexiones con Inclinacion","x6", R.raw.flexiones_con_inclinacion,false,false),
            Ejercicio("Flexiones","X4", R.raw.flexiones,false,false),
            Ejercicio("Flexiones con Brazos Abiertos","x4", R.raw.flexiones_con_brazos_abiertos,false,false),
            Ejercicio("Flexiones con Inclinacion","x4", R.raw.flexiones_con_inclinacion,false,false),
            Ejercicio("Triceps en silla","x4", R.raw.tricep_en_silla,false,false),
            Ejercicio("Flexiones con Apoyo de Rodilla ","x4", R.raw.flexiones_con_apoyo_de_rodillas,false,false),
            Ejercicio("Estiramiento de Cobra","00:20", R.raw.esterinamiento_de_cobra,false,false),
            Ejercicio("Estiramiento de Pecho","00:20", R.raw.estiramiento_de_pecho,false,false)
        )

        val brazos = listOf<Ejercicio>(
            Ejercicio("Elevaciones de Brazos","00:30", R.raw.elevaciones_de_brazos,false,false),
            Ejercicio("Elevaciones Laterales de Brazos","00:30", R.raw.elevaciones_laterales_de_brazos,false,false),
            Ejercicio("Triceps en Silla","x10", R.raw.tricep_en_silla,false,false),
            Ejercicio("Circulos con los Brazos","00:30", R.raw.circulos_con_los_brazos,false,false),
            Ejercicio("Flexiones en Diamante","x6", R.raw.flexiones_en_diamante,false,false),
            Ejercicio("Saltos de Tijera","00:30", R.raw.saltode,false,false),
            Ejercicio("Presiones de Brazos Sobre Pecho","00:16", R.raw.presiones_de_brazos_sobre_pecho,false,false),
            Ejercicio("Flexiones de biceps izquierdo con pierna como barra","x8", R.raw.flexiones_de_biceps_derecho,false,false),
            Ejercicio("Flexiones de biceps derecho con pierna como barra","x8", R.raw.flexiones_de_biceps_izquierdo_con_pierna,false,false),
            Ejercicio("Placha Diagonal","x10", R.raw.plancha_diagonal,false,false),
            Ejercicio("Puñetazos","00:30", R.raw.punetazos,false,false),
            Ejercicio("Flexiones","x10", R.raw.flexiones,false,false),
            Ejercicio("Inchworms","x8", R.raw.inchworms,false,false),
            Ejercicio("Flexiones en la Pared","x12", R.raw.flexiones_en_la_pared,false,false),
            Ejercicio("Estiramiento de triceps izquierdo","00:30", R.raw.estiramiento_de_triceps_izquierdo,false,false),
            Ejercicio("Estiramiento de triceps derecho","00:30", R.raw.estiramiento_de_triceps_derecho,false,false),
            Ejercicio("Estiramiento de biceps en pie brazo izquierdo","00:30", R.raw.estiramiento_de_biceps_en_pie_brazo_izquierdo,false,false),
            Ejercicio("Estiramiento de biceps en pie brazo derecho","00:30", R.raw.estiramiento_de_biceps_en_pie_brazo_derecho,false,false),
        )

        val piernas = listOf<Ejercicio>(
            Ejercicio("Salto Lateral","00:30", R.raw.salto_lateral),
            Ejercicio("Squats","x12", R.raw.squats),
            Ejercicio("Levantamiento de Pierna Lateral Izquierda","x12", R.raw.levantamiento_de_pierna_lateral_izquierda),
            Ejercicio("Levantamiento de Pierna Lateral Derecha","x12", R.raw.levantamiento_de_pierna_lateral_derecha),
            Ejercicio("Estocada Hacia Atras","x14", R.raw.estocada_hacia_atras),
            Ejercicio("Donkey Kicks Izquierdo","x16", R.raw.donkey_kicks_izquierdo),
            Ejercicio("Donkey Kicks Derecho","x16", R.raw.donkey_kicks_derecha),
            Ejercicio("Estiramiento de cuadriceps izquierdo con pared","00:30", R.raw.estiramiento_de_cuadriceps_izquierdo_con_pared),
            Ejercicio("Estiramiento de cuadriceps derecho con pared","00:30", R.raw.estiramiento_de_cuadriceps_derecho_con_pared),
            Ejercicio("Estiramiento de rodilla izquierda al pecho","00:30", R.raw.estiramiento_de_rodilla_izquierda_al_pecho),
            Ejercicio("Estiramiento de rodilla derecha al pecho","00:30", R.raw.estiramiento_de_rodilla_izquierda_al_pecho),
            Ejercicio("Levantamiento de pantorrilla con pared","x12", R.raw.levantamientos_de_pantorrilla_con_pared),
            Ejercicio("Levantamiento de patorrilla con sentadilla de sumo en pared","x12", R.raw.levantamientos_de_pantorrillas_con_sentadilla_sumo),
            Ejercicio("Estiramiento de pantorrilla izquierda","00:30", R.raw.estiramiento_de_pantorrilla_izquierda),
            Ejercicio("Estiramiento de pantorrilla derecha","00:30", R.raw.estiramiento_de_patorrilla_derecha),
        )


        val rutinas = listOf<Rutina>(
            Rutina("Abdominales", R.drawable.abdominales1, abdominales,150,6),
            Rutina("Pecho", R.drawable.pecho, pecho,250,20),
            Rutina("Brazos", R.drawable.brazo, brazos,350,20),
            Rutina("Piernas", R.drawable.piernas, piernas,450,20),
        )
    }
}