package aleix.etv.usuario;

import lombok.Data;

@Data
public class UsuarioDto {
    private Long id;
    private String nombre;
    private String email;
    private String contraseña;
    private Integer publicaciones;

    public UsuarioDto() {
    }

    public UsuarioDto(Long id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    // Getters y Setters
    // ...

    // Métodos de conversión de DTO a entidad y viceversa
    public static Usuario fromEntity(Usuario usuario) {
        return null;
    }

    public Usuario toEntity() {
        Usuario usuario = new Usuario();
        usuario.setId(this.id);
        usuario.setNombre(this.nombre);
        return usuario;
    }

}
