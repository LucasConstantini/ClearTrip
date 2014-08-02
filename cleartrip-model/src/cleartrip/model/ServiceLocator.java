package cleartrip.model;

import cleartrip.model.base.service.BaseTransporteService;
import cleartrip.model.service.TransporteService;

public class ServiceLocator {

    public static BaseTransporteService getTransporteService() {
        return new TransporteService();
    }
}
