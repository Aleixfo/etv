package aleix.etv.usuario;

import java.util.List;

/**
 En la interfaz UsuarioService, defines los métodos que deseas utilizar
 para interactuar con los usuarios. En este ejemplo, se han agregado algunos
 métodos comunes como guardarUsuario para guardar un usuario en la base de
 datos, obtenerUsuarioPorId para obtener un usuario por su ID, obtenerTodosLosUsuarios
 para obtener todos los usuarios y eliminarUsuario para eliminar un usuario por su ID.

 Puedes agregar métodos adicionales según tus necesidades, como métodos para
 actualizar usuarios, buscar usuarios por correo electrónico u otras
 consultas personalizadas.

 @author Aleix Font

 */

import java.util.List;

public interface UsuarioService {
    List<Usuario> findAll();
    Usuario findById(int id);
    Usuario save(Usuario usuario);
    void deleteById(int id);
}

