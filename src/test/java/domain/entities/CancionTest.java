package domain.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

class CancionTest {

    Artista artista;
    Album album;
    Cancion cancion;

    @BeforeEach
    void initColdplay() {
        artista = new Artista("Coldplay");
        album = new Album("A Rush of Blood to the head", artista, 2002);
        cancion = new Cancion("The Scientist", album, 2002);
    }

    @Test
    @DisplayName("Se lanza una nueva cancion \"The Scientist\"")
    public void lanzarNuevaCancion() {

        Assertions.assertInstanceOf(Cancion.class, cancion);
        Assertions.assertEquals("The Scientist", cancion.getNombre());
        Assertions.assertEquals("Coldplay", cancion.getNombreArtista());
    }
    @Test
    @DisplayName("The Scientist pasa a estar en auge por 10001 reproducciones")
    public void ponerEnAuge() {
        cancion.setCantReproduccion(10000);
        String detalle = cancion.serEscuchadada();

        Assertions.assertEquals(10001, cancion.getCantReproduccion());
        Assertions.assertEquals(Popularidad.AUGE, cancion.getPopularidad());
    }
    @Test
    @DisplayName("The Scientist pasa de auge a normal por llegar a 5001 dislikes")
    public void ponerEnAugeANormal() {
        cancion.setCantReproduccion(10000);
        String detalle = cancion.serEscuchadada();

        Assertions.assertEquals(Popularidad.AUGE, cancion.getPopularidad());

        cancion.setCantDislikes(5001);
        detalle = cancion.serEscuchadada();
        Assertions.assertEquals(Popularidad.NORMAL, cancion.getPopularidad());
    }

    @Test
    @DisplayName("The Scientist pasa a estar en tendencia por 50001 reproducciones y 20001 likes")
    public void ponerTendencia() {
        cancion.setCantLikes(20001);
        cancion.setCantReproduccion(50001);
        String detalle = cancion.serEscuchadada();

        Assertions.assertEquals(Popularidad.TENDENCIA, cancion.getPopularidad());
    }
    @Test
    @DisplayName("The Scientist pasa de tendencia a normal por no ser escuchada en las ultimas 24 horas")
    public void ponerTendenciaANormal() {
        cancion.setCantLikes(20001);
        cancion.setCantReproduccion(50001);
        String detalle = cancion.serEscuchadada();

        Assertions.assertEquals(Popularidad.TENDENCIA, cancion.getPopularidad());

        cancion.setUltimaReproduccion(LocalDateTime.now().minusHours(25));
        cancion.cambiarPopularidad();
        Assertions.assertEquals(Popularidad.NORMAL, cancion.getPopularidad());
    }
}