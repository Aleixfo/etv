package aleix.etv.usuario;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final JdbcTemplate jdbcTemplate;

    public UsuarioServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Usuario> findAll() {
        String sql = "SELECT * FROM usuarios";
        return jdbcTemplate.query(sql, new UsuarioRowMapper());
    }

    @Override
    public Usuario findById(int id) {
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new UsuarioRowMapper());
    }

    @Override
    public Usuario save(Usuario usuarioDTO) {
        String sql = "INSERT INTO usuarios (nombre, email, contraseña, publicaciones) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, usuarioDTO.getNombre(), usuarioDTO.getEmail(), usuarioDTO.getContraseña());
        return usuarioDTO;
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public class UsuarioRowMapper implements RowMapper<Usuario> {
        @Override
        public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
            Usuario usuarioDTO = new Usuario();
            usuarioDTO.setId((long) rs.getInt("id"));
            usuarioDTO.setNombre(rs.getString("nombre"));
            usuarioDTO.setEmail(rs.getString("email"));
            return usuarioDTO;
        }
    }


}