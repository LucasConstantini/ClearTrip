package cleartrip.model.dao;

import cleartrip.model.base.BaseDAO;
import cleartrip.model.pojo.CategoriaDespesa;
import cleartrip.model.pojo.Viagem;
import cleartrip.model.pojo.Despesa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DespesaDAO implements BaseDAO<Despesa> {

    public static final String CRITERION_NOME = "1";

    @Override
    public void create(Despesa e, Connection conn) throws Exception {
        String sql = "INSERT INTO despesa(viagem_fk, categoria_despesa_fk, comprovante, valor, nome_estabelecimento, data_compra, hora_compra, cnpj, descritivo, valor_real_autorizado) VALUES(?,?,?,?,?,?,?,?,?,?) RETURNING id";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setLong(++i, e.getViagem().getId());
        ps.setLong(++i, e.getCategoriaDespesa().getId());
        ps.setBytes(++i, e.getComprovante());
        if(e.getNomeEstabelecimento() != null){
            ps.setDouble(++i, e.getValor());
        }else{
            ps.setNull(++i, Types.VARCHAR);
        }
        ps.setString(++i, e.getNomeEstabelecimento());
        ps.setDate(++i, e.getDataCompra());
        ps.setTime(++i, e.getHoraCompra());
        if(e.getCnpj() != 0){
            ps.setLong(++i, e.getCnpj());
        }else{
            ps.setNull(++i, Types.BIGINT);
        }
        if(e.getDescritivo()!= null){
            ps.setString(++i, e.getDescritivo());
        }else{
            ps.setNull(++i, Types.VARCHAR);
        }
        ps.setLong(++i, e.getValorRealAutorizado());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            e.setId(rs.getLong("id"));
        }
        rs.close();
        ps.close();

    }

    @Override
    public Despesa readById(Long id, Connection conn) throws Exception {
        Despesa e = null;
        String sql = "SELECT despesa.*,viagem.id as viagem_id,categoria_despesa.id as categoria_despesa_id, categoria_despesa.nome as categoria_despesa_nome FROM despesa left join viagem on despesa.viagem_fk = viagem.id left join categoria_despesa on despesa.categoria_despesa_fk = categoria_despesa.id  WHERE despesa.id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        //executando o comando sql
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            //Despesa
            e = new Despesa();
            e.setId(rs.getLong("id"));
            e.setComprovante(rs.getBytes("comprovante"));
            e.setValor(rs.getLong("valor"));
            e.setNomeEstabelecimento(rs.getString("nome_estabelecimento"));
            e.setDataCompra(rs.getDate("data_compra"));
            e.setHoraCompra(rs.getTime("hora_compra"));
            e.setDescritivo(rs.getString("descritivo"));
            e.setCnpj(rs.getLong("cnpj"));
            e.setValorRealAutorizado(rs.getInt("valor_real_autorizado"));

            //Categoria Despesa
            CategoriaDespesa categoria_despesa = new CategoriaDespesa();
            categoria_despesa.setId(rs.getLong("categoria_despesa_id"));
            e.setCategoriaDespesa(categoria_despesa);

            //Viagem
            Viagem viagem = new Viagem();
            viagem.setId(rs.getLong("viagem_id"));
            e.setViagem(viagem);
        }
        rs.close();
        ps.close();
        return e;
    }

    @Override
    public List<Despesa> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        List<Despesa> lista = new ArrayList<Despesa>();
        //Aqui ainda tem que conseguir pesquisar as despesas por usuário e por intervalo de valor
        return lista;
    }

    @Override
    public void update(Despesa e, Connection conn) throws Exception {
        String sql = "UPDATE despesa SET viagem_fk=?, categoria_despesa_fk=?, comprovante=?, valor=?, nome_estabelecimento=?, data_compra=?, hora_compra=?, cnpj=?, descritivo=?, valor_real_autorizado=? WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setLong(++i, e.getViagem().getId());
        ps.setLong(++i, e.getCategoriaDespesa().getId());
        ps.setBytes(++i, e.getComprovante());
        ps.setDouble(++i, e.getValor());
        if(e.getNomeEstabelecimento() != null){
            ps.setDouble(++i, e.getValor());
        }else{
            ps.setNull(++i, Types.VARCHAR);
        }
        ps.setDate(++i, e.getDataCompra());
        ps.setTime(++i, e.getHoraCompra());
       if(e.getCnpj() != 0){
            ps.setLong(++i, e.getCnpj());
        }else{
            ps.setNull(++i, Types.BIGINT);
        }
        if(e.getDescritivo()!= null){
            ps.setString(++i, e.getDescritivo());
        }else{
            ps.setNull(++i, Types.VARCHAR);
        }        ps.setLong(++i, e.getValorRealAutorizado());
        // executando o comando sql
        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Long id, Connection conn) throws Exception {
        String sql = "DELETE FROM despesa WHERE id=" + id;
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.execute();
        ps.close();
    }

}
