package cleartrip.controller.action.categoriadespesa;

import cleartrip.model.ServiceLocator;
import cleartrip.model.pojo.CategoriaDespesa;
import java.util.HashMap;
import java.util.Map;
import org.mentawai.core.BaseAction;

public class CategoriaDespesaCreateAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        //Montando o mapa
        Map<String, Object> form = new HashMap<String, Object>();
        form.put("nome", input.getString("nome"));
        form.put("valorLimite", input.getInt("valorLimite"));
        Map<String, String> error = ServiceLocator.getCategoriaDespesaService().validateForCreate(form);
        if (error == null || error.isEmpty()) {
            CategoriaDespesa categoriaDespesa = new CategoriaDespesa();
            categoriaDespesa.setNome((String) form.get("nome"));
            categoriaDespesa.setValorLimite((Integer) form.get("valorLimite"));
            
            ServiceLocator.getCategoriaDespesaService().create(categoriaDespesa);
            consequence = SUCCESS;
        } else {
            output.setValue("error", error);
        }
        return consequence;
    }
}
