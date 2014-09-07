package cleartrip.controller.action.categoriadespesa;

import cleartrip.model.ServiceLocator;
import cleartrip.model.pojo.CategoriaDespesa;
import java.util.HashMap;
import java.util.Map;
import org.mentawai.core.BaseAction;

public class CategoriaDespesaUpdateAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        //Montando o mapa
        Map<String, Object> form = new HashMap<String, Object>();
       form.put("nome", input.getString("categoriaDespesa.nome"));
       form.put("valorLimite", input.getInt("categoriaDespesa.valorLimite"));
       Map<String, String> error = ServiceLocator.getCategoriaDespesaService().validateForUpdate(form);
        if (error == null || error.isEmpty()) {
            //Monto o pojo
            CategoriaDespesa categoriaDespesa = new CategoriaDespesa(); 
            categoriaDespesa.setId(input.getLong("categoriaDespesa.id"));
            categoriaDespesa.setNome(input.getString("categoriaDespesa.nome"));
            categoriaDespesa.setValorLimite(input.getInt("categoriaDespesa.valorLimite"));
            ServiceLocator.getCategoriaDespesaService().update(categoriaDespesa);
            consequence = SUCCESS;
        } else {
            output.setValue("error", error);
        }
        return consequence;
    }
}