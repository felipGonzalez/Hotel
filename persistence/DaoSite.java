package persistence;

import model.Site;

public class DaoSite {

    public static final int RECORD_SIZE = 37;
    public static final int NAME_LENGHT = 20;
    public static final int ABREVIATE_LENGHT = 4;
    public static final int RECORD_NULL = -1;	
    
    private int code;// 4 codigos unicos establecidos--- DANE
    private byte level;// 1 {continente, pais, depatamento , municipio, corregimiento}
    private byte[] name;//20
    private byte[] abreviate;//4
    private long codeParent;//8

    public DaoSite() {
    	
    }
    
    public DaoSite(Site site) {
        this.code = site.getCode();
        this.level = site.getLevel();
        this.name = stringToArray(site.getName(), NAME_LENGHT);
        this.abreviate = stringToArray(site.getAbreviate(), ABREVIATE_LENGHT);
        this.codeParent = (site.getParent()== null)?RECORD_NULL: site.getParent().getFullCodeVer1();
    }
    
    public DaoSite(int code, byte level, String name, String abreviate, Site parent) {
        this.code = code;
        this.level = level;
        this.name = stringToArray(name, NAME_LENGHT);
        this.abreviate = stringToArray(abreviate, ABREVIATE_LENGHT);
        this.codeParent = (parent == null)?RECORD_NULL: parent.getFullCodeVer1();
    }

    private  byte [] stringToArray(String string, int size){
    	byte [] array = new byte[size];
    	for (int i = 0; i < Math.min(string.length(), size); i++) {
    		array[i] = (byte)string.charAt(i);
        }
    	
    	return array;
    }
    
    public void setName(String name) {
        this.name = stringToArray(name, NAME_LENGHT);
    }

    public void setAbreviate(String name) {
    	this.abreviate = stringToArray(name, ABREVIATE_LENGHT);
    }
    
    private String arrayToString(byte [] array, int size) {
    	String string = "";
    	for (int i = 0; i < size; i++) {
            string += (char)array[i];
        }
    	return string;
    }
      
   public Site getSite() {
	   return new Site(this.code,
			   this.level, 
			   this.getNameString(), 
			   this.getAbreviateString(),
			   null);
   }
    
    public String getNameString() {
    	return arrayToString(this.name, NAME_LENGHT);
    }

    public String getAbreviateString() {
        return arrayToString(this.abreviate, ABREVIATE_LENGHT);
    }

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public byte getLevel() {
		return level;
	}

	public void setLevel(byte level) {
		this.level = level;
	}

	public long getCodeParent() {
		return codeParent;
	}

	public void setCodeParent(long codeParent) {
		this.codeParent = codeParent;
	}

	public void setName1(byte[] name) {
		this.name = name;
	}

	public void setAbreviate1(byte[] abreviate) {
		this.abreviate = abreviate;
	}

	public byte[] getName() {
		return name;
	}

	public byte[] getAbreviate() {
		return abreviate;
	}
	
	
  
}
