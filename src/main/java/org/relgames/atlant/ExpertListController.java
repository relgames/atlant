package org.relgames.atlant;

import org.relgames.atlant.persistence.PersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Oleg Poleshuk
 */
@Controller
public class ExpertListController {
    @Autowired
    private PersistenceService persistenceService;

    @RequestMapping("/*")
    public String doRequest() {
        return "expertList";
    }
}
