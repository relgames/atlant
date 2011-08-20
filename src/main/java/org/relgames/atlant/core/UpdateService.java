package org.relgames.atlant.core;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.relgames.atlant.persistence.Expert;
import org.relgames.atlant.persistence.PersistenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.net.URL;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Oleg Poleshuk
 */
@Service
public class UpdateService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PersistenceService persistenceService;

    @Value("${url}")
    private String url;

    @Value("${regexp}")
    private String regexp;

    private Pattern pattern;

    @PostConstruct
    public void init() {
        pattern = Pattern.compile(regexp);
    }

    public void update() throws Exception {
        final URL urlConnection = new URL(url);
        String jsonString = IOUtils.toString(urlConnection.openStream());
        jsonString = jsonString.substring(1, jsonString.length()-1);

        //log.debug(data);
        JSONParser parser = new JSONParser();
        try {
            JSONObject obj = (JSONObject)parser.parse(jsonString);
            JSONObject data = (JSONObject)obj.get("data");
            String content = data.get("content").toString();

            content = content.replaceAll("\n", "");
            content = content.replaceAll("\r", "");
            //log.debug("Content: {}", content);

            Matcher m = pattern.matcher(content);
            while (m.find()) {
                final int size = persistenceService.getSize();
                final Expert expert = new Expert(m.group(2), m.group(1), Integer.parseInt(m.group(3)), "");
                persistenceService.addExpert(expert);
                if (persistenceService.getSize() != size) {
                    log.info("Found new expert: {}", expert);
                }
            }

        } catch (ParseException pe) {
            log.error("JSON error: " + pe.toString(), pe);
            throw pe;
        }
    }

    @Value("${loopCount}")
    private int loopCount;

    @Scheduled(fixedDelay = 5 * 60 * 1000) // 5 minutes
    public void updateLoop() throws Exception {
        for (int i=1; i<=loopCount; i++) {
            log.info("Iteration {} of {}", i, loopCount);
            update();
        }
    }

    public static void main(String[] args) throws Exception{
        ApplicationContext context = new ClassPathXmlApplicationContext("test-context.xml");
        UpdateService updateService = context.getBean(UpdateService.class);
        updateService.updateLoop();

        PersistenceService persistenceService = context.getBean(PersistenceService.class);
        List<Expert> experts= persistenceService.getExperts();
        for (Expert expert: experts) {
            System.out.println(expert);
        }
    }
}
