package cleartrip.controller;

import cleartrip.controller.action.TesteAction;
import cleartrip.controller.action.transporte.TransporteCreateAction;
import cleartrip.controller.action.transporte.TransporteReadAction;
import cleartrip.controller.action.transporte.TransporteShowFormAction;
import cleartrip.controller.action.transporte.TransporteDeleteAction;
import cleartrip.controller.action.transporte.TransporteUpdateAction;
import org.mentawai.core.ActionConfig;
import org.mentawai.core.ApplicationManager;
import static org.mentawai.core.ApplicationManager.ERROR;
import static org.mentawai.core.ApplicationManager.SUCCESS;
import org.mentawai.core.Forward;
import org.mentawai.core.Redirect;

public class AppManager extends ApplicationManager {

    @Override
    public void loadActions() {
        //Configurar App.
        ActionConfig ac;
        
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