package cleartrip.model.service;

import cleartrip.model.ConnectionManager;
import cleartrip.model.base.service.BaseParametroService;
import cleartrip.model.dao.ParametroDAO;
import cleartrip.model.pojo.Parametros;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParametroService implements BaseParametroService {

    @Override
    public void create(Parametros pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            ParametroDAO dao = new ParametroDAO();
            dao.create(pojo, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
    }

    @Override
    public Parametros readById(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        Parametros evento = null;
        try {
            ParametroDAO dao = new ParametroDAO();
            evento = dao.readById(id, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
        return evento;
    }

    @Override
    public List<Parametros> readByCriteria(Map<String, Object> criteria) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<Parametros> lista = null;
        try {
            ParametroDAO dao = new ParametroDAO();
            lista = dao.readByCriteria(criteria, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
        return lista;
    }

    @Override
    public void update(Parametros pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            ParametroDAO dao = new ParametroDAO();
            dao.update(pojo, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            ParametroDAO dao = new ParametroDAO();
            dao.delete(id, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
    }

    
    //FALTA IMPLEMENTAR AQUI AINDA
    @Override
    public Map<String, String> validateForCreate(Map<String, Object> properties) throws Exception {
        Map<String, String> erros = new HashMap<String, String>();
        return erros;
    }

    @Override
    public Map<String, String> validateForUpdate(Map<String, Object> properties) throws Exception {
        return this.validateForCreate(properties);
    }
}
