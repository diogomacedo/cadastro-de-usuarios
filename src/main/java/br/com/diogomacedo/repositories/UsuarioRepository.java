package br.com.diogomacedo.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.diogomacedo.entities.UsuarioEntity;

@Repository
public interface UsuarioRepository extends PagingAndSortingRepository<UsuarioEntity, Long> {

}
