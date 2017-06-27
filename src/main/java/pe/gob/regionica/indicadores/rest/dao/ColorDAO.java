package pe.gob.regionica.indicadores.rest.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.regionica.indicadores.rest.bean.Color;

@Repository
public class ColorDAO {

	private SessionFactory sessionFactory;
	 
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public ColorDAO() {
		super();
	}
	 
	public ColorDAO(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Color> list() {
		Session session = getSessionFactory().getCurrentSession();
		List<Color> list = session.createQuery("from Color").getResultList();
		return list;
	}
}
