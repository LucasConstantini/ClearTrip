package cleartrip.model.service;

import cleartrip.model.ConnectionManager;
import cleartrip.model.base.service.BaseDespesaService;
import cleartrip.model.dao.DespesaDAO;
import cleartrip.model.pojo.Despesa;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DespesaService implements BaseDespesaService {

    @Override
    public void create(Despesa pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            DespesaDAO dao = new DespesaDAO();
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
    public Despesa readById(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        Despesa turma = null;
        try {
            DespesaDAO dao = new DespesaDAO();
            turma = dao.readById(id, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
        return turma;
    }

    @Override
    public List<Despesa> readByCriteria(Map<String, Object> criteria) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<Despesa> lista = new ArrayList<Despesa>();
        try {
            DespesaDAO dao = new DespesaDAO();
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
    public void update(Despesa pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            DespesaDAO dao = new DespesaDAO();
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
            DespesaDAO dao = new DespesaDAO();
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
        Connection conn = ConnectionManager.getInstance().getConnection();
        Map<String, String> erros = new HashMap<String, String>();
        if (properties != null) {
            
            Long viagemFk = (Long) properties.get("viagem_fk");
            if (viagemFk == null) {
                erros.put("viagem_fk", "Campo obrigatório!");
            }
            
            Long categoriaFk = (Long) properties.get("categoria_fk");
            if (viagemFk == null) {
                erros.put("categoria_fk", "Campo obrigatório!");
            }
            
            byte[] comprovate = (byte[]) properties.get("comprovate");
            if (comprovate == null) {
                erros.put("comprovate", "Campo obrigatório!");
            }
            
            int valor = (int) properties.get("valor");
            if (valor == 0) {
                erros.put("valor", "Campo obrigatório!");
            }
            
            Date dataCompra = (Date) properties.get("data_compra");
            if (dataCompra == null) {
                erros.put("data_compra", "Campo obrigatório!");
            }
            
            Time horaCompra = (Time) properties.get("hora_compra");
            if (horaCompra == null) {
                erros.put("hora_compra", "Campo obrigatório!");
            }
            
            int valorRealAutorizado = (int) properties.get("valor_autorizado");
            if (valorRealAutorizado == 0) {
                erros.put("valor_autorizado", "Campo obrigatório!");
            }
            
        }
        return erros;
    }

    @Override
    public Map<String, String> validateForUpdate(Map<String, Object> properties) throws Exception {
        return this.validateForCreate(properties);
    }
}
