/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import model.Site;
import persistence.DaoSite;

/**
 *
 * @author EQUIPO-PC
 */
public class TestDaoSite {

    public static void main(String[] args) {
        String name = "tunjaa";
        String namelongo = "tunjaaaaaaaaaaaaaaaaaaaaaaaaaa";
        Site site0 = new Site(57, (byte) 1, "Colombia", "Col", null);
		Site site1 = new Site(15001, (byte) 3, "tunja", "TUN", null);
		Site site2 = new Site(15, (byte) 2, "Boyaca", "BYC", site0);
		site1.setParent(site2);
		
        char[] myname2 = {'t', 'u', 'n', 'j', 'a'};
              
        DaoSite daoSite = new DaoSite(site0);
        
        DaoSite daoSite3 = new DaoSite(1, (byte) 2, name, null, null);
        DaoSite daoSite4 = new DaoSite(1, (byte) 2, namelongo, null, null);
        daoSite3.setName(name);
        System.out.println("name " + daoSite3.getName() + "   ");
        daoSite4.setName(namelongo);
        System.out.println("name " + daoSite4.getName() + "   ");

    }
}
