package cleartrip.model.dao;

import cleartrip.model.base.BaseDAO;
import cleartrip.model.pojo.CategoriaDespesa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CategoriaDespesaDAO implements BaseDAO<CategoriaDespesa> {

    public static final String CRITERION_NOME = "1";
    public static final int CRITEERION_VALOR_LIMITE_1 = 0;
    public static final int CRITEERION_VALOR_LIMITE_2 = 0;

    @Override
    public void create(CategoriaDespesa e, Connection conn) throws Exception {
        String sql = "INSERT INTO categoria_despesa(nome, valor_limite) VALUES(?,?) RETURNING id";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        //campo obrigatório
        ps.setString(++i, e.getNome());
        //campo não obrigatórios
        if (e.getValorLimite() != 0) {
            ps.setInt(++i, e.getValorLimite());
        } else {
            ps.setNull(++i, Types.INTEGER);
        }
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            e.setId(rs.getLong("id"));
        }
        rs.close();
        ps.close();

    }

    @Override
    public CategoriaDespesa readById(Long id, Connection conn) throws Exception {
        CategoriaDespesa categoriaDespesa = null;
        String sql = "SELECT * from categoria_despesa WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setLong(++i, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            //setando categoria de despesa
            categoriaDespesa = new CategoriaDespesa();
            categoriaDespesa.setId(rs.getLong("id"));
            categoriaDespesa.setNome(rs.getString("nome"));
            categoriaDespesa.setValorLimite(rs.getInt("valor_limite"));

        }
        rs.close();
        ps.close();
        return categoriaDespesa;
    }

    @Override
    public List<CategoriaDespesa> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        List<CategoriaDespesa> lista = new ArrayList<CategoriaDespesa>();
        String sql = "SELECT * from ccategoria_despesa WHERE 1=1";

        //criterio por nome
        String criterionNome = (String) criteria.get(CRITERION_NOME);
        if (criterionNome != null && !criterionNome.trim().isEmpty()) {
            sql += " AND categoria_despesa.nome ILIKE '%" + criterionNome + "%'";
        }

        //criterio por intervalo de valores
        int criterionValorLimite1 = (int) criteria.get(CRITEERION_VALOR_LIMITE_1);
        int criterionValorLimite2 = (int) criteria.get(CRITEERION_VALOR_LIMITE_2);
        if (criterionValorLimite2 != 0) {
            sql += " AND categoria_despesa.valor_limite between " + criterionValorLimite1 + " and " + criterionValorLimite2;
        }

        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            //setando categoria de despesa
            CategoriaDespesa categoriaDespesa = new CategoriaDespesa();
            categoriaDespesa.setId(rs.getLong("id"));
            categoriaDespesa.setNome(rs.getString("nome"));
            categoriaDespesa.setValorLimite(rs.getInt("valor_limite"));

            lista.add(categoriaDespesa);
        }
        rs.close();
        ps.close();
        return lista;
    }

    @Override
    public void update(CategoriaDespesa e, Connection conn) throws Exception {
        String sql = "UPDATE categoria_despesa SET nome=?, valor_limite=? WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;

        //setar os campos obrigatórios
        ps.setString(++i, e.getNome());
        if (e.getValorLimite() != 0) {
            ps.setInt(++i, e.getValorLimite());
        } else {
            ps.setNull(++i, Types.INTEGER);
        }
        ps.setLong(++i, e.getId());
        ps.execute();
        ps.close();

    }

    @Override
    public void delete(Long id, Connection conn) throws Exception {
        Statement st = conn.createStatement();
        st.execute("DELETE FROM categoria_despesa WHERE id =" + id);
        st.close();
    }
}
