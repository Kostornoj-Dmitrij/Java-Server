package resourcesServices;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import resources.ResourceFactory;
import resources.TestResource;


public class ResourceServerImpl implements ResourceServer {
    static final Logger logger = LogManager.getLogger(ResourceServer.class.getName());

    TestResource testResource;

    public ResourceServerImpl() {
    }

    @Override
    public String getName() {
        return testResource.getName();
    }

    @Override
    public int getAge() {
        return testResource.getAge();
    }

    @Override
    public void readResource(String path) {
        testResource = ResourceFactory.instance().getResource(path, TestResource.class);
        logger.info("Resource loaded");
    }
}
