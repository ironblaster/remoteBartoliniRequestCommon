package customPojo;

import java.io.Serializable;

public class Spedid_idCollo implements Serializable {
		private int esito;
	    private short annoSpedizione;
	    private long iDSpedizione;
	    private int versione;
		public int getEsito() {
			return esito;
		}
		public void setEsito(int esito) {
			this.esito = esito;
		}
		public short getAnnoSpedizione() {
			return annoSpedizione;
		}
		public void setAnnoSpedizione(short annoSpedizione) {
			this.annoSpedizione = annoSpedizione;
		}
		public long getiDSpedizione() {
			return iDSpedizione;
		}
		public void setiDSpedizione(long iDSpedizione) {
			this.iDSpedizione = iDSpedizione;
		}
		public int getVersione() {
			return versione;
		}
		public void setVersione(int versione) {
			this.versione = versione;
		}

}
