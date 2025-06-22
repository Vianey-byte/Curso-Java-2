package Sesion3.Reto2;
import java.util.*;
import java.util.stream.*;

public class ProcesadorEncuestas {

    public static void main(String[] args) {
        // Datos de ejemplo
        List<Encuesta> encuestasCentro = List.of(
            new Encuesta("Ana", "El tiempo de espera fue largo", 2),
            new Encuesta("Luis", null, 5),
            new Encuesta("Carlos", "No me atendieron bien", 3)
        );

        List<Encuesta> encuestasNorte = List.of(
            new Encuesta("Marta", "La atención fue buena, pero la limpieza puede mejorar", 3),
            new Encuesta("Pedro", null, 2),
            new Encuesta("Laura", "Todo estuvo excelente", 5)
        );

        List<Sucursal> sucursales = List.of(
            new Sucursal("Centro", encuestasCentro),
            new Sucursal("Norte", encuestasNorte)
        );

        // Procesamiento con Stream API
        List<String> mensajes = sucursales.stream()
            .flatMap(sucursal -> 
                sucursal.getEncuestas().stream()
                    .filter(encuesta -> encuesta.getCalificacion() <= 3)
                    .flatMap(encuesta -> encuesta.getComentario()
                        .map(comentario -> 
                            Stream.of("Sucursal " + sucursal.getNombre() + 
                                      ": Seguimiento a paciente con comentario: \"" + comentario + "\""))
                        .orElseGet(Stream::empty))
            )
            .collect(Collectors.toList());

        // Mostrar resultados
        mensajes.forEach(System.out::println);
    }
}

