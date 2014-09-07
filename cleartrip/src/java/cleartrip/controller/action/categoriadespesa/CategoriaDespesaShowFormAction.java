package cleartrip.controller.action.categoriadespesa;

import cleartrip.model.ServiceLocator;
import cleartrip.model.pojo.CategoriaDespesa;
import org.mentawai.core.BaseAction;

public class CategoriaDespesaShowFormAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = "CREATE";
        Long id = input.getLong("id");
        if (id != null && id > 0) {
            CategoriaDespesa categoriaDespesa = ServiceLocator.getCategoriaDespesaService().readById(id);
            output.setValue("categoriaDespesa", categoriaDespesa);
            consequence = "UPDATE";
        }
        return consequence;
    }

   
}
