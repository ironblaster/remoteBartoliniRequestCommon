package remoteRequest;

import java.io.Serializable;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.Properties;

import javax.ejb.Remote;
import javax.naming.InitialContext;
import javax.xml.rpc.ServiceException;

import customPojo.Spedid_RMN;
import customPojo.trackingPojo.Tracking_SpedID;

/**
 *  per collegarsi a questo bean utilizzare la seguente sintassi:
 	Properties p = new Properties();
	p.put("java.naming.factory.initial", "org.apache.openejb.client.RemoteInitialContextFactory");
	p.put("java.naming.provider.url", "IP-SERVER:PORTATOMEE/tomee/ejb");
	InitialContext ctx = new InitialContext(p);
	BrtRequestRemote brt = (BrtRequestRemote) ctx.lookup("brtservice/BrtRequestRemote");
	
 	dal oggetto brt richiamare tutte le funzioni
 	
 	bisogna ovviamente importare anche la dipendenza nel pom
 * 
 * @author ironblaster
 */

@Remote
public interface BrtRequestRemote extends Serializable{
	
	
	/**
	 * 
	 * @param CLIENTE_ID
	 * @param RIFERIMENTO_MITTENTE_NUMERICO
	 * @return Spedid_RMN
	 * @throws ServiceException
	 * @throws RemoteException
	 */
	
	public Spedid_RMN GetSpedIDbyRMN(BigDecimal CLIENTE_ID,BigDecimal RIFERIMENTO_MITTENTE_NUMERICO)throws ServiceException, RemoteException;
	
	
	/**
	 * 
	 * @param LINGUA_ISO639_ALPHA2 (IT,EN,ecc...)
	 * @param SPEDIZIONE_ANNO
	 * @param SPEDIZIONE_BRT_ID
	 * @return Tracking_SpedID
	 * @throws ServiceException
	 * @throws RemoteException
	 */
	public Tracking_SpedID GetTrackingbySpedID(String LINGUA_ISO639_ALPHA2,String SPEDIZIONE_ANNO,String SPEDIZIONE_BRT_ID) throws ServiceException, RemoteException;

}
