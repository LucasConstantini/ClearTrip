package cleartrip.controller.action.transporte;

import cleartrip.model.ServiceLocator;
import cleartrip.model.dao.TransporteDAO;
import cleartrip.model.pojo.Transporte;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;

public class TransporteReadAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = SUCCESS;
        Map<String, Object> criteria = new HashMap<String, Object>();
        String nome = input.getString("nome");
        
        if (nome!=null && !nome.isEmpty()){
            criteria.put(TransporteDAO.CRITERION_NOME_I_LIKE, nome);
        }
        
        List<Transporte> transportes = ServiceLocator.getTransporteService().readByCriteria(criteria);
        output.setValue("lista", transportes);
        
        return consequence;
    }
}