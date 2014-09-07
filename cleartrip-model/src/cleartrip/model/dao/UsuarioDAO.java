package cleartrip.model.dao;

import cleartrip.model.base.BaseDAO;
import cleartrip.model.pojo.Administrador;
import cleartrip.model.pojo.Empresa;
import cleartrip.model.pojo.Financeiro;
import cleartrip.model.pojo.Solicitante;
import cleartrip.model.pojo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UsuarioDAO implements BaseDAO<Usuario> {

    public static final String TIPO_SOLICITANTE = "Solicitante";
    public static final String TIPO_FINANCEIRO = "Financeiro";
    public static final String TIPO_ADMINISTRADOR = "Administrador";
    
    public static final String CRITERION_TIPO_EQ = "1";
    public static final String CRITERION_NOME_I_LIKE = "2";
    public static final String CRITERION_USUARIO_EQ = "3";
    public static final String CRITERION_SENHA_EQ = "4";

    @Override
    public void create(Usuario e, Connection conn) throws Exception {
        String sql = "INSERT INTO usuario (tipo, login, senha, nome, cpf, rg, email_Corporativo, telefone_corporativo, email_pessoal, telefone_pessoal, empresa_fk) VALUES(?,?,?,?,?,?,?,?,?,?,?) RETURNING login;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, e.getTipo());
        ps.setLong(++i, e.getLogin());
        ps.setString(++i, e.getSenha());
        ps.setString(++i, e.getNome());
        ps.setString(++i, e.getCpf());
        ps.setString(++i, e.getRg());
        ps.setString(++i, e.getEmailCorporativo());
        ps.setString(++i, e.getTelefoneCorporativo());
        //para campos não obrigatórios 
        if (e.getEmailPessoal() != null) {
            ps.setString(++i, e.getEmailPessoal());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }
        //para campos não obrigatórios 
        if (e.getTelefonePessoal()!= null) {
            ps.setString(++i, e.getTelefonePessoal());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }
        ps.setLong(++i, e.getEmpresa().getId());
        

        ps.execute();
        ps.close();

    }

    @Override
    public Usuario readById(Long login, Connection conn) throws Exception {
        Usuario e = null;
        String sql = "SELECT usuario.*, empresa.id as empresa_id, empresa.nome as empresa_nome FROM empresa right join usuario on usuario.empresa_fk = empresa_id where usuario.login=?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, login);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {

            String tipo = rs.getString("tipo");
            if (tipo.equalsIgnoreCase(TIPO_ADMINISTRADOR)) {
                e = new Administrador();
            } else if (tipo.equalsIgnoreCase(TIPO_FINANCEIRO)) {
                e = new Financeiro();
            } else {
                e = new Solicitante();
            }
            
            e.setTipo(rs.getString("tipo"));
            e.setLogin(rs.getLong("login"));
            e.setSenha(rs.getString("senha"));
            e.setNome(rs.getString("nome"));
            e.setEmailCorporativo(rs.getString("email_corporativo"));
            e.setEmailPessoal(rs.getString("email_pessoal"));
            e.setTelefoneCorporativo(rs.getString("telefone_corporativo"));
            e.setTelefonePessoal(rs.getString("telefone_pessoal"));
            
            //empresa
            Empresa empresa = new Empresa();
            empresa.setId(rs.getLong("empresa_id"));
            empresa.setNome(rs.getString("empresa_nome"));
            e.setEmpresa(empresa);

        }
        rs.close();
        ps.close();
        return e;
    }

    @Override
    public List<Usuario> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        List<Usuario> lista = new ArrayList<Usuario>();
        String sql = "SELECT usuario.tipo,usuario.login,usuario.senha,usuario.nome,usuario.cpf,usuario.rg,usuario.email_corporativo,usuario.email_pessoal,usuario.telefone_corporativo,usuario.telefone_pessoal, empresa.id as empresa_id, empresa.nome as empresa_nome FROM empresa right join usuario on usuario.empresa_fk = empresa.id WHERE 1=1";

        String criterionTipoEq = (String) criteria.get(CRITERION_TIPO_EQ);
        if (criterionTipoEq != null && !criterionTipoEq.trim().isEmpty()) {
            sql += " AND tipo = '" + criterionTipoEq + "'";
        }

        Long criterionUsuarioEq = (Long) criteria.get(CRITERION_USUARIO_EQ);
        if (criterionUsuarioEq != null && criterionUsuarioEq > 0) {
            sql += " AND login = " + criterionUsuarioEq;
        }

        //Pesquisa por nome do usuário
        String criterionNomeILike = (String) criteria.get(CRITERION_NOME_I_LIKE);
        if (criterionNomeILike != null && !criterionNomeILike.trim().isEmpty()) {
            sql += " AND lower(nome) ilike '%" + criterionNomeILike + "%'";
        }

        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery(sql);
        while (rs.next()) {
            Usuario e;
            String tipo = rs.getString("tipo");
            if (tipo.equalsIgnoreCase(TIPO_ADMINISTRADOR)) {
                e = new Administrador();
            } else {
                if (tipo.equalsIgnoreCase(TIPO_FINANCEIRO)) {
                    e = new Financeiro();
                } else {
                    e = new Solicitante();
                }
            }

            e.setTipo(rs.getString("tipo"));
            e.setLogin(rs.getLong("login"));
            e.setSenha(rs.getString("senha"));
            e.setNome(rs.getString("nome"));
            e.setEmailCorporativo(rs.getString("email_corporativo"));
            e.setEmailPessoal(rs.getString("email_pessoal"));
            e.setTelefoneCorporativo(rs.getString("telefone_corporativo"));
            e.setTelefonePessoal(rs.getString("telefone_pessoal"));
            
            //curso
            Empresa empresa = new Empresa();
            empresa.setId(rs.getLong("empresa_id"));
            empresa.setNome(rs.getString("empresa_nome"));
            e.setEmpresa(empresa);
            
            lista.add(e);
        }
        rs.close();
        s.close();
        return lista;
    }

    @Override
    public void update(Usuario e, Connection conn) throws Exception {
        String sql = "UPDATE usuario SET tipo=?,senha=?,nome=?,cpf=?,rg=?,email_corporativo=?,telefone_corporativo=?,email_pessoal=?,telefone_pessoal=?, empresa_fk=? WHERE login=?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        
        ps.setString(++i, e.getTipo());
        ps.setString(++i, e.getSenha());
        ps.setString(++i, e.getNome());
        ps.setString(++i, e.getEmailCorporativo());
        ps.setString(++i, e.getTelefoneCorporativo());
        //para campos não obrigatórios 
        if (e.getEmailPessoal() != null) {
            ps.setString(++i, e.getEmailPessoal());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }
        //para campos não obrigatórios 
        if (e.getTelefonePessoal()!= null) {
            ps.setString(++i, e.getTelefonePessoal());
        } else {
            ps.setNull(++i, Types.VARCHAR);
        }
        ps.setLong(++i, e.getEmpresa().getId());
        
        ps.setLong(++i, e.getLogin());
        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Long login, Connection conn) throws Exception {
        Statement st = conn.createStatement();
        st.execute("DELETE FROM usuario WHERE login = " + login + ";");
        st.close();
    }

    private String getTipo(Usuario e) {
        String tipo = "";
        if (e instanceof Financeiro) {
            tipo = TIPO_FINANCEIRO;
        } else {
            if (e instanceof Solicitante) {
                tipo = TIPO_SOLICITANTE;
            } else {
                if (e instanceof Administrador) {
                    tipo = TIPO_ADMINISTRADOR;
                }
            }
        }
        return tipo;
    }
}