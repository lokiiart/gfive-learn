package com.springapp.mvc.dao;

import com.springapp.mvc.model.Gps;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by loki on 3/31/15.
 */
public class GpsDAOImpl implements GpsDAO{
    private static final Logger logger = LoggerFactory.getLogger(GpsDAOImpl.class);

    private SessionFactory sessionFactory;


    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addGps(Gps g) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(g);
        logger.info("Gps saved successfully, Gps Details="+g);
        //TODO 把LOG4j组件挂上来调通
    }

    @Override
    public void updateGps(Gps g) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(g);
        logger.info("Gps updated successfully, Gps Details="+g);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Gps> listGpss() {
        Session session = this.sessionFactory.getCurrentSession();
        //TODO 了解这个orm的用法
        List<Gps> gpssList = session.createQuery("from Gps").list();
        for(Gps g : gpssList){
            logger.info("Gps List::"+g);
        }
        return gpssList;
    }

    @Override
    public Gps getGpsById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Gps g = (Gps) session.load(Gps.class, new Integer(id));
        logger.info("Gps loaded successfully, Gps details="+g);
        return g;
    }

    @Override
    public void removeGps(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Gps g = (Gps) session.load(Gps.class, new Integer(id));
        if(null != g){
            session.delete(g);
        }
        logger.info("Gps deleted successfully, Gps details="+g);
    }
}
