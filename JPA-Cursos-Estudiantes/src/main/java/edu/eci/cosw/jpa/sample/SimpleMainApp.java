/*
 * Copyright (C) 2016 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.cosw.jpa.sample;

import edu.eci.cosw.jpa.sample.model.Curso;
import edu.eci.cosw.jpa.sample.model.Estudiante;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author hcadavid
 */
public class SimpleMainApp {
   
    public static void main(String a[]){
        SessionFactory sf=getSessionFactory();
        Session s=sf.openSession();
        Transaction tx=s.beginTransaction();
        Curso cosw = new Curso(4, "Construccion de software", "COSW");
        Curso pgr2 = new Curso(5, "Proyecto de grado 2", "PGR2");
        Estudiante jc = new Estudiante(2103021, "Juan");
        Estudiante ag = new Estudiante(2110111, "Alejandra");
        
        Set<Curso> sc = new HashSet<>();
        sc.add(cosw);
        sc.add(pgr2);
        Set<Estudiante> se = new HashSet<>();
        se.add(ag);
        se.add(jc);
        
        jc.setCursos(sc);
        ag.setCursos(sc);
        
        cosw.setEstudianteses(se);
        pgr2.setEstudianteses(se);
        
        s.saveOrUpdate(jc);
        s.saveOrUpdate(ag);
        s.saveOrUpdate(cosw);
        s.saveOrUpdate(pgr2);
        
        
        
        tx.commit(); 
        s.close();
        sf.close();
    }

    public static SessionFactory getSessionFactory() {
        // loads configuration and mappings
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistry
                = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        // builds a session factory from the service registry
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }

}
