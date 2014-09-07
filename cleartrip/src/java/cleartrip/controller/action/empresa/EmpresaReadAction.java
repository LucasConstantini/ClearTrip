package cleartrip.controller.action.empresa;

import cleartrip.model.ServiceLocator;
import cleartrip.model.dao.EmpresaDAO;
import cleartrip.model.pojo.Empresa;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;

public class EmpresaReadAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = SUCCESS;
        Map<String, Object> criteria = new HashMap<String, Object>();
        String nome = input.getString("nome");
        if(nome!=null && !nome.isEmpty()){
            criteria.put(EmpresaDAO.CRITERION_NOME_I_LIKE, nome);
        }
        List<Empresa> empresas = ServiceLocator.getEmpresaService().readByCriteria(criteria);
        output.setValue("lista", empresas);
        return consequence;
    }
}