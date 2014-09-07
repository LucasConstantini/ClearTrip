package cleartrip.model.service;

import cleartrip.model.ConnectionManager;
import cleartrip.model.base.service.BaseEmpresaService;
import cleartrip.model.dao.EmpresaDAO;
import cleartrip.model.pojo.Empresa;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmpresaService implements BaseEmpresaService {

    @Override
    public void create(Empresa pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            EmpresaDAO dao = new EmpresaDAO();
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
    public Empresa readById(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        Empresa curso = null;
        try {
            EmpresaDAO dao = new EmpresaDAO();
            curso = dao.readById(id, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
        return curso;
    }

    @Override
    public List<Empresa> readByCriteria(Map<String, Object> criteria) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<Empresa> lista = null;
        try {
            EmpresaDAO dao = new EmpresaDAO();
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
    public void update(Empresa pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            EmpresaDAO dao = new EmpresaDAO();
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
            EmpresaDAO dao = new EmpresaDAO();
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
            String suaString = nome;
            suaString = suaString.toLowerCase();
            if (nome == null || nome.isEmpty()) {
                errors.put("nome", "Informe um nome!");
            }
        }
        return errors;
    }

    @Override
    public Map<String, String> validateForUpdate(Map<String, Object> properties) throws Exception {
        return this.validateForCreate(properties);
    }
}
