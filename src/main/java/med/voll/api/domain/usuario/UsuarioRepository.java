package med.voll.api.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    // Metodo que vai fazer a consulta no banco de dados atraves do login
    UserDetails findByLogin(String login);
}
