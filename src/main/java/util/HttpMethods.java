package util;

import Entity.Response;

public interface HttpMethods {

    public void get () throws Exception;
    public Response add (String... args) throws Exception;
    public void update (String ...args);
    public void delete ();


}
