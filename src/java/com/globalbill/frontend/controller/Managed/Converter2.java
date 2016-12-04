/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalbill.frontend.controller.Managed;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

public interface Converter2 {

    public static final String DATETIMECONVERTER_DEFAULT_TIMEZONE_IS_SYSTEM_TIMEZONE_PARAM_NAME = "javax.faces.DATETIMECONVERTER_DEFAULT_TIMEZONE_IS_SYSTEM_TIMEZONE";

    public Object getAsObject(FacesContext context, UIComponent component, String value);

    public int getAsInt(FacesContext context, UIComponent component, Object value);
}