package domain.entities;

public class Album {
    private String nombre;
    private Artista artista;
    private int anio;

    public Album(String nombre, Artista artista, int anio) {
        this.nombre = nombre;
        this.artista = artista;
        this.anio = anio;
    }

    public String getNombre() {
        return nombre;
    }

    public Artista getArtista() {
        return artista;
    }

    public int getAnio() {
        return anio;
    }
}
