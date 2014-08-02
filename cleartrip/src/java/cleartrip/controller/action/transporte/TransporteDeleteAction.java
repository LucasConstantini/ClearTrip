package cleartrip.controller.action.transporte;

import cleartrip.model.ServiceLocator;
import org.mentawai.core.BaseAction;

public class TransporteDeleteAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        Long id = input.getLong("id");
        ServiceLocator.getTransporteService().delete(id);
        return SUCCESS;
    }
}