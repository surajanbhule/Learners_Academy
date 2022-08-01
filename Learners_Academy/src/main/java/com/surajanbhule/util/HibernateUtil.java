package com.surajanbhule.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static StandardServiceRegistry standardServiceRegistry;
	private static SessionFactory sessionFactory;
	
	static {
		try {
		if(sessionFactory==null) {
			standardServiceRegistry=new StandardServiceRegistryBuilder().configure().build();
			MetadataSources mdts=new MetadataSources(standardServiceRegistry);
			Metadata metaData= mdts.getMetadataBuilder().build();
			sessionFactory=metaData.getSessionFactoryBuilder().build();
		}
		}catch (Exception e) {
			e.printStackTrace();
			if(standardServiceRegistry!=null)
				standardServiceRegistry.close();
		}
	}
	


	public static SessionFactory getSessionFactory() {
		// TODO Auto-generated method stub
		return sessionFactory;
	}
}
