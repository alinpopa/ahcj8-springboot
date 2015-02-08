package ahcj8;

import org.glassfish.jersey.server.ResourceConfig;

public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(){
        register(Endpoint.class);
    }
}
