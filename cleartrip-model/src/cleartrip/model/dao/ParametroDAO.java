package cleartrip.model.dao;

import cleartrip.model.base.BaseDAO;
import cleartrip.model.pojo.Empresa;
import cleartrip.model.pojo.Parametros;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParametroDAO implements BaseDAO<Parametros> {

   
    @Override
    public void create(Parametros e, Connection conn) throws Exception {
        String sql = "INSERT INTO parametro(empresa_fk, manha, tarde, noite, custoKm, margemDeslocamento, dataInicio, dataTermino) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING id;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;

        ps.setLong(++i, e.getEmpresa().getId());
        ps.setTime(++i, e.getManha());
        ps.setTime(++i, e.getTarde());
        ps.setTime(++i, e.getNoite());
        ps.setDouble(++i, e.getCustoKm());
        ps.setInt(++i, e.getMargemDeslocamento());
        ps.setDate(++i, e.getDataInicio());
        ps.setDate(++i, e.getDataTermino());

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            e.setId(rs.getLong("id"));
        }
        rs.close();
        ps.close();
    }

    @Override
    public Parametros readById(Long id, Connection conn) throws Exception {
        Parametros parametro = null;

        String sql = "SELECT parametro.*, empresa.id as empresa_id, empresa.nome as empresa_nome from empresa right join parametro on parametro.empresa_fk = empresa.id WHERE parametro.id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {

            //Parametro
            parametro = new Parametros();
            parametro.setId(id);
            parametro.setManha(rs.getTime("manha"));
            parametro.setTarde(rs.getTime("tarde"));
            parametro.setNoite(rs.getTime("noite"));
            parametro.setCustoKm(rs.getDouble("custoKm"));
            parametro.setMargemDeslocamento(rs.getInt("margem_deslocamento"));
            parametro.setDataInicio(rs.getDate("data_inicio"));
            parametro.setDataTermino(rs.getDate("data_termino"));
            
            
            //Empresa
            Empresa empresa = new Empresa();
            empresa.setId(rs.getLong("empresa_id"));
            empresa.setNome(rs.getString("empresa_nome"));
            parametro.setEmpresa(empresa);
        }

        rs.close();
        ps.close();

        return parametro;
    }

    
    // Nenhum Criterio de busca Definido, por isso está vazio mas continua a existir caso algum criterio seja definido futuramente
    @Override
    public List<Parametros> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        ArrayList<Parametros> lista = new ArrayList<Parametros>();
        return lista;
    }

    @Override
    public void update(Parametros e, Connection conn) throws Exception {
        String sql = "UPDATE parametros SET empresa_fk=?, manha=?, tarde=?, noite=?, custoKm=?, margemDeslocamento=?, dataInicio=?, dataTermino=? WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;

        ps.setLong(++i, e.getEmpresa().getId());
        ps.setTime(++i, e.getManha());
        ps.setTime(++i, e.getTarde());
        ps.setTime(++i, e.getNoite());
        ps.setDouble(++i, e.getCustoKm());
        ps.setInt(++i, e.getMargemDeslocamento());
        ps.setDate(++i, e.getDataInicio());
        ps.setDate(++i, e.getDataTermino());

        ps.close();
    }

    @Override
    public void delete(Long id, Connection conn) throws Exception {
        String sql = "DELETE * FROM parametros WHERE id=" + id;
        Statement st = conn.createStatement();
        st.execute(sql);
        st.close();
    }
}
