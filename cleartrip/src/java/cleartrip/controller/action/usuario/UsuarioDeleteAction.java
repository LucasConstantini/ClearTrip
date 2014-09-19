package cleartrip.controller.action.usuario;

import cleartrip.model.ServiceLocator;
import cleartrip.model.pojo.Usuario;
import java.util.HashMap;
import java.util.Map;
import org.mentawai.core.BaseAction;

public class UsuarioDeleteAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        Map<String, String> erro = new HashMap<String, String>();
        Long login = input.getLong("login");
        //verificando se é administrador
        Usuario usuario = new Usuario();
        usuario = ServiceLocator.getUsuarioService().readById(login);
        if (!usuario.getTipo().equalsIgnoreCase("Administrador")) {

            try {
                ServiceLocator.getUsuarioService().delete(login);
                consequence = SUCCESS;
            } catch (Exception e) {
                erro.put("erro", "Este usuário não pode ser excluído");
                output.setValue("erro", erro);

            }

        }else{
            erro.put("erroAdm", "Não é possivel excuir o Administrador!");
            output.setValue("erro", erro);
        }
        return consequence;
    }
}