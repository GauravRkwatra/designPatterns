package in.coderstuff.designPatterns.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Slf4j
@Profile("dev")
@Component
public class DevBean {

    public DevBean() {
        log.info("Dev Profile loaded");
    }
}
