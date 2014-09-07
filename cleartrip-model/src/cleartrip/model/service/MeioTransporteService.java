package cleartrip.model.service;

import cleartrip.model.ConnectionManager;
import cleartrip.model.ServiceLocator;
import cleartrip.model.base.service.BaseMeioTransporteService;
import cleartrip.model.dao.MeioTransporteDAO;
import cleartrip.model.pojo.MeioTransporte;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MeioTransporteService implements BaseMeioTransporteService {

    @Override
    public void create(MeioTransporte pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            MeioTransporteDAO dao = new MeioTransporteDAO();
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
    public MeioTransporte readById(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        MeioTransporte solicitacao = null;
        try {
            MeioTransporteDAO dao = new MeioTransporteDAO();
            solicitacao = dao.readById(id, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
        return solicitacao;
    }

    @Override
    public List<MeioTransporte> readByCriteria(Map<String, Object> criteria) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<MeioTransporte> lista = null;
        try {
            MeioTransporteDAO dao = new MeioTransporteDAO();
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
    public void update(MeioTransporte pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            MeioTransporteDAO dao = new MeioTransporteDAO();
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
            MeioTransporteDAO dao = new MeioTransporteDAO();
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
        Map<String, String> erros = new HashMap<String, String>();
        SimpleDateFormat formatoHora = new SimpleDateFormat("H:mm");
        if (properties != null) {            
//            Date dataEvento = (Date) properties.get("dataEvento");
            Date dataEvento = (Date) properties.get("dataEvento");
            String horaInicio = (String) properties.get("horaInicio");
            String horaFim = (String) properties.get("horaFim");
            String tipo = (String) properties.get("tipo");
//            Boolean datashow = (Boolean) properties.get("datashow");
//            Boolean internet = (Boolean) properties.get("internet");
            Integer numeroAlunos = (Integer) properties.get("numeroAlunos");
//            String status = (String) properties.get("status");
            Long turma = (Long) properties.get("turma");
//            Long usuario_fk = (Long) properties.get("usuario_fk");            
            
            //para campos obrigatórios
            if (dataEvento == null) {
                erros.put("dataEvento", "Campo obrigatório");
            }
            if (horaInicio == null) {
                erros.put("horaInicio", "Campo obrigatório");
            } else {
                Date horaInic = formatoHora.parse(horaInicio);
                Date horaMax = formatoHora.parse("24:00");
                if (horaInic.getTime() > horaMax.getTime()) {
                    erros.put("horaInicio", "Insira uma hora válida!");
                }
            }
            if (horaFim == null) {
                erros.put("horaFim", "Campo obrigatório");
            } else {
                Date horaFinal = formatoHora.parse(horaFim);
                Date horaMax = formatoHora.parse("24:00");
                if (horaFinal.getTime() > horaMax.getTime()) {
                    erros.put("horaFim", "Insira uma hora válida!");
                }
            }
            if (horaInicio != null && horaFim != null) {
                Date horaInic = formatoHora.parse(horaInicio);
                Date horaFinal = formatoHora.parse(horaFim);
                if (horaInic.getTime() >= horaFinal.getTime()) {
                    erros.put("verificaHora", "A hora de início deve ser menor que a hora de encerramento!");
                }
            }
            if (tipo.equalsIgnoreCase("Selecione...")) {
                erros.put("tipo", "Selecione a finalidade da solicitacao!");
            }
            if (numeroAlunos < 0 || numeroAlunos == null) {
                erros.put("tipo", "Informe a quantidade de alunos!");
            }
            if (turma == null) {
                erros.put("turma", "Informe a turma!");
            }
        }
        return erros;
    }

    @Override
    public Map<String, String> validateForUpdate(Map<String, Object> properties) throws Exception {
        return this.validateForCreate(properties);
    }
}