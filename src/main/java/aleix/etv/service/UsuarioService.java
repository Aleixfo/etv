package aleix.etv.service;

import aleix.etv.entity.UsuarioEntity;

import java.util.List;

public interface UsuarioService {

    UsuarioEntity create(UsuarioEntity usuario);

    UsuarioEntity update(UsuarioEntity usuario);

    UsuarioEntity getById(Integer id);

    List<UsuarioEntity> getAll();

    void delete(Integer id);
}
