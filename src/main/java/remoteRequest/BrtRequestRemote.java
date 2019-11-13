package remoteRequest;

import java.io.Serializable;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.Properties;

import javax.ejb.Remote;
import javax.naming.InitialContext;
import javax.xml.rpc.ServiceException;

import customPojo.Spedid_RMN;
import customPojo.Spedid_idCollo;
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
	 * @param CLIENTE_ID id cliente
	 * @param RIFERIMENTO_MITTENTE_NUMERICO Riferimento numerico spedizione
	 * @return Spedid_RMN pojo 
	 * @throws ServiceException exception
	 * @throws RemoteException remote exception
	 */
	public Spedid_RMN GetSpedIDbyRMN(BigDecimal CLIENTE_ID,BigDecimal RIFERIMENTO_MITTENTE_NUMERICO)throws ServiceException, RemoteException;
	
	
	/**
	 * 
	 * @param LINGUA_ISO639_ALPHA2 (it,fr,ecc...)
	 * @param SPEDIZIONE_ANNO anno di spedizione
	 * @param SPEDIZIONE_BRT_ID id bartolini
	 * @return Tracking_SpedID id tracking
	 * @throws ServiceException exception
	 * @throws RemoteException remote exception
	 */
	public Tracking_SpedID GetTrackingbySpedID(String LINGUA_ISO639_ALPHA2,String SPEDIZIONE_ANNO,String SPEDIZIONE_BRT_ID) throws ServiceException, RemoteException;

	
	/**
	 * 
	 * @param CLIENTE_ID id cliente
	 * @param IDCollo  id collo
	 * @return Spedid_idCollo pojo
	 * @throws ServiceException exception
	 * @throws RemoteException remote exception
	 */
	public Spedid_idCollo GetSpedIDbyIdCollo(BigDecimal CLIENTE_ID,String IDCollo) throws ServiceException, RemoteException;
	
	
	/**
	 * 
	 * @param LINGUA_ISO639_ALPHA2 (it,fr,ecc...)
	 * @param code codice ID Evento Spedizione (AVV,AV2,G09,ecc...)
	 * @return String Descrizione Evento
	 * @throws ServiceException Exception
	 * @throws RemoteException BRTError
	 */
	
	public String GetDescrizioneEvento (String LINGUA_ISO639_ALPHA2,String code) throws ServiceException, RemoteException;
	
	/**
	 * 
	 * @param LINGUA_ISO639_ALPHA2 (it,fr,ecc...)
	 * @param codiceEsito (0,1-11,ecc...)
	 * @return String Descrizione codice esito
	 * @throws ServiceException Exception
	 * @throws RemoteException BRTError
	 */
	public String GetDescrizioneEsito (String LINGUA_ISO639_ALPHA2,int codiceEsito) throws ServiceException, RemoteException;
}
