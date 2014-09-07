package cleartrip.model.service;

import cleartrip.model.ConnectionManager;
import cleartrip.model.base.service.BaseCategoriaDespesaService;
import cleartrip.model.dao.CategoriaDespesaDAO;
import cleartrip.model.pojo.CategoriaDespesa;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoriaDespesaService implements BaseCategoriaDespesaService {

    @Override
    public void create(CategoriaDespesa pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            CategoriaDespesaDAO dao = new CategoriaDespesaDAO();
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
    public CategoriaDespesa readById(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        CategoriaDespesa software = new CategoriaDespesa();;
        try {
            CategoriaDespesaDAO dao = new CategoriaDespesaDAO();
            software = dao.readById(id, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
        return software;
    }

    @Override
    public List<CategoriaDespesa> readByCriteria(Map<String, Object> criteria) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<CategoriaDespesa> lista = null;
        try {
            CategoriaDespesaDAO dao = new CategoriaDespesaDAO();
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
    public void update(CategoriaDespesa pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            CategoriaDespesaDAO dao = new CategoriaDespesaDAO();
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
            CategoriaDespesaDAO dao = new CategoriaDespesaDAO();
            dao.delete(id, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
    }

    @Override
    public Map<String, String> validateForCreate(Map<String, Object> properties) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        Map<String, String> erros = new HashMap<String, String>();
        if (properties != null) {
            String nome = (String) properties.get("nome");
            if (nome == null || nome.isEmpty()) {
                erros.put("nome", "Campo obrigatório!");
            }
        }
        return erros;
    }

    @Override
    public Map<String, String> validateForUpdate(Map<String, Object> properties) throws Exception {
        return this.validateForCreate(properties);
    }
}
