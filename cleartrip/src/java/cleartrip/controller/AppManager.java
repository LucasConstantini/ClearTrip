package cleartrip.controller;

import cleartrip.controller.action.InicioAction;
import cleartrip.controller.action.login.LoginAction;
import cleartrip.controller.action.transporte.TransporteCreateAction;
import cleartrip.controller.action.transporte.TransporteReadAction;
import cleartrip.controller.action.transporte.TransporteShowFormAction;
import cleartrip.controller.action.transporte.TransporteDeleteAction;
import cleartrip.controller.action.transporte.TransporteUpdateAction;
import org.mentawai.action.LogoutAction;
import org.mentawai.authorization.AuthorizationManager;
import org.mentawai.authorization.Group;
import org.mentawai.authorization.Permission;
import org.mentawai.core.ActionConfig;
import org.mentawai.core.ApplicationManager;
import static org.mentawai.core.ApplicationManager.ERROR;
import static org.mentawai.core.ApplicationManager.SUCCESS;
import org.mentawai.core.Context;
import org.mentawai.core.Forward;
import org.mentawai.core.Redirect;
import org.mentawai.filter.AuthenticationFilter;
import org.mentawai.filter.AuthorizationFilter;

public class AppManager extends ApplicationManager {
    @Override
    public void loadFilters() {
        this.addGlobalFilter(new AuthenticationFilter());
        this.addGlobalConsequence(LOGIN, new Redirect("/"));
        this.addGlobalConsequence(ACCESSDENIED, new Redirect("Logout.mtw"));
    }
    
    @Override
    public void init(Context application) {
        //FINANCEIRO
        Group financeiro = new Group("Financeiro");
        financeiro.addPermission("Inicio");
        AuthorizationManager.addGroup(financeiro);

        //SOLICITANTE
        Group solicitante = new Group("Solicitante");
        solicitante.addPermission("Inicio");
        AuthorizationManager.addGroup(solicitante);

        //ADMINISTRADOR
        Group administrador = new Group("Administrador");
        administrador.addPermission("Inicio");
        AuthorizationManager.addGroup(administrador);
    }

    @Override
    public void loadActions() {
        //Configurar App.
        ActionConfig ac;
        
        //Action de Inicio
        ac = new ActionConfig("Inicio", InicioAction.class);
        ac.addConsequence(SUCCESS, new Forward("jsp/inicio.page"));
        ac.addFilter(new AuthorizationFilter(new Permission("Inicio")));
        this.add(ac);

        //Autenticação
        ac = new ActionConfig("Login", LoginAction.class);
        ac.addConsequence(ERROR, new Redirect("/"));
        ac.addConsequence("Financeiro", new Redirect("Inicio.mtw"));
        ac.addConsequence("Solicitante", new Redirect("Inicio.mtw"));
        ac.addConsequence("Administrador", new Redirect("Inicio.mtw"));
        this.add(ac);

        //Logout
        ac = new ActionConfig("Logout", LogoutAction.class);
        ac.addConsequence(SUCCESS, new Redirect("/"));
        this.add(ac);
        
        //Meio de Transporte
        ac = new ActionConfig("TransporteRead", TransporteReadAction.class);
        ac.addConsequence(SUCCESS, new Forward("jsp/transporte/list.page"));
        this.add(ac);
        
        ac = new ActionConfig("TransporteShowForm", TransporteShowFormAction.class);
        ac.addConsequence("CREATE", new Forward("jsp/transporte/createForm.page"));
        ac.addConsequence("UPDATE", new Forward("jsp/transporte/updateForm.page"));
        this.add(ac);
        
        ac = new ActionConfig("TransporteCreate", TransporteCreateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("TransporteRead.mtw"));
        ac.addConsequence(ERROR, new Forward("jsp/transporte/createForm.page"));
        this.add(ac);
        
        ac = new ActionConfig("TransporteUpdate", TransporteUpdateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("TransporteRead.mtw"));
        ac.addConsequence(ERROR, new Forward("jsp/transporte/updateForm.page"));
        this.add(ac);

        ac = new ActionConfig("TransporteDelete", TransporteDeleteAction.class);
        ac.addConsequence(SUCCESS, new Redirect("TransporteRead.mtw"));
        this.add(ac);
        
    }
}