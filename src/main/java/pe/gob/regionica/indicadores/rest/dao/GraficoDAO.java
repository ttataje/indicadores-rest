package pe.gob.regionica.indicadores.rest.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.regionica.indicadores.rest.bean.Grafico;

@Repository
public class GraficoDAO {
	
	private SessionFactory sessionFactory;
	 
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public GraficoDAO() {
		super();
	}
	
	public GraficoDAO(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Grafico> list() {
		Session session = getSessionFactory().getCurrentSession();
		List<Grafico> list = session.createQuery("from Grafico as g ORDER BY g.descripcion").getResultList();
		return list;
	}

	public Grafico get(Long id) {
		Session session = getSessionFactory().getCurrentSession();
		Grafico grafico = session.get(Grafico.class, id);
		return grafico;
	}

	public void save(Grafico grafico){
		Session session = getSessionFactory().getCurrentSession();
		session.save(grafico);
	}

	public void update(Grafico grafico){
		Session session = getSessionFactory().getCurrentSession();
		session.update(grafico);
	}
	
	public void delete(Grafico grafico){
		Session session = getSessionFactory().getCurrentSession();
		session.delete(grafico);
	}
}
