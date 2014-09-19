package cleartrip.controller.action.usuario;

import cleartrip.model.ServiceLocator;
import cleartrip.model.pojo.Usuario;
import org.mentawai.core.BaseAction;

public class UsuarioShowFormAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = "CREATE";
        Long login = input.getLong("login");
        if (login != null && login > 0) {
            Usuario usuario = ServiceLocator.getUsuarioService().readById(login);
            output.setValue("usuario", usuario);
            consequence = "UPDATE";
        }
        return consequence;
    }
}