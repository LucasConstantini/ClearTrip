package cleartrip.controller.base;

import static org.mentawai.core.Action.ERROR;
import org.mentawai.core.BaseAction;

public abstract class BaseFormAction extends BaseAction {

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

    protected abstract String doGet() throws Exception;

    protected abstract String doPost() throws Exception;
}