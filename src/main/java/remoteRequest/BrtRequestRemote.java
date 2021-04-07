package remoteRequest;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.Properties;

import javax.ejb.Remote;
import javax.naming.InitialContext;
import javax.xml.rpc.ServiceException;

import customPojo.ResultSpedID;
import customPojo.Spedid_idCollo;
import customPojo.shipmentPojo.chiamate.ConfirmRequest;
import customPojo.shipmentPojo.chiamate.CreateRequest;
import customPojo.shipmentPojo.chiamate.DeleteRequest;
import customPojo.shipmentPojo.risposte.ConfirmResult;
import customPojo.shipmentPojo.risposte.CreateResult;
import customPojo.shipmentPojo.risposte.DeleteResult;
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
	 * Cancella Una spedizione creata con il metodo CreaSpedizione
	 * @param deleteRequest
	 * @return DeleteResult
	 * @throws IOException
	 */
	public DeleteResult CancellaSpedizione(DeleteRequest deleteRequest) throws IOException;
	
	
	/**
	 * Conferma una spedizione Creata con il metodo CreaSpedizione
	 * @param confirmRequest
	 * @return ConfirmResult
	 * @throws IOException
	 */
	public ConfirmResult ConfermaSpedizione(ConfirmRequest confirmRequest) throws IOException;
	
	/**
	 * Crea una spedizione con il metodo Rest Bartolini
	 * @param createRequest
	 * @return CreateResult
	 * @throws IOException
	 */
	public CreateResult CreaSpedizione(CreateRequest createRequest) throws IOException;
	
	
	/**
	 * 
	 * @param CLIENTE_ID id cliente
	 * @param RIFERIMENTO_MITTENTE_NUMERICO Riferimento numerico spedizione
	 * @return Risultato custompojo 
	 * @throws ServiceException exception
	 * @throws RemoteException remote exception
	 */
	public ResultSpedID GetSpedIDbyRMN(BigDecimal CLIENTE_ID,BigDecimal RIFERIMENTO_MITTENTE_NUMERICO)throws ServiceException, RemoteException;
	
	
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
	
	
	/**
	 * 
	 * @param CLIENTE_ID cliente
	 * @param RIFERIMENTO_MITTENTE_ALFABETICO Riferimento alfabetico spedizione
	 * @return Risultato custompojo 
	 * @throws ServiceException exception
	 * @throws RemoteException BRTError
	 */
	public ResultSpedID GetSpedIDbyRMA(BigDecimal CLIENTE_ID,String RIFERIMENTO_MITTENTE_ALFABETICO) throws ServiceException, RemoteException;
	
	
	
	
}
