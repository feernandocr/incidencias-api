package mx.com.telcel.incidencias.model.dao;

import mx.com.telcel.incidencias.model.entity.IncidenciaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IncidenciaDao extends CrudRepository<IncidenciaEntity, Integer> {
}
