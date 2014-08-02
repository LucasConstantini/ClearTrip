package cleartrip.model.dao;

import cleartrip.model.base.BaseDAO;
import cleartrip.model.pojo.Transporte;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TransporteDAO implements BaseDAO<Transporte> {

    public static final String CRITERION_NOME_I_LIKE = "1";

    @Override
    public List<Transporte> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        List<Transporte> lista = new ArrayList<Transporte>();
        String sql = "SELECT * FROM meio_transporte where 1=1 ";

        String criterionNomeILike = (String) criteria.get(CRITERION_NOME_I_LIKE);
        if (criterionNomeILike != null && !criterionNomeILike.trim().isEmpty()) {
            sql += " AND nome ILIKE '%" + criterionNomeILike + "%'";
        }

        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery(sql);
        while (rs.next()) {
            Transporte e = new Transporte();
            e.setId(rs.getLong("id"));
            e.setNome(rs.getString("nome"));
            lista.add(e);
        }
        rs.close();
        s.close();
        return lista;
    }

    @Override
    public void update(Transporte e, Connection conn) throws Exception {
        String sql = "UPDATE meio_transporte SET nome=? WHERE id=?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, e.getNome());
        ps.setLong(++i, e.getId());
        ps.execute();
        ps.close();
    }

    @Override
    public void create(Transporte e, Connection conn) throws Exception {
        String sql = "INSERT INTO meio_transporte(nome) VALUES(?) RETURNING id;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, e.getNome());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            e.setId(rs.getLong("id"));
        }
        rs.close();
        ps.close();
    }

    @Override
    public Transporte readById(Long id, Connection conn) throws Exception {
        Transporte e = null;
        String sql = "SELECT * FROM meio_transporte WHERE id=?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            e = new Transporte();
            e.setId(rs.getLong("id"));
            e.setNome(rs.getString("nome"));
        }
        rs.close();
        ps.close();
        return e;
    }

    @Override
    public void delete(Long id, Connection conn) throws Exception {
        Statement st = conn.createStatement();
        st.execute("delete from meio_transporte where id =" + id);
        st.close();
    }
}
