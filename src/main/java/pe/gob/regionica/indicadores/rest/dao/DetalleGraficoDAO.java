package pe.gob.regionica.indicadores.rest.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.regionica.indicadores.rest.bean.DetalleGrafico;

@Repository
@SuppressWarnings("unchecked")
public class DetalleGraficoDAO {
	
	private SessionFactory sessionFactory;
	 
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public DetalleGraficoDAO() {
		super();
	}
	
	public DetalleGraficoDAO(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public DetalleGrafico get(Long codigo) {
		Session session = getSessionFactory().getCurrentSession();
		DetalleGrafico detalleGrafico = null;
		try{
			detalleGrafico = (DetalleGrafico)session.createQuery("from DetalleGrafico where codigo = :codigo").setParameter("codigo", codigo).getSingleResult();
		}catch(Exception e){}
		return detalleGrafico;
	}

	public List<DetalleGrafico> getByParent(Long codigo) {
		Session session = getSessionFactory().getCurrentSession();
		List<DetalleGrafico> detalleGrafico = null;
		try{
			detalleGrafico = session.createQuery("from DetalleGrafico where padre = :padre").setParameter("padre", codigo).getResultList();
		}catch(Exception e){}
		return detalleGrafico;
	}

	public List<DetalleGrafico> getByChart(Long codigo) {
		Session session = getSessionFactory().getCurrentSession();
		List<DetalleGrafico> detalleGrafico = null;
		try{
			detalleGrafico = session.createQuery("from DetalleGrafico where grafico = :grafico").setParameter("grafico", codigo).getResultList();
		}catch(Exception e){}
		return detalleGrafico;
	}
	
	public Serializable save(DetalleGrafico detalleGrafico){
		Session session = getSessionFactory().getCurrentSession();
		return session.save(detalleGrafico);
	}

	public void update(DetalleGrafico detalleGrafico){
		Session session = getSessionFactory().getCurrentSession();
		session.update(detalleGrafico);
	}
	
	public void delete(DetalleGrafico detalleGrafico){
		Session session = getSessionFactory().getCurrentSession();
		session.delete(detalleGrafico);
	}
}
