package aleix.etv.usuario;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> obtenerTodos() {
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public Usuario obtenerPorId(@PathVariable int id) {
        return usuarioService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Void> crear(@RequestBody Usuario usuarioDto) {
        usuarioService.save(usuarioDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Void> actualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
//        usuarioService.update(id, usuario);
//        return ResponseEntity.ok().build();
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable int id) {
        usuarioService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}


