/*******************************************************************************
 * Copyright (c) 2020 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ws.fat.grpc;

import static org.junit.Assert.assertNotNull;

import java.security.AccessController;
import java.security.PrivilegedAction;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;

import com.ibm.testapp.g3store.restConsumer.client.ConsumerEndpointFATServlet;
import com.ibm.testapp.g3store.restProducer.client.ProducerEndpointFATServlet;
import com.ibm.websphere.simplicity.ShrinkHelper;
import com.ibm.websphere.simplicity.log.Log;

import componenttest.annotation.Server;
import componenttest.annotation.TestServlet;
import componenttest.custom.junit.runner.FATRunner;
import componenttest.topology.impl.LibertyServer;
import componenttest.topology.utils.FATServletClient;

/**
 * @author anupag
 *
 */
@RunWith(FATRunner.class)
public class StoreServicesTests extends FATServletClient {

    protected static final Class<?> c = StoreServicesTests.class;

    @Rule
    public TestName name = new TestName();

    @Server("StoreServer")
    public static LibertyServer storeServer;

    @Server("ProducerServer")
    @TestServlet(servlet = ProducerEndpointFATServlet.class, contextRoot = "StoreProducerApp")
    public static LibertyServer producerServer;

    @Server("ConsumerServer")
    @TestServlet(servlet = ConsumerEndpointFATServlet.class, contextRoot = "StoreConsumerApp")
    public static LibertyServer consumerServer;

    private static String getSysProp(String key) {
        return AccessController.doPrivileged((PrivilegedAction<String>) () -> System.getProperty(key));
    }

    @BeforeClass
    public static void setUp() throws Exception {
        ShrinkHelper.defaultApp(storeServer, "StoreApp.war",
                                "com.ibm.testapp.g3store.cache",
                                "com.ibm.testapp.g3store.exception",
                                "com.ibm.testapp.g3store.interceptor",
                                "com.ibm.testapp.g3store.grpcservice",
                                "com.ibm.testapp.g3store.servletStore",
                                "com.ibm.testapp.g3store.utilsStore",
                                "com.ibm.test.g3store.grpc"); // add generated src

        ShrinkHelper.defaultDropinApp(producerServer, "StoreProducerApp.war",
                                      "com.ibm.testapp.g3store.grpcProducer.api",
                                      "com.ibm.testapp.g3store.exception",
                                      "com.ibm.testapp.g3store.restProducer",
                                      "com.ibm.testapp.g3store.restProducer.api",
                                      "com.ibm.testapp.g3store.restProducer.model",
                                      "com.ibm.testapp.g3store.restProducer.client",
                                      "com.ibm.testapp.g3store.servletProducer",
                                      "com.ibm.test.g3store.grpc"); // add generated src

        // Use defaultApp the <application> element is used in server.xml for security, cannot use dropin
        // The consumer tests needs to create data also , we will need to add producer files also
        ShrinkHelper.defaultApp(consumerServer, "StoreConsumerApp.war",
                                "com.ibm.testapp.g3store.grpcConsumer.api",
                                "com.ibm.testapp.g3store.grpcConsumer.security",
                                "com.ibm.testapp.g3store.exception",
                                "com.ibm.testapp.g3store.restConsumer",
                                "com.ibm.testapp.g3store.restConsumer.api",
                                "com.ibm.testapp.g3store.restConsumer.model",
                                "com.ibm.testapp.g3store.servletConsumer",
                                "com.ibm.testapp.g3store.utilsConsumer",
                                "com.ibm.testapp.g3store.restConsumer.client",
                                "com.ibm.testapp.g3store.grpcProducer.api",
                                "com.ibm.testapp.g3store.restProducer",
                                "com.ibm.testapp.g3store.restProducer.api",
                                "com.ibm.testapp.g3store.restProducer.model",
                                "com.ibm.testapp.g3store.servletProducer",
                                "com.ibm.test.g3store.grpc", // add generated src
                                "com.ibm.testapp.g3store.restProducer.client");

        storeServer.startServer(StoreServicesTests.class.getSimpleName() + ".log");
        assertNotNull("CWWKO0219I.*ssl not recieved", storeServer.waitForStringInLog("CWWKO0219I.*ssl"));

        producerServer.useSecondaryHTTPPort(); // sets httpSecondaryPort and httpSecondarySecurePort
        producerServer.startServer(StoreServicesTests.class.getSimpleName() + ".log");
        assertNotNull("CWWKO0219I.*ssl not recieved", producerServer.waitForStringInLog("CWWKO0219I.*ssl"));

        // set bvt.prop.member_1.http=8080 and bvt.prop.member_1.https=8081
        consumerServer.setHttpDefaultPort(Integer.parseInt(getSysProp("member_1.http")));
        int securePort = Integer.parseInt(getSysProp("member_1.https"));

        Log.info(StoreServicesTests.class, "setUp", "here is the secure port " + securePort);

        consumerServer.setHttpDefaultSecurePort(securePort);
        consumerServer.startServer(StoreServicesTests.class.getSimpleName() + ".log");
        assertNotNull("CWWKO0219I.*ssl not recieved", consumerServer.waitForStringInLog("CWWKO0219I.*ssl"));

    }

    //[07/31/2020 14:42:29:356 EDT] 001 LibertyServer                  checkLogsForErrorsAndWarnings  I Error/warning found in log ORIGINALLY: [7/31/20, 14:41:34:361 EDT] 00000038 m.ibm.ws.container.service.app.deploy.ManifestClassPathUtils W SRVE9967W: The manifest class path xml-apis.jar can not be found in jar file wsjar:file:/.../open-liberty/dev/build.image/wlp/usr/servers/StoreServer/apps/StoreApp.war!/WEB-INF/lib/serializer-2.7.2.jar or its parent.
    //[07/31/2020 14:42:29:356 EDT] 001 LibertyServer                  checkLogsForErrorsAndWarnings  I Error/warning found in log ORIGINALLY: [7/31/20, 14:41:34:449 EDT] 00000038 m.ibm.ws.container.service.app.deploy.ManifestClassPathUtils W SRVE9967W: The manifest class path xercesImpl.jar can not be found in jar file wsjar:file:/.../open-liberty/dev/build.image/wlp/usr/servers/StoreServer/apps/StoreApp.war!/WEB-INF/lib/xalan-2.7.2.jar or its parent.
    @AfterClass
    public static void tearDown() throws Exception {
        if (storeServer != null)
            storeServer.stopServer("SRVE9967W");
        if (producerServer != null)
            producerServer.stopServer();
        if (consumerServer != null)
            consumerServer.stopServer("SRVE9967W");
    }

    @Test
    public void testStoreWarStartWithGrpcService() throws Exception {
        Log.info(getClass(), "testStoreWarStartWithGrpcService", "Check if Store.war started");
        assertNotNull(storeServer.waitForStringInLog("CWWKZ0001I: Application StoreApp started"));

    }

    @Test
    public void testProducerWarStartWithGrpcService() throws Exception {
        Log.info(getClass(), "testProducerWarStartWithGrpcService", "Check if Prodcuer.war started");
        assertNotNull(producerServer.waitForStringInLog("CWWKZ0001I: Application StoreProducerApp started"));

    }

    @Test
    public void testConsumerWarStartWithGrpcService() throws Exception {
        Log.info(getClass(), "testConsumerWarStartWithGrpcService", "Check if Consumer.war started");
        assertNotNull(consumerServer.waitForStringInLog("CWWKZ0001I: Application StoreConsumerApp started"));

    }

}
