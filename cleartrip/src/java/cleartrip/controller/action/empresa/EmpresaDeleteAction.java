package cleartrip.controller.action.empresa;

import cleartrip.model.ServiceLocator;
import java.util.HashMap;
import java.util.Map;
import org.mentawai.core.BaseAction;

public class EmpresaDeleteAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        Long id = input.getLong("id");

        Map<String, String> erro = new HashMap<String, String>();
        try {
            ServiceLocator.getEmpresaService().delete(id);
            consequence = SUCCESS;
        } catch (Exception e) {
            output.setValue("erro", erro);
        }
        return consequence;
    }
}