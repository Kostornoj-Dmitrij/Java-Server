package resourcesServices;

public class ResourceServerController implements ResourceServerControllerMBean {


    ResourceServer resource;

    public ResourceServerController() {
    }

    public ResourceServerController(ResourceServer resource) {
        this.resource = resource;
    }

    @Override
    public String getname() {
        return resource.getName();
    }

    @Override
    public int getage() {
        return resource.getAge();
    }

}