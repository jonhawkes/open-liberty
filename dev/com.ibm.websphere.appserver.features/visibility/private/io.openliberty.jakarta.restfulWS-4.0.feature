-include= ~${workspace}/cnf/resources/bnd/feature.props
symbolicName=io.openliberty.jakarta.restfulWS-4.0
visibility=private
singleton=true
IBM-App-ForceRestart: uninstall, \
 install
IBM-Process-Types: client, \
 server
Subsystem-Name: Jakarta RESTful Web Services 4.0
-features=com.ibm.websphere.appserver.eeCompatible-11.0
-bundles=\
  io.openliberty.jakarta.restfulWS.4.0;location:="dev/api/spec/,lib/"; mavenCoordinates="jakarta.ws.rs:jakarta.ws.rs-api:4.0.0"
kind=beta
edition=core
WLP-Activation-Type: parallel
