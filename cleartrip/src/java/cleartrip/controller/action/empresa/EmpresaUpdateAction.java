package cleartrip.controller.action.empresa;

import cleartrip.model.ServiceLocator;
import cleartrip.model.pojo.Empresa;
import java.util.HashMap;
import java.util.Map;
import org.mentawai.core.BaseAction;

public class EmpresaUpdateAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        //Montando o mapa
        Map<String, Object> form = new HashMap<String, Object>();
        form.put("id", input.getLong("empresa.id"));
        form.put("nome", input.getString("empresa.nome"));
        form.put("nomeFantasia", input.getString("empresa.nomeFantasia"));
        form.put("endereco", input.getString("empresa.endereco"));
        form.put("telefone", input.getString("empresa.telefone"));
        form.put("nomeRepresentante", input.getString("empresa.nomeRepresentante"));
        form.put("cpfRepresentante", input.getLong("empresa.cpfRepresentante"));
        form.put("cnpj", input.getLong("empresa.cnpj"));
        //Validando
        Map<String, String> error = ServiceLocator.getEmpresaService().validateForUpdate(form);
        if (error == null || error.isEmpty()) {
            //Monto o pojo
            Empresa empresa = new Empresa();
            empresa.setNome((String) form.get("nome"));
            empresa.setNomeFantasia((String) form.get("nomeFantasia"));
            empresa.setEndereco((String) form.get("endereco"));
            empresa.setTelefone((String) form.get("telefone"));
            empresa.setNomeRepresentante((String) form.get("nomeRepresentante"));
            empresa.setCpfRepresentante((Long) form.get("cpfRepresentante"));
            empresa.setCnpj((Long) form.get("cnpj"));
            //Persistindo
            ServiceLocator.getEmpresaService().update(empresa);
            consequence = SUCCESS;
        } else {
            output.setValue("error", error);
        }
        return consequence;
    }
}