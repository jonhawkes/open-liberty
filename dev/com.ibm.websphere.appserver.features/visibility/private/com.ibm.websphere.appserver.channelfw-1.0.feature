-include= ~${workspace}/cnf/resources/bnd/feature.props
symbolicName=com.ibm.websphere.appserver.channelfw-1.0
WLP-DisableAllFeatures-OnConflict: false
IBM-API-Package: com.ibm.websphere.endpoint; type="ibm-api"
IBM-Process-Types: server, \
 client
-features=com.ibm.ws.wsbytebuffer-1.0
-bundles=com.ibm.ws.timer, \
 com.ibm.ws.channelfw
-jars=com.ibm.websphere.appserver.api.endpoint; location:=dev/api/ibm/
-files=dev/api/ibm/javadoc/com.ibm.websphere.appserver.api.endpoint_1.0-javadoc.zip
kind=ga
edition=core
WLP-Activation-Type: parallel
