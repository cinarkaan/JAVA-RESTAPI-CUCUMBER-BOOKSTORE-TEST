package util;

import Entity.Response;

public interface HttpMethods {

    public Response get () throws Exception;
    public Response add (String... args) throws Exception;
    public void update (String ...args);
    public Response delete (String... args) throws Exception;


}
