package org.relgames.atlant;

import org.junit.Test;
import org.relgames.atlant.persistence.Expert;
import org.relgames.atlant.persistence.PersistenceService;

import static junit.framework.Assert.assertEquals;

/**
 * @author relgames
 */
public class PersistenceServiceTest {
    @Test
    public void testSameId() {
        PersistenceService persistenceService = new PersistenceService();
        persistenceService.addExpert(new Expert("0001", "Vasia", 20, ""));
        persistenceService.addExpert(new Expert("0001", "Vasia", 21, ""));
        assertEquals(1, persistenceService.getExperts().size());

    }
}
