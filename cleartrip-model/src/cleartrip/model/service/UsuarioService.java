package cleartrip.model.service;

import cleartrip.model.ConnectionManager;
import cleartrip.model.base.service.BaseUsuarioService;
import cleartrip.model.dao.UsuarioDAO;
import cleartrip.model.pojo.Usuario;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsuarioService implements BaseUsuarioService {

    //login
    @Override
    public Usuario login(String usuario, String senha) {
        Usuario usuarioLogado = null;
        try {
            Connection conn = ConnectionManager.getInstance().getConnection();
            UsuarioDAO dao = new UsuarioDAO();
            Map<String, Object> criteria = new HashMap<String, Object>();
            criteria.put(UsuarioDAO.CRITERION_USUARIO_EQ, usuario);
            criteria.put(UsuarioDAO.CRITERION_SENHA_EQ, senha);
            List<Usuario> usuarios = dao.readByCriteria(criteria, conn);
            
            if (usuarios != null && usuarios.size() == 1) {
                System.out.println("cheguei aqui");
                usuarioLogado = usuarios.get(0);
                if (!usuarioLogado.getLogin().equals(usuario)) {
                    usuarioLogado = null;
                } else {
                    if (!usuarioLogado.getSenha().equals(senha)) {
                        usuarioLogado = null;
                    }
                }
            }
            
            conn.close();
        } catch (Exception e) {
        }
        return usuarioLogado;
    }

    @Override
    public void create(Usuario pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            UsuarioDAO dao = new UsuarioDAO();//DAO -Data Access Object
            dao.create(pojo, conn);
            conn.commit();
            conn.close();//fecha a conexão para liberar a conexão para o próximo que for usar
        } catch (Exception e) {
            conn.rollback();//desfaz os comando efetuados no banco de dados
            conn.close();
            throw e;//avisar que deu erro
        }

    }

    @Override
    public Map<String, String> validateForCreate(Map<String, Object> properties) throws Exception {
        Map<String, String> errors = new HashMap<String, String>();
        if (properties != null) {
            String nome = (String) properties.get("nome");
            Long login = (Long) properties.get("login");
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
            } else {
                if (senha.length() < 4 || senha.length() > 8) {
                    errors.put("senhaTamanho", "A senha deve conter no mínimo 4 e no máximo 8 caracteres!");
                }
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
        }
        return errors;
    }

    @Override
    public Map<String, String> validateForUpdate(Map<String, Object> properties) throws Exception {
        return this.validateForCreate(properties);
    }

    @Override
    public Usuario readById(Long login) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        Usuario usuario = null;
        try {
            UsuarioDAO dao = new UsuarioDAO();
            usuario = dao.readById(login, conn);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
        return usuario;
    }

    @Override
    public List<Usuario> readByCriteria(Map<String, Object> criteria) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<Usuario> lista = null;
        try {
            UsuarioDAO dao = new UsuarioDAO();
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
    public void update(Usuario pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            UsuarioDAO dao = new UsuarioDAO();
            dao.update(pojo, conn);
            conn.commit();
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
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }

    }

    @Override
    public String encode(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            return number.toString(16);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}