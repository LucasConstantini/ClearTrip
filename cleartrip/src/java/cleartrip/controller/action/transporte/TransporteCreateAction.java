package cleartrip.controller.action.transporte;

import cleartrip.model.ServiceLocator;
import cleartrip.model.pojo.Transporte;
import java.util.HashMap;
import java.util.Map;
import org.mentawai.core.BaseAction;

public class TransporteCreateAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        //Montando o mapa
        Map<String, Object> form = new HashMap<String, Object>();
        form.put("nome", input.getString("nome"));

        //Validando      
        Map<String, String> error = ServiceLocator.getTransporteService().validateForCreate(form);
        if (error == null || error.isEmpty()) {
            //Monto o pojo
            Transporte transporte = new Transporte();
            transporte.setNome((String) form.get("nome"));
            //Persistindo
            ServiceLocator.getTransporteService().create(transporte);
            consequence = SUCCESS;
        } else {
            output.setValue("error", error);
        }
        return consequence;
    }
}