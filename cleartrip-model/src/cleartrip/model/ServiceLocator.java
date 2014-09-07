package cleartrip.model;

import cleartrip.model.base.service.BaseAdministradorService;
import cleartrip.model.base.service.BaseFinanceiroService;
import cleartrip.model.base.service.BaseEmpresaService;
import cleartrip.model.base.service.BaseViagemService;
import cleartrip.model.base.service.BaseParametroService;
import cleartrip.model.base.service.BaseCategoriaDespesaService;
import cleartrip.model.base.service.BaseSolicitanteService;
import cleartrip.model.base.service.BaseDespesaService;
import cleartrip.model.base.service.BaseTransporteService;
import cleartrip.model.base.service.BaseUsuarioService;
import cleartrip.model.service.AdministradorService;
import cleartrip.model.service.FinanceiroService;
import cleartrip.model.service.EmpresaService;
import cleartrip.model.service.ViagemService;
import cleartrip.model.service.ParametroService;
import cleartrip.model.service.CategoriaDespesaService;
import cleartrip.model.service.SolicitanteService;
import cleartrip.model.service.DespesaService;
import cleartrip.model.service.TransporteService;
import cleartrip.model.service.UsuarioService;

public class ServiceLocator {

 
    public static BaseUsuarioService getUsuarioService() {
        return new UsuarioService();
    }

    public static BaseAdministradorService getAdministradorService() {
        return new AdministradorService();
    }

    public static BaseFinanceiroService getFinanceiroService() {
        return new FinanceiroService();
    }

    public static BaseSolicitanteService getSolicitanteService() {
        return new SolicitanteService();
    }
    public static BaseDespesaService getDespesaService() {
        return new DespesaService();
    }
    public static BaseViagemService getViagemService() {
        return new ViagemService();
    }
    public static BaseEmpresaService getEmpresaService() {
        return new EmpresaService();
    }
    public static BaseCategoriaDespesaService getCategoriaDespesaService() {
        return new CategoriaDespesaService();
    }
    public static BaseTransporteService getTransporteService() {
        return new TransporteService();
    }
    public static BaseParametroService getParametroService() {
        return new ParametroService();
    }
       
}
