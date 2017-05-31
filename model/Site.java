
package model;

import java.io.Serializable;

public class Site implements Serializable {
    private int code;// codigos unicos establecidos--- DANE
    private byte type;// {continente, pais, depatamento , municipio, corregimiento}
    private String name;
    private String abreviate;
    private byte level;
    private Site parent;

    public Site(int code, byte level, String name, String abreviate, Site parent) {
        this.code = code;
        this.level = level;
        this.name = name;
        this.abreviate = abreviate;
        this.parent = parent;
    }

    public int getCode() {
        return code;
    }

    public byte getLevel() {
        return level;
    }

    public void setLevel(byte level) {
        this.level = level;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbreviate() {
        return abreviate;
    }

    public void setAbreviate(String abreviate) {
        this.abreviate = abreviate;
    }

    public Site getParent() {
        return parent;
    }

    public void setParent(Site parent) {
        this.parent = parent;
    }
    /**
     * 1. 3 digitos pais
     * 2. 3 digitos deptp
     * 3. 3 digitos mun... 3 digitos 3 x nivel
     * @return
     */
    public int getFullCodeVer1(){
//    	System.out.println("nivel " + level);
    	System.out.println(parent);
    	// todo 
    	switch (level) {
    	//System.out.println("nivel ");
		case 1: return code;
		case 2 :return parent.code *1000 +code;	
		case 3 : return parent.parent.code*1000000 +parent.code*1000+code;
		case 4 : return parent.parent.parent.code*1000000000 + parent.parent.code*1000000 +parent.code*1000+code;
		default: return 0;
		}
    	
    }
    
    public long getFullCodeRecursive(long myCode, byte levelAux, long amount ){
    	long amount1 = 1000 ;
    	long myCode1 = myCode;
    	if(level == 1){
    		return code;
    	}else if(level  > levelAux){
    		System.out.println(level + " " +levelAux);
    		System.out.println(" entro " + myCode1 + " level " + levelAux + " amount " + amount);
    		amount1 *= amount;
    		System.out.println(" entro " + myCode1 + " level " + levelAux + " amount " + amount);
    		myCode1 += parent.code *amount1;
    		return getFullCodeRecursive(myCode1, (byte)(levelAux + 1), amount1);
    	}
    	return myCode1;
    	
    }
    
    public long getFullCodeMejorado(){
    	// todo 
    	long myCode =1;
    	switch (level) {
		case 1: myCode =  code;
		case 2 : myCode = parent.code *1000 +code;	
		case 3 : myCode =parent.parent.code*1000000 +parent.code*1000+code;
		case 4 : myCode = parent.parent.parent.code*1000000000 + parent.parent.code*1000000 +parent.code*1000+code;
		default: myCode = 0;
		}
    	return myCode;
    }
    
    public long getFullCodeFabian() {
    	long power = 1;
    	long fullCode = this.code;
    	Site auxSite =this.parent;
    	for (int i = 1; i < this.level && level > 1; i++) {
			power *= 1000;
			fullCode += auxSite.code*power;
			auxSite = auxSite.parent;
		}
    	return fullCode;
    }
    
}
