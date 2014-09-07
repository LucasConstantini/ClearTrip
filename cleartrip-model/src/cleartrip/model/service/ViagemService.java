package cleartrip.model.service;

import cleartrip.model.ConnectionManager;
import cleartrip.model.base.service.BaseViagemService;
import cleartrip.model.dao.ViagemDAO;
import cleartrip.model.pojo.Viagem;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViagemService implements BaseViagemService {

    @Override
    public void create(Viagem pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            ViagemDAO dao = new ViagemDAO();
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
    public Viagem readById(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        Viagem disciplina = null;
        try {
            ViagemDAO dao = new ViagemDAO();
            disciplina = dao.readById(id, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
        return disciplina;
    }

    @Override
    public List<Viagem> readByCriteria(Map<String, Object> criteria) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<Viagem> lista = null;
        try {
            ViagemDAO dao = new ViagemDAO();
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
    public void update(Viagem pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            ViagemDAO dao = new ViagemDAO();
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
            ViagemDAO dao = new ViagemDAO();
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
        Map<String, String> errors = new HashMap<String, String>();
        if (properties != null) {
            String nome = (String) properties.get("nome");
            if (nome == null || nome.isEmpty()) {
                errors.put("nome", "Campo obrigatório!");
            }
            Long curso = (Long) properties.get("curso.id");
            if (curso <= 0){
                errors.put("curso", "Selecione um curso!");
            }
        }
        return errors;
    }

    @Override
    public Map<String, String> validateForUpdate(Map<String, Object> properties) throws Exception {
        return this.validateForCreate(properties);
    }
}