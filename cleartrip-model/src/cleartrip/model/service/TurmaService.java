package cleartrip.model.service;

import cleartrip.model.ConnectionManager;
import cleartrip.model.base.service.BaseDespesaService;
import cleartrip.model.dao.DespesaDAO;
import cleartrip.model.pojo.Despesa;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TurmaService implements BaseDespesaService {

    @Override
    public void create(Despesa pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            DespesaDAO dao = new DespesaDAO();
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
    public Despesa readById(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        Despesa turma = null;
        try {
            DespesaDAO dao = new DespesaDAO();
            turma = dao.readById(id, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
        return turma;
    }

    @Override
    public List<Despesa> readByCriteria(Map<String, Object> criteria) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<Despesa> lista = new ArrayList<Despesa>();
        try {
            DespesaDAO dao = new DespesaDAO();
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
    public void update(Despesa pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            DespesaDAO dao = new DespesaDAO();
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
            DespesaDAO dao = new DespesaDAO();
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
        Map<String, String> erros = new HashMap<String, String>();
        String nome = (String) properties.get("nome");
        if (nome == null || nome.isEmpty()) {
            erros.put("nome", "Campo Obrigatório!");
        }
        return erros;
    }

    @Override
    public Map<String, String> validateForUpdate(Map<String, Object> properties) throws Exception {
        return this.validateForCreate(properties);
    }
}
