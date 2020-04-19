/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.seniorsteps.senior.dal.dao;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import net.seniorsteps.senior.dal.entity.City;
import static net.seniorsteps.senior.dal.DBConnectionManager.getCurrentSession;
import org.hibernate.query.Query;

/**
 *
 * @author Senior Steps
 */
public class CityDAO {

	public City add(City city) {
		getCurrentSession().persist(city);
		return city;
	}

	public City update(City city) {
		getCurrentSession().update(city);
		return city;
	}

	public void remove(Integer id) {
		getCurrentSession().remove(id);
	}

	public City findById(Integer id) {
		return getCurrentSession().get(City.class, id);
	}

	public List<City> findList() {
		CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<City> cityCirteriaQuery = criteriaBuilder.createQuery(City.class);
		Root<City> from = cityCirteriaQuery.from(City.class);
		cityCirteriaQuery.select(from);
		cityCirteriaQuery.orderBy(criteriaBuilder.asc(from.get("nameAr")));
		Query<City> cityQuery = getCurrentSession().createQuery(cityCirteriaQuery);
		List<City> cityResultList = cityQuery.getResultList();
		return cityResultList;
	}

	public List<City> findLike(String keyword) {
		String pattern = "%" + keyword + "%";
		CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<City> cityCirteriaQuery = criteriaBuilder.createQuery(City.class);
		Root<City> root = cityCirteriaQuery.from(City.class);
		cityCirteriaQuery.select(root);
		Predicate[] likeConditions = new Predicate[2];
		likeConditions[0] = criteriaBuilder.like(root.get("nameAr"), pattern);
		likeConditions[1] = criteriaBuilder.like(root.get("nameEn"), pattern);
		cityCirteriaQuery.where(criteriaBuilder.or(likeConditions));
		cityCirteriaQuery.orderBy(criteriaBuilder.asc(root.get("nameAr")));
		Query<City> cityQuery = getCurrentSession().createQuery(cityCirteriaQuery);
		List<City> cityResultList = cityQuery.getResultList();
		return cityResultList;
	}

	public Long countLike(String keyword) {
		String pattern = "%" + keyword + "%";
		CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<Long> cityCirteriaQuery = criteriaBuilder.createQuery(Long.class);
		Root<City> root = cityCirteriaQuery.from(City.class);
		cityCirteriaQuery.select(criteriaBuilder.count(root));
		Predicate[] likeConditions = new Predicate[2];
		likeConditions[0] = criteriaBuilder.like(root.get("nameAr"), pattern);
		likeConditions[1] = criteriaBuilder.like(root.get("nameEn"), pattern);
		cityCirteriaQuery.where(criteriaBuilder.or(likeConditions));
		Query<Long> countQuery = getCurrentSession().createQuery(cityCirteriaQuery);
		List<Long> cityResultList = countQuery.getResultList();

		return cityResultList.get(0);

	}
}
