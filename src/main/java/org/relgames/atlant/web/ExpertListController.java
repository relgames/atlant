package org.relgames.atlant.web;

import org.relgames.atlant.persistence.PersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String doRequest(Model model) {
        model.addAttribute("experts", persistenceService.getExperts());
        model.addAttribute("lastUpdate", persistenceService.getLastUpdate());
        return "expertList";
    }
}
