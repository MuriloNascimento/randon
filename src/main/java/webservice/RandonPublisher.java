package webservice;

import javax.xml.ws.Endpoint;

public class RandonPublisher {

	public static void main(String[] args) {
		System.out.println("Randon web service start ...");
		Randon randon = new Randon();
		Endpoint.publish("http://localhost:9090/randon", randon);

	}

}
