package mx.com.telcel.incidencias.bussines;

import mx.com.telcel.incidencias.model.entity.IncidenciaEntity;

import java.util.List;

public interface IncidenciaService {

    public boolean createIncidencia(IncidenciaEntity toEntity);

    public boolean deleteIncidencia(int idIncidencia);

    public List<IncidenciaEntity> getAllIncidencias();

    public IncidenciaEntity updateIncidencia(IncidenciaEntity incidencia);

}
