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


package com.ibm.ws.jaxws.ejbjndi.webejb.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ibm.ws.jaxws.ejbjndi.webejb.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Make_QNAME = new QName("http://common.ejbjndi.jaxws.ws.ibm.com/", "make");
    private final static QName _IsSupportedResponse_QNAME = new QName("http://common.ejbjndi.jaxws.ws.ibm.com/", "isSupportedResponse");
    private final static QName _MakeResponse_QNAME = new QName("http://common.ejbjndi.jaxws.ws.ibm.com/", "makeResponse");
    private final static QName _IsSupported_QNAME = new QName("http://common.ejbjndi.jaxws.ws.ibm.com/", "isSupported");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ibm.ws.jaxws.ejbjndi.webejb.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link IsSupported }
     * 
     */
    public IsSupported createIsSupported() {
        return new IsSupported();
    }

    /**
     * Create an instance of {@link IsSupportedResponse }
     * 
     */
    public IsSupportedResponse createIsSupportedResponse() {
        return new IsSupportedResponse();
    }

    /**
     * Create an instance of {@link MakeResponse }
     * 
     */
    public MakeResponse createMakeResponse() {
        return new MakeResponse();
    }

    /**
     * Create an instance of {@link Make }
     * 
     */
    public Make createMake() {
        return new Make();
    }

    /**
     * Create an instance of {@link Coffee }
     * 
     */
    public Coffee createCoffee() {
        return new Coffee();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Make }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://common.ejbjndi.jaxws.ws.ibm.com/", name = "make")
    public JAXBElement<Make> createMake(Make value) {
        return new JAXBElement<Make>(_Make_QNAME, Make.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsSupportedResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://common.ejbjndi.jaxws.ws.ibm.com/", name = "isSupportedResponse")
    public JAXBElement<IsSupportedResponse> createIsSupportedResponse(IsSupportedResponse value) {
        return new JAXBElement<IsSupportedResponse>(_IsSupportedResponse_QNAME, IsSupportedResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MakeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://common.ejbjndi.jaxws.ws.ibm.com/", name = "makeResponse")
    public JAXBElement<MakeResponse> createMakeResponse(MakeResponse value) {
        return new JAXBElement<MakeResponse>(_MakeResponse_QNAME, MakeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsSupported }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://common.ejbjndi.jaxws.ws.ibm.com/", name = "isSupported")
    public JAXBElement<IsSupported> createIsSupported(IsSupported value) {
        return new JAXBElement<IsSupported>(_IsSupported_QNAME, IsSupported.class, null, value);
    }

}
