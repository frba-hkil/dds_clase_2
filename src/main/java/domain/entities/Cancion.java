package domain.entities;

import java.time.LocalDateTime;

public class Cancion {
    private String nombre;
    private Album album;
    private Integer cantLikes;
    private Integer cantDislikes;
    private Integer anioLanzamiento;
    private Integer cantReproduccion;
    private LocalDateTime ultimaReproduccion;
    //private ??? popularidad;

    public Cancion(String nombre, Album album, Integer anioLanzamiento) {
        this.cantReproduccion = 0;
        this.cantLikes = 0;
        this.cantDislikes = 0;
        this.nombre = nombre;
        this.album = album;
        this.anioLanzamiento = anioLanzamiento;
    }

    public String serEscuchadada() {
        this.cantReproduccion++;
        this.ultimaReproduccion = LocalDateTime.now();

        //TODO: devolver detalle dependiendo de la popularidad
        return "Detalle completo";
    }
}
