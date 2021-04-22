

package br.com.rpolnx.quarkus_basics.controller;

import java.math.BigDecimal;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/main")
public class BasicController {

    @GET
    public String doSomeShit() {
        return String.valueOf(BigDecimal.TEN.floatValue());
    }
    
}