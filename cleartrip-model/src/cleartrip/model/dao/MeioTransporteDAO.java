package cleartrip.model.dao;

import cleartrip.model.base.BaseDAO;
import cleartrip.model.pojo.MeioTransporte;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MeioTransporteDAO implements BaseDAO<MeioTransporte> {

    public static final String CRITERION_NOME_I_LIKE = "1";
    
    @Override
    public void create(MeioTransporte e, Connection conn) throws Exception {
        String sql = "INSERT INTO meio_transporte(nome) VALUES(?) RETURNING id";
        PreparedStatement ps = conn.prepareStatement(sql);
        //setando valores
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
    public MeioTransporte readById(Long id, Connection conn) throws Exception {
        MeioTransporte meioTransporte = null;
        String sql = "SELECT * FROM meio_transporte  WHERE meio_transporte.id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setLong(++i, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            //setando meio de transporte
            meioTransporte = new MeioTransporte();
            meioTransporte.setId(rs.getLong("id"));
            meioTransporte.setNome(rs.getString("nome"));
            
            rs.close();
            ps.close();
        }

        return meioTransporte;
    }

    @Override
    public List<MeioTransporte> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        List<MeioTransporte> lista = new ArrayList<MeioTransporte>();
        String sql = "SELECT * FROM meio_transporte  WHERE 1=1";

        //busca por criterios
        
        String criterionNomeILike = (String) criteria.get(CRITERION_NOME_I_LIKE);
        if (criterionNomeILike != null && !criterionNomeILike.trim().isEmpty()){
            sql += " AND nome ILIKE '%" + criterionNomeILike + "%'";
        }
        
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            //setando meio de transporte
            MeioTransporte meioTransporte = new MeioTransporte();
            meioTransporte.setId(rs.getLong("id"));
            meioTransporte.setNome(rs.getString("nome"));
            lista.add(meioTransporte);
        }
        rs.close();
        ps.close();
        return lista;
    }

    @Override
    public void update(MeioTransporte e, Connection conn) throws Exception {
        String sql = "UPDATE meio_transporte SET nome=? WHERE solicitacao.id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        //setando valores
        int i = 0;
        ps.setString(++i, e.getNome());
        ps.setLong(++i, e.getId());
        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Long id, Connection conn) throws Exception {
        String sql = "DELETE FROM meio_transporte WHERE id=" + id;
        Statement st = conn.createStatement();
        st.execute(sql);
        st.close();
    }
}
