package org.unicase.workspace.connectionmanager.xmlrpc;

import java.io.IOException;
import java.io.InputStream;
import java.net.Proxy;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcSun15HttpTransport;
import org.apache.xmlrpc.client.XmlRpcSun15HttpTransportFactory;
import org.apache.xmlrpc.client.XmlRpcTransport;
import org.xml.sax.SAXException;

public class CustomXmlRpcCommonsTransportFactory extends XmlRpcSun15HttpTransportFactory {

	public CustomXmlRpcCommonsTransportFactory(XmlRpcClient pClient) {
		super(pClient);
	}

	private Proxy proxy;

	@Override
	public void setProxy(Proxy pProxy) {
		proxy = pProxy;
	}

	@Override
	public XmlRpcTransport getTransport() {
		LoggingTransport transport = new LoggingTransport(getClient());
		transport.setSSLSocketFactory(getSSLSocketFactory());
		transport.setProxy(proxy);
		return transport;
	}

	private class LoggingTransport extends XmlRpcSun15HttpTransport {

		public LoggingTransport(XmlRpcClient pClient) {
			super(pClient);
		}

		/**
		 * Logs the request content in addition to the actual work.
		 */
		@Override
		protected void writeRequest(final ReqWriter pWriter) throws XmlRpcException, SAXException, IOException {
			super.writeRequest(pWriter);
			// System.out.println(method.getRequestEntity());
			System.out.println("OutputStream: " + getURLConnection().getOutputStream() + "\n");
		}

		/**
		 * Logs the response from the server, and returns the contents of the response as a ByteArrayInputStream.
		 */
		@Override
		protected InputStream getInputStream() throws XmlRpcException {
			InputStream istream = super.getInputStream();
			/*
			 * try { BufferedReader reader = new BufferedReader(new InputStreamReader(istream, "UTF-8")); StringBuilder
			 * sb = new StringBuilder(); String line; while ((line = reader.readLine()) != null) {
			 * sb.append(line).append("\n"); } // Print the content of data.txt System.out.println("InputStream: " +
			 * sb.toString() + "\n"); } catch (UnsupportedEncodingException e) { e.printStackTrace(); } catch
			 * (IOException e) { e.printStackTrace(); }
			 */
			return istream;
		}
	}
}
