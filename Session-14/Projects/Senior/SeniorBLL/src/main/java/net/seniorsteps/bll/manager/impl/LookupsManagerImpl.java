/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.seniorsteps.bll.manager.impl;

import net.seniorsteps.bll.manager.LookupsManager;
import net.seniorsteps.bll.transformer.CityTransformer;
import net.seniorsteps.senior.common.bean.CityBean;
import net.seniorsteps.senior.common.constant.SeniorConstant;
import static net.seniorsteps.senior.dal.DBConnectionManager.*;
import net.seniorsteps.senior.dal.entity.City;
import net.seniorsteps.senior.dal.repo.CityRepo;

/**
 *
 * @author Senior Steps
 */
public class LookupsManagerImpl implements LookupsManager, SeniorConstant {

	private CityTransformer cityTransformer = new CityTransformer();
	private CityRepo cityRepo = new CityRepo();

	@Override
	public CityBean addCity(CityBean cityBean) {
		openSession();
		City cityEntity = cityTransformer.fromBeanToEntity(cityBean);
		beginTransaction();
		cityEntity = cityRepo.add(cityEntity);
		CityBean resultCityBean = cityTransformer.fromEntityToBean(cityEntity, LANG_AR);
		commitTransaction();
		return resultCityBean;
	}

}
