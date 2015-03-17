In order to encrypt the transport layer, both, server and client require a keystore containing the private/public key. The server keystore is stored in the EMFStore data directory (default: `<userhome>`/.emfstore/server/profiles/default). The client keystore is stored in the client data directory (default: `<userhome>`/.emfstore/client/profiles/default). Just generate the keys following the documentation and then copy them to the given directories.

Let's start with creating the server's keystore and the private key. Therefore we use the keytool distributed with java's jdk.
Use the keytool with following parameters:

keytool -genkey -keyalg RSA -keystore emfstoreServer.keystore -alias emfstoreServer

Then follow the instructions.

Note: You have to name your keystore emfstoreServer.keystore, otherwise the server won't find it. Keytool requests a password, this password has to correspond with the keystore password specified in your server configuration.

![http://unicase.googlecode.com/files/0ed86.png](http://unicase.googlecode.com/files/0ed86.png)
<br>
<br>
In the next step you have to export the server's public key:<br>
<br>
keytool -export -rfc -keystore emfstoreServer.keystore -alias emfstoreServer -file emfstoreServer.public-key.<br>
<br>
<img src='http://unicase.googlecode.com/files/a0decED.png' />
<br>
<br>
If you want to deploy the client and ship an initial keystore there is one more step left, otherwise you can publish the public key and use the - planned - import function of the client.<br>
<br>
<br>
To create an initial keystore for the client again use the keytool:<br>
<br>
keytool -import -alias "youralias" -keystore emfstoreClient.keystore -file emfstoreServer.public-key<br>
<br>
and follow the instructions.<br>
<br>
Note: As password for the client's keystore use the password specified in <code>KeyStoreManager</code> in the workspace plugin. And you can use any format for your alias<br>
<br>
<img src='http://unicase.googlecode.com/files/cc022.png' />
<br>
<br>
And then feel safe ;)<br>
<br>
These certificates are also used to encrypt client's password stored in the user's profile. So only the server is able to decrypt and validate them. This allows to avoid saving them in clear text.