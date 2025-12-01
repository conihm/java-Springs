package com.constanzahurtado.login_registro.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.constanzahurtado.login_registro.models.Usuario;

@Repository
public interface RepositorioUsuarios extends CrudRepository<Usuario, Long> {
    
    public Usuario findByEmail(String email);
    
    public Usuario findByNombreUsuario(String nombreUsuario);
}