package cleartrip.controller.action.usuario;

import cleartrip.model.ServiceLocator;
import cleartrip.model.dao.UsuarioDAO;
import cleartrip.model.pojo.Usuario;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;

public class UsuarioReadAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = SUCCESS;
        Map<String, Object> criteria = new HashMap<String, Object>();
        String nome = input.getString("nome");
        if (nome != null && !nome.isEmpty()) {
            criteria.put(UsuarioDAO.CRITERION_NOME_I_LIKE, nome);
        }
        List<Usuario> usuarios = ServiceLocator.getUsuarioService().readByCriteria(criteria);
        output.setValue("lista", usuarios);
        return consequence;
    }
}
