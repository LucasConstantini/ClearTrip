package cleartrip.controller.action.transporte;

import cleartrip.model.ServiceLocator;
import cleartrip.model.pojo.Transporte;
import org.mentawai.core.BaseAction;

public class TransporteShowFormAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = "CREATE";
        Long id = input.getLong("id");
        if (id != null && id > 0) {
            Transporte transporte = ServiceLocator.getTransporteService().readById(id);
            output.setValue("transporte", transporte);
            consequence = "UPDATE";
        }
        return consequence;
    }
}