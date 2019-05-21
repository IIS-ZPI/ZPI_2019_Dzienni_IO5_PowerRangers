package Endpoints;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import providers.NbpProvider;
import providers.data.NbpTableA;

@Controller
public class NbpTableController {

    private NbpProvider nbpProvider;

    @RequestMapping(method = RequestMethod.GET,value = "/GET")
    @ResponseBody
    public NbpTableA getNbpTableAEndPoint(){
        nbpProvider = new NbpProvider();
        return nbpProvider.getNbpTableA().get(0);
    }
}
