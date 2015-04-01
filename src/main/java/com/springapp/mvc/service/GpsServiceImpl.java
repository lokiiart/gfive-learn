package com.springapp.mvc.service;

import com.springapp.mvc.dao.GpsDAO;
import com.springapp.mvc.model.Gps;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by loki on 3/31/15.
 */
public class GpsServiceImpl implements GpsService{
    private GpsDAO gpsDAO;

    public void setGpsDAO(GpsDAO gpsDAO) {
        this.gpsDAO = gpsDAO;
    }

    @Override
    @Transactional
    public void addGps(Gps g) {
        this.gpsDAO.addGps(g);
    }

    @Override
    @Transactional
    public void updateGps(Gps g) {
        this.gpsDAO.updateGps(g);
    }

    @Override
    @Transactional
    public List<Gps> listGpss() {
        return this.gpsDAO.listGpss();
    }

    @Override
    @Transactional
    public Gps getGpsById(int id) {
        return this.gpsDAO.getGpsById(id);
    }

    @Override
    @Transactional
    public void removeGps(int id) {

    }
}
