package org.relgames.atlant;

import org.relgames.atlant.persistence.Expert;
import org.relgames.atlant.persistence.PersistenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author Oleg Poleshuk
 */
@Service
public class UpdateService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PersistenceService persistenceService;

    @Scheduled(cron = "0 */5 * * * ?")
    public void update() {
        log.info("Updating...");
        persistenceService.addExpert(new Expert("1", "444", 20, ""));
    }
}
