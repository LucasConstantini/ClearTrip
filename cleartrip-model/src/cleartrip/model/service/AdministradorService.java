package cleartrip.model.service;

import cleartrip.model.ConnectionManager;
import cleartrip.model.base.service.BaseAdministradorService;
import cleartrip.model.dao.UsuarioDAO;
import cleartrip.model.pojo.Administrador;
import cleartrip.model.pojo.Usuario;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdministradorService implements BaseAdministradorService {

    @Override
    public void create(Administrador pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            UsuarioDAO dao = new UsuarioDAO();
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
    public Administrador readById(Long login) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        Administrador administrador = null;
        try {
            UsuarioDAO dao = new UsuarioDAO();
            administrador = (Administrador) dao.readById(login, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
        return administrador;
    }

    @Override
    public List<Administrador> readByCriteria(Map<String, Object> criteria) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<Usuario> lista = null;
        try {
            UsuarioDAO dao = new UsuarioDAO();
            criteria.put(UsuarioDAO.CRITERION_TIPO_EQ, UsuarioDAO.TIPO_ADMINISTRADOR);
            lista = dao.readByCriteria(criteria, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
        return (List) lista;
    }

    @Override
    public void update(Administrador pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            UsuarioDAO dao = new UsuarioDAO();
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
    public void delete(Long login) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            UsuarioDAO dao = new UsuarioDAO();
            dao.delete(login, conn);
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
            Integer login = (Integer) properties.get("login");
            String senha = (String) properties.get("senha");
            String emailInstitucional = (String) properties.get("emailInstitucional");
            String celInstitucional = (String) properties.get("celInstitucional");
            String telInstitucional = (String) properties.get("telInstitucional");
            String tipo = (String) properties.get("tipo");

            if (nome == null || nome.isEmpty()) {
                errors.put("nome", "Campo obrigatório!");
            }
            if (login == null || login < 0) {
                errors.put("login", "Campo obrigatório!");
            }
            if (senha == null || senha.isEmpty()) {
                errors.put("senha", "Campo obrigatório!");
            }
            if (emailInstitucional == null || emailInstitucional.isEmpty()) {
                errors.put("emailInstitucional", "Campo obrigatório!");
            }
            if (celInstitucional == null || celInstitucional.isEmpty()) {
                errors.put("celInstitucional", "Campo obrigatório!");
            }
            if (telInstitucional == null || telInstitucional.isEmpty()) {
                errors.put("telInstitucional", "Campo obrigatório!");
            }
            if (tipo == null || tipo.isEmpty()) {
                errors.put("tipo", "Campo obrigatório!");
            }
        }
        return errors;
    }

    @Override
    public Map<String, String> validateForUpdate(Map<String, Object> properties) throws Exception {
        return this.validateForCreate(properties);
    }
}
