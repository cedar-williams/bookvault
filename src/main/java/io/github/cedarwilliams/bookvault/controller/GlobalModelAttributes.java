package io.github.cedarwilliams.bookvault.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/** Provides application wide model attributes access */
@ControllerAdvice
public class GlobalModelAttributes {

    @ModelAttribute("siteName")
    public String siteName(@Value("${app.site.name}") String siteName){
        return siteName;
    }

}
