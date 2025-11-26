package com.constanza.mi_primer_proyecto_spring_boot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.constanza.mi_primer_proyecto_spring_boot.models.Usuario;
import java.util.Optional;


@Repository
public interface RepositorioUsuarios extends CrudRepository <Usuario, Long>{
    
    Optional<Usuario> findByEmail(String email);

}
