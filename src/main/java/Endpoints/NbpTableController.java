package Endpoints;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import providers.NbpProvider;
import providers.data.NbpTableA;

@RestController
public class NbpTableController {

    private NbpProvider nbpProvider;

    @Autowired
    public NbpTableController(NbpProvider nbpProvider) {
        this.nbpProvider = nbpProvider;
    }

    @RequestMapping(method = RequestMethod.GET,value = "/GET")
    public NbpTableA getNbpTableAEndPoint(){
        nbpProvider = new NbpProvider();
        return nbpProvider.getNbpTableA().get(0);
    }
}
