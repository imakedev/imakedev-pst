package th.co.aoe.imake.pst.xstream;

import java.io.Serializable;

import th.co.aoe.imake.pst.xstream.common.VServiceXML;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("PstObject")
public class PstObject extends VServiceXML implements Serializable {
	private static final long serialVersionUID = 1L;
	public PstObject() {
		 
	}
	public PstObject(String[] query) {
		super();
		this.query = query;
	}
	private String[] query;
	public String[] getQuery() {
		return query;
	}
	public void setQuery(String[] query) {
		this.query = query;
	}
	

}
