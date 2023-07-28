package Entidad;

public class Pelicula {

    private String titulo;
    private String director;
    private Integer duracionMinutos;

    public Pelicula(String titulo, String director, Integer duracionMinutos) {
        this.titulo = titulo;
        this.director = director;
        this.duracionMinutos = duracionMinutos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionHoras(Integer duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    @Override
    public String toString() {
        return "\n" + titulo + " de " + director + ", duracion: " + duracionMinutos + " minutos";
    }

}
