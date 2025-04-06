package domain.entities;

import java.time.LocalDateTime;

public enum Popularidad {
    NORMAL {
        @Override
        public Icono icono() {
            return Icono.MUSICAL_NOTE;
        }
        @Override
        public String leyenda(Cancion cancion) {
            return cancion.getNombreArtista()
                    + " - "
                    + cancion.getAlbum().getNombre()
                    + " - "
                    + cancion.getNombre();
        }
        @Override
        public Popularidad cambiarPopularidad(Cancion cancion) {
            if(cancion.getCantReproduccion() > 50000 && cancion.getCantLikes() > 20000)
                return TENDENCIA;
            if(cancion.getCantReproduccion() > 1000)
                return AUGE;
            return NORMAL;
        }
    },
    AUGE {
        @Override
        public Icono icono() {
            return Icono.ROCKET;
        }
        @Override
        public String leyenda(Cancion cancion) {
            return cancion.getNombreArtista()
                    + " - "
                    + cancion.getNombre()
                    + "("
                    + cancion.getAlbum().getNombre()
                    + " - "
                    + cancion.getAlbum().getAnio()
                    + ")";
        }
        @Override
        public Popularidad cambiarPopularidad(Cancion cancion) {
            if(cancion.getCantDislikes() > 5000)
                return NORMAL;
            if(cancion.getCantReproduccion() > 50000 && cancion.getCantLikes() > 20000)
                return TENDENCIA;
            return AUGE;
        }
    },
    TENDENCIA {
        @Override
        public Icono icono() {
            return Icono.FIRE;
        }
        @Override
        public String leyenda(Cancion cancion) {
            return cancion.getNombre()
                    + " - "
                    + cancion.getNombreArtista()
                    + "("
                    + cancion.getAlbum().getNombre()
                    + " - "
                    + cancion.getAlbum().getAnio()
                    + ")";
        }
        @Override
        public Popularidad cambiarPopularidad(Cancion cancion) {
            if(LocalDateTime.now().minusHours(24).isAfter(cancion.getUltimaReproduccion()))
                return NORMAL;
            return TENDENCIA;
        }
    };

    public abstract Icono icono();
    public abstract String leyenda(Cancion cancion);
    public abstract Popularidad cambiarPopularidad(Cancion cancion);

}
