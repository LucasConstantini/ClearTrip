package cleartrip.controller.action.usuario;

import cleartrip.model.ServiceLocator;
import cleartrip.model.pojo.Empresa;
import cleartrip.model.pojo.Usuario;
import java.util.HashMap;
import java.util.Map;
import org.mentawai.core.BaseAction;

public class UsuarioCreateAction extends BaseAction {

    @Override
    public String execute() throws Exception {

        String consequence = ERROR;
        //Montando o mapa
        Map<String, Object> form = new HashMap<String, Object>();


        //Validando
        Map<String, String> error = new HashMap<String, String>();

        try {

            form.put("nome", input.getString("nome"));
            form.put("login", input.getLong("login"));
            form.put("senha", input.getString("senha"));
            form.put("emailCorporativo", input.getString("emailCorporativo"));
            form.put("emailPessoal", input.getString("emailPessoal"));
            form.put("telCorporativo", input.getString("telefoneCorporativo"));
            form.put("telefonePessoal", input.getString("telefonePessoal"));
            form.put("tipo", input.getString("tipo"));

            error = ServiceLocator.getUsuarioService().validateForCreate(form);

        } catch (Exception e) {
            error.put("login", "O login deve conter apenas números!");

        }


        if (error == null || error.isEmpty()) {
            //Monto o pojo
            Usuario usuario = new Usuario();
            usuario.setNome((String) form.get("nome"));
            usuario.setLogin((String) form.get("login"));
            usuario.setSenha((String) form.get("senha"));
            usuario.setCpf((String) form.get("cpf"));
            usuario.setRg((String) form.get("rg"));
            usuario.setEmailCorporativo((String) form.get("emailCorporativo"));
            usuario.setEmailPessoal((String) form.get("emailPessoal"));
            usuario.setTelefonePessoal((String) form.get("telefonePessoal"));
            usuario.setTelefoneCorporativo((String) form.get("telefoneCorporativo"));
            usuario.setTipo((String) form.get("tipo"));
            //Set empresa
            Empresa empresa = ServiceLocator.getEmpresaService().readById((Long) form.get("empresa.id"));
            usuario.setEmpresa(empresa);
            //Persistindo
            ServiceLocator.getUsuarioService().create(usuario);
            consequence = SUCCESS;
        } else {
            output.setValue("error", error);
        }
        return consequence;
    }
}
