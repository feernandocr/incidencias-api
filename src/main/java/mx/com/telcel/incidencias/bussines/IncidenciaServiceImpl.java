package mx.com.telcel.incidencias.bussines;

import mx.com.telcel.incidencias.model.entity.IncidenciaEntity;
import mx.com.telcel.incidencias.model.dao.IncidenciaDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidenciaServiceImpl implements IncidenciaService{

    Logger log = LogManager.getLogger(IncidenciaServiceImpl.class);
    @Autowired
    IncidenciaDao incidenciaDao;


    @Override
    public boolean createIncidencia(IncidenciaEntity toEntity) {
        IncidenciaEntity entityTemp = incidenciaDao.save(toEntity);
        if (entityTemp != null){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteIncidencia(int idIncidencia) {
        /*Validando si existe la incidencia*/
        Boolean isExiste = incidenciaDao.findById(idIncidencia).isPresent();
        if (isExiste){
            /*Si existe se procede a eliminar*/
            incidenciaDao.deleteById(idIncidencia);
            /*Se vuelve a buscar si ya se elimino*/
            Boolean isDelete = incidenciaDao.findById(idIncidencia).isPresent();
            if (isDelete){
                log.info("SE ELIMINO CORRECTAMENTE LA INCIDENCIA "+ idIncidencia);
                return true;
            }else
                return false;
        }else {
            /*se regresa false ya que no existe*/
            log.error("NO EXISTE LA INCIDENCIA");
            return false;
        }
    }

    @Override
    public List<IncidenciaEntity> getAllIncidencias() {
        return (List<IncidenciaEntity>) incidenciaDao.findAll();
    }

    @Override
    public IncidenciaEntity updateIncidencia(IncidenciaEntity incidencia) {
        return incidenciaDao.save(incidencia);
    }

}
