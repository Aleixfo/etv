package aleix.etv.serviceimpl;

import aleix.etv.entity.UsuarioEntity;
import aleix.etv.entity.UsuarioRepository;
import aleix.etv.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UsuarioEntity create(UsuarioEntity usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioEntity update(UsuarioEntity usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioEntity getById(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public List<UsuarioEntity> getAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
