package cleartrip.model.dao;

import cleartrip.model.base.BaseDAO;
import cleartrip.model.pojo.Viagem;
import cleartrip.model.pojo.Empresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ViagemDAO implements BaseDAO<Viagem> {

    public static final String CRITERION_NOME_I_LIKE = "1";
    public static final String CRITERION_CURSO_ID_EQ = "2";

    @Override
    public void create(Viagem e, Connection conn) throws Exception {
        }

    @Override
    public Viagem readById(Long id, Connection conn) throws Exception {
        Viagem e = null;
        return e;

    }

    @Override
    public List<Viagem> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        List<Viagem> lista = new ArrayList<Viagem>();
        return lista;
    }

    @Override
    public void update(Viagem e, Connection conn) throws Exception {
        }

    @Override
    public void delete(Long id, Connection conn) throws Exception {
        Statement st = conn.createStatement();
        st.execute("delete * from viagem where id =" + id);
        st.close();
    }
}