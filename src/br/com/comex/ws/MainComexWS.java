package br.com.comex.ws;

import javax.xml.ws.Endpoint;

public class MainComexWS {
	public static void main(String[] args) {		
		String url = "http://localhost:8080/ComexWS";
	    ComexWS service = new ComexWS();

	    System.out.println("Servico Rodando" + url + "?wsdl");
	    Endpoint.publish(url, service);
	}
}