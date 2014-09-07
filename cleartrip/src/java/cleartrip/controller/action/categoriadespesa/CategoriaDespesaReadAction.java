package cleartrip.controller.action.categoriadespesa;

import cleartrip.model.ServiceLocator;
import cleartrip.model.dao.CategoriaDespesaDAO;
import cleartrip.model.pojo.CategoriaDespesa;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;

public class CategoriaDespesaReadAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = SUCCESS;
        Map<String, Object> criteria = new HashMap<String, Object>();      
        String nome = input.getString("nome");
        
        if (nome != null && !nome.isEmpty()) {
            criteria.put(CategoriaDespesaDAO.CRITERION_NOME, nome);
        }
        List<CategoriaDespesa> categoriaDespesa = ServiceLocator.getCategoriaDespesaService().readByCriteria(criteria);
        output.setValue("lista", categoriaDespesa);
        return consequence;
    }
}