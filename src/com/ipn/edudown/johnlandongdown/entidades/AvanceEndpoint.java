package com.ipn.edudown.johnlandongdown.entidades;

import com.ipn.edudown.johnlandongdown.entidades.PMF;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Named;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

@Api(name = "avanceendpoint", namespace = @ApiNamespace(ownerDomain = "ipn.com", ownerName = "ipn.com", packagePath = "edudown.johnlandongdown.entidades"))
public class AvanceEndpoint {

	/**
	 * This method lists all the entities inserted in datastore. It uses HTTP
	 * GET method and paging support.
	 * 
	 * @return A CollectionResponse class containing the list of all entities
	 *         persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked" })
	@ApiMethod(name = "listAvance")
	public List<Avance> listAvance(@Nullable @Named("limit") Integer limit) {

		PersistenceManager mgr = null;
		List<Avance> execute = null;

		mgr = getPersistenceManager();
		Query query = mgr.newQuery(Avance.class);

		if (limit != null) {
			query.setRange(0, limit);
		}

		execute = (List<Avance>) query.execute();

		return execute;
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET
	 * method.
	 * 
	 * @param id
	 *            the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getAvance")
	public Avance getAvance(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		Avance avance = null;

		avance = mgr.getObjectById(Avance.class, id);

		mgr.close();

		return avance;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity
	 * already exists in the datastore, an exception is thrown. It uses HTTP
	 * POST method.
	 * 
	 * @param avance
	 *            the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertAvance")
	public Avance insertAvance(Avance avance) {

		Key k = KeyFactory.createKey(Avance.class.getSimpleName(),
				avance.hashCode());
		avance.setIdAvance(k);

		PersistenceManager mgr = getPersistenceManager();

		mgr.makePersistent(avance);
		//mgr.makePersistentAll(avance);

		return avance;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does
	 * not exist in the datastore, an exception is thrown. It uses HTTP PUT
	 * method.
	 * 
	 * @param avance
	 *            the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updateAvance")
	public Avance updateAvance(Avance avance) {
		PersistenceManager mgr = getPersistenceManager();

		mgr.makePersistent(avance);
		//mgr.makePersistentAll(avance);

		return avance;
	}

	/**
	 * This method removes the entity with primary key id. It uses HTTP DELETE
	 * method.
	 * 
	 * @param id
	 *            the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeAvance")
	public void removeAvance(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();

		Avance avance = mgr.getObjectById(Avance.class, id);
		mgr.deletePersistent(avance);

	}

	private boolean containsAvance(Avance avance) {
		PersistenceManager mgr = getPersistenceManager();
		boolean contains = true;
		try {
			mgr.getObjectById(Avance.class, avance.getIdAvance());
		} catch (javax.jdo.JDOObjectNotFoundException ex) {
			contains = false;
		} finally {
			mgr.close();
		}
		return contains;
	}

	private static PersistenceManager getPersistenceManager() {
		return PMF.get().getPersistenceManager();
	}

}
