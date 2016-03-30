package com.kirkk.loancalc.rest;

import com.kirkk.loancalc.domain.LoanCalculator;
import com.kirkk.loancalc.domain.Payment;
import com.kirkk.loancalc.Roles;
import org.joda.time.DateTime;
import restx.annotations.GET;
import restx.annotations.POST;
import restx.annotations.RestxResource;
import restx.factory.Component;
import restx.security.PermitAll;
import restx.security.RolesAllowed;
import restx.security.RestxSession;

import javax.validation.constraints.NotNull;

@Component @RestxResource
public class LoanResource {

    /**
     * Say hello to anybody.
     *
     * Does not require authentication.
     *
     * @return a Message to say hello
     */
    @GET("/loan")
    @PermitAll
    public Payment loan(String principle, String rate, String term) {
    	return new Payment().setPayment(new LoanCalculator().calculatePayment(principle, rate, term));
    }

}
