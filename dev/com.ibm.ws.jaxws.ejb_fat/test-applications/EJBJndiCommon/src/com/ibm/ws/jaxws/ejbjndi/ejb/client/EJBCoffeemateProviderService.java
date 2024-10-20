/*******************************************************************************
 * Copyright (c) 2023 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/

package com.ibm.ws.jaxws.ejbjndi.ejb.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "EJBCoffeemateProviderService", targetNamespace = "http://ejb.ejbjndi.jaxws.ws.ibm.com/", wsdlLocation = "META-INF/EJBCoffeemateProviderService.wsdl")
public class EJBCoffeemateProviderService
                extends Service
{

    private final static URL EJBCOFFEEMATEPROVIDERSERVICE_WSDL_LOCATION;
    private final static WebServiceException EJBCOFFEEMATEPROVIDERSERVICE_EXCEPTION;
    private final static QName EJBCOFFEEMATEPROVIDERSERVICE_QNAME = new QName("http://ejb.ejbjndi.jaxws.ws.ibm.com/", "EJBCoffeemateProviderService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://ivan-pc:8010/EJBJndiEJB/EJBCoffeemateProviderService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        EJBCOFFEEMATEPROVIDERSERVICE_WSDL_LOCATION = url;
        EJBCOFFEEMATEPROVIDERSERVICE_EXCEPTION = e;
    }

    public EJBCoffeemateProviderService() {
        super(__getWsdlLocation(), EJBCOFFEEMATEPROVIDERSERVICE_QNAME);
    }

    public EJBCoffeemateProviderService(WebServiceFeature... features) {
        super(__getWsdlLocation(), EJBCOFFEEMATEPROVIDERSERVICE_QNAME, features);
    }

    public EJBCoffeemateProviderService(URL wsdlLocation) {
        super(wsdlLocation, EJBCOFFEEMATEPROVIDERSERVICE_QNAME);
    }

    public EJBCoffeemateProviderService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, EJBCOFFEEMATEPROVIDERSERVICE_QNAME, features);
    }

    public EJBCoffeemateProviderService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EJBCoffeemateProviderService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *         returns CoffeemateProvider
     */
    @WebEndpoint(name = "EJBCoffeemateProviderPort")
    public CoffeemateProvider getEJBCoffeemateProviderPort() {
        return super.getPort(new QName("http://ejb.ejbjndi.jaxws.ws.ibm.com/", "EJBCoffeemateProviderPort"), CoffeemateProvider.class);
    }

    /**
     * 
     * @param features
     *            A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy. Supported features not in the <code>features</code> parameter will have their default
     *            values.
     * @return
     *         returns CoffeemateProvider
     */
    @WebEndpoint(name = "EJBCoffeemateProviderPort")
    public CoffeemateProvider getEJBCoffeemateProviderPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ejb.ejbjndi.jaxws.ws.ibm.com/", "EJBCoffeemateProviderPort"), CoffeemateProvider.class, features);
    }

    private static URL __getWsdlLocation() {
        if (EJBCOFFEEMATEPROVIDERSERVICE_EXCEPTION != null) {
            throw EJBCOFFEEMATEPROVIDERSERVICE_EXCEPTION;
        }
        return EJBCOFFEEMATEPROVIDERSERVICE_WSDL_LOCATION;
    }

}
