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
    private Popularidad popularidad;

    public void setCantLikes(Integer cantLikes) {
        this.cantLikes = cantLikes;
    }

    public void setCantDislikes(Integer cantDislikes) {
        this.cantDislikes = cantDislikes;
    }

    public void setCantReproduccion(Integer cantReproduccion) {
        this.cantReproduccion = cantReproduccion;
    }

    public void setUltimaReproduccion(LocalDateTime ultimaReproduccion) {
        this.ultimaReproduccion = ultimaReproduccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombreArtista() {
        return album.getArtista().getNombre();
    }

    public Album getAlbum() {
        return album;
    }

    public Integer getCantLikes() {
        return cantLikes;
    }

    public Integer getCantDislikes() {
        return cantDislikes;
    }

    public Integer getCantReproduccion() {
        return cantReproduccion;
    }

    public LocalDateTime getUltimaReproduccion() {
        return ultimaReproduccion;
    }

    public Popularidad getPopularidad() {
        return popularidad;
    }

    public Cancion(String nombre, Album album, Integer anioLanzamiento) {
        this.cantReproduccion = 0;
        this.cantLikes = 0;
        this.cantDislikes = 0;
        this.nombre = nombre;
        this.album = album;
        this.anioLanzamiento = anioLanzamiento;
        this.popularidad = Popularidad.NORMAL;
    }

    public void cambiarPopularidad() {
        popularidad = popularidad.cambiarPopularidad(this);
    }

    public String serEscuchadada() {
        this.cantReproduccion++;
        this.ultimaReproduccion = LocalDateTime.now();

        cambiarPopularidad();

        return popularidad.icono() + popularidad.leyenda(this);
    }
}
