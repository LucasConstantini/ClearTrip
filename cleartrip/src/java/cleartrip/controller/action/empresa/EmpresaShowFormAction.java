package cleartrip.controller.action.empresa;

import cleartrip.model.ServiceLocator;
import cleartrip.model.pojo.Empresa;
import org.mentawai.core.BaseAction;

public class EmpresaShowFormAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = "CREATE";
        Long id = input.getLong("id");
        if (id != null && id > 0) {
            Empresa empresa = ServiceLocator.getEmpresaService().readById(id);
            output.setValue("empresa", empresa);
            consequence = "UPDATE";
        }
        return consequence;
    }
}