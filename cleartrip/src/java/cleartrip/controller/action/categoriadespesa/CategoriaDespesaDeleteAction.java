package cleartrip.controller.action.categoriadespesa;

import cleartrip.model.ServiceLocator;
import cleartrip.model.pojo.CategoriaDespesa;
import org.mentawai.core.BaseAction;

public class CategoriaDespesaDeleteAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        Long id = input.getLong("id");
        CategoriaDespesa categoriaDespesa = ServiceLocator.getCategoriaDespesaService().readById(id);

        ServiceLocator.getCategoriaDespesaService().delete(id);
        consequence = SUCCESS;
        return consequence;
    }

}
