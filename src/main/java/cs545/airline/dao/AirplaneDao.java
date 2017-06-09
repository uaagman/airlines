package cs545.airline.dao;

import cs545.airline.model.Airplane;
import edu.mum.gf.workaround.JpaUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Named
@ApplicationScoped
public class AirplaneDao {

    //	@PersistenceContext(unitName = "cs545")
//	private static EntityManager entityManager;
//  Couldn't figure out another way to inject the persistence context
    private EntityManager entityManager = JpaUtil.getEntityManager();

    public void create(Airplane airplane) {
        if(!entityManager.getTransaction().isActive())
            entityManager.getTransaction().begin();

        entityManager.persist(airplane);

        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    public Airplane update(Airplane airplane) {
        if(!entityManager.getTransaction().isActive())
            entityManager.getTransaction().begin();

        Airplane airplane1 = entityManager.merge(airplane);

        entityManager.flush();
        entityManager.getTransaction().commit();
        return airplane1;
    }

    public void delete(Airplane airplane) {
        if(!entityManager.getTransaction().isActive())
            entityManager.getTransaction().begin();

        entityManager.remove(airplane);

        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    public Airplane findOne(long id) {
        return entityManager.find(Airplane.class, id);
    }

    public Airplane findOneBySerialnr(String sno) {
        Query query = entityManager.createQuery("select a from Airplane a where a.serialnr=:serial", Airplane.class);
        query.setParameter("serial", sno);

        return (Airplane) query.getSingleResult();
    }

    @SuppressWarnings("unchecked")
    public List<Airplane> findByModel(String model) {
        Query query = entityManager.createQuery("select a from Airplane a where a.model=:model", Airplane.class);
        query.setParameter("model", model);

        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Airplane> findByFlight(long flightId) {
        Query query = entityManager
                .createQuery("select distinct a from Airplane a join a.flights f where f.id=:flightId", Airplane.class);
        query.setParameter("flightId", flightId);

        return query.getResultList();
    }

    public List<Airplane> findAll() {
        return entityManager.createQuery("select a from Airplane a", Airplane.class).getResultList();
    }

}
