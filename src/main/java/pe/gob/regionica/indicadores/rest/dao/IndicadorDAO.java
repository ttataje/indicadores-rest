package pe.gob.regionica.indicadores.rest.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.regionica.indicadores.rest.bean.Indicador;

@SuppressWarnings("unchecked")
@Repository
public class IndicadorDAO {
	
	private SessionFactory sessionFactory;
	 
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public IndicadorDAO() {
		super();
	}

	public IndicadorDAO(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Indicador> list() {
		Session session = getSessionFactory().getCurrentSession();
		List<Indicador> list = session.createQuery("from Indicador order by codigo").getResultList();
		return list;
	}
	
	public List<Indicador> getByParent(Long codigo) {
		Session session = getSessionFactory().getCurrentSession();
		List<Indicador> list = (codigo != null ? session.createQuery("from Indicador where padre=:codigo order by codigo").setParameter("codigo", codigo) : session.createQuery("from Indicador where padre is null order by position")).getResultList();
		return list;
	}
	
	public Indicador get(Long codigo) {
		Session session = getSessionFactory().getCurrentSession();
		return (Indicador) session.createQuery("from Indicador where codigo=:codigo order by codigo").setParameter("codigo", codigo).getSingleResult();
	}

	public Serializable save(Indicador indicador){
		Session session = getSessionFactory().getCurrentSession();
		return session.save(indicador);
	}

	public void update(Indicador indicador){
		Session session = getSessionFactory().getCurrentSession();
		session.update(indicador);
	}
	
	public void delete(Indicador indicador){
		Session session = getSessionFactory().getCurrentSession();
		session.delete(indicador);
	}
}
