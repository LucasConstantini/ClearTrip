package cleartrip.controller.action.usuario;

import cleartrip.model.ServiceLocator;
import cleartrip.model.pojo.Usuario;
import java.util.HashMap;
import java.util.Map;
import org.mentawai.core.BaseAction;

public class AlterarSenhaAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        if (isGet()) {
            consequence = doGet();
        } else {
            if (isPost()) {
                consequence = doPost();
            }
        }
        return consequence;
    }

    private String doGet() {
        Usuario usuario = new Usuario();
        usuario = (Usuario) session.getAttribute("usuarioLogado");
        output.setValue("usuario", usuario);
        return "FORM";
    }

    private String doPost() throws Exception {
        String consequence = ERROR;
        Map<String, Object> form = new HashMap<String, Object>();
        Map<String, String> error = new HashMap<String, String>();
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");

        form.put("nome", input.getString("usuario.nome"));
        form.put("login", usuarioLogado.getLogin());
        form.put("senha", usuarioLogado.getSenha());
        form.put("emailCorporativo", input.getString("usuario.emailCorporativo"));
        form.put("celInstitucional", input.getString("usuario.celularCorporativo"));
        form.put("telInstitucional", input.getString("usuario.telefoneCorporativo"));
        form.put("tipo", usuarioLogado.getTipo());

        error = ServiceLocator.getUsuarioService().validateForUpdate(form);

        if (error == null || error.isEmpty()) {
            String senhaAtual = input.getString("senhaAtual");
            String novaSenha = input.getString("novaSenha");
            String confirmacao = input.getString("confirmacao");
            
            usuarioLogado.setNome(input.getString("usuario.nome"));
            usuarioLogado.setEmailCorporativo(input.getString("usuario.emailCorporativo"));
            usuarioLogado.setEmailPessoal(input.getString("usuario.emailPessoal"));
            usuarioLogado.setTelefoneCorporativo(input.getString("usuario.telefoneCorporativo"));
            
            if (senhaAtual != null && !senhaAtual.isEmpty()) {
                boolean ok = false;
                if (senhaAtual.equals(usuarioLogado.getSenha())) {
                    if (novaSenha != null && !novaSenha.isEmpty() && confirmacao != null && !confirmacao.isEmpty() && novaSenha.equals(confirmacao)) {
                        usuarioLogado.setSenha(novaSenha);
                        ServiceLocator.getUsuarioService().update(usuarioLogado);
                        consequence = SUCCESS;
                        ok = true;
                    }
                }
                if (!ok) {
                    error.put("senhaAtual", "As senhas não conferem!");
                    output.setValue("error", error);
                }
            } else {
                ServiceLocator.getUsuarioService().update(usuarioLogado);
                consequence = SUCCESS;
            }
        } else {
            output.setValue("error", error);
        }

        return consequence;
    }
}