package cleartrip.model.service;

import cleartrip.model.ConnectionManager;
import cleartrip.model.base.service.BaseTransporteService;
import cleartrip.model.dao.TransporteDAO;
import cleartrip.model.pojo.Transporte;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransporteService implements BaseTransporteService {

    @Override
    public void create(Transporte pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();

        try {
            TransporteDAO dao = new TransporteDAO();
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
    public Transporte readById(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        Transporte transporte = null;
        try {
            TransporteDAO dao = new TransporteDAO();
            transporte = dao.readById(id, conn);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
        return transporte;
    }

    @Override
    public List<Transporte> readByCriteria(Map<String, Object> criteria) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<Transporte> lista = null;
        try {
            TransporteDAO dao = new TransporteDAO();
            lista = dao.readByCriteria(criteria, conn);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
        return lista;
    }

    @Override
    public void update(Transporte pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            TransporteDAO dao = new TransporteDAO();
            dao.update(pojo, conn);
            conn.commit();
            
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
            TransporteDAO dao = new TransporteDAO();
            dao.delete(id, conn);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
    }

    @Override
    public Map<String, String> validateForCreate(Map<String, Object> properties) throws Exception {
        Map<String, String> error = new HashMap<>();
        if (properties != null) {
            String nome = (String) properties.get("nome");
            if (nome == null || nome.isEmpty()) {
                error.put("nome", "Campo obrigatório!");
            }
        }
        return error;
    }

    @Override
    public Map<String, String> validateForUpdate(Map<String, Object> properties) throws Exception {
        return this.validateForCreate(properties);
    }

}
