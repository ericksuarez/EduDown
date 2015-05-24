package com.ipn.edudown.johnlandongdown.entidades;

import com.ipn.edudown.johnlandongdown.entidades.PMF;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.datanucleus.query.JDOCursorHelper;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Named;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

@Api(name = "juegosendpoint", namespace = @ApiNamespace(ownerDomain = "ipn.com", ownerName = "ipn.com", packagePath = "edudown.johnlandongdown.entidades"))
public class JuegosEndpoint {

	/**
	 * This method lists all the entities inserted in datastore.
	 * It uses HTTP GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 * persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listJuegos")
	public List<Juegos> listJuegos(
			@Nullable @Named("limit") Integer limit) {

		PersistenceManager mgr = null;
		List<Juegos> execute = null;

			mgr = getPersistenceManager();
			Query query = mgr.newQuery(Juegos.class);
			if (limit != null) {
				query.setRange(0, limit);
			}
			execute = (List<Juegos>) query.execute();

		return execute;
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET method.
	 *
	 * @param id the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getJuegos")
	public Juegos getJuegos(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		Juegos juegos = null;
		try {
			juegos = mgr.getObjectById(Juegos.class, id);
		} finally {
			mgr.close();
		}
		return juegos;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity already
	 * exists in the datastore, an exception is thrown.
	 * It uses HTTP POST method.
	 *
	 * @param juegos the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertJuegos")
	public Juegos insertJuegos(Juegos juegos) {
		
		Key k = KeyFactory.createKey(Juegos.class.getSimpleName(),
				juegos.hashCode());
		juegos.setIdJuegos(k);
		
		PersistenceManager mgr = getPersistenceManager();
		try {
			if (containsJuegos(juegos)) {
				throw new EntityExistsException("El juego ya existe.");
			}
			mgr.makePersistent(juegos);
		} finally {
			mgr.close();
		}
		return juegos;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown.
	 * It uses HTTP PUT method.
	 *
	 * @param juegos the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updateJuegos")
	public Juegos updateJuegos(Juegos juegos) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			if (!containsJuegos(juegos)) {
				throw new EntityNotFoundException("El juego no existe.");
			}
			mgr.makePersistent(juegos);
		} finally {
			mgr.close();
		}
		return juegos;
	}

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeJuegos")
	public void removeJuegos(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			Juegos juegos = mgr.getObjectById(Juegos.class, id);
			mgr.deletePersistent(juegos);
		} finally {
			mgr.close();
		}
	}

	private boolean containsJuegos(Juegos juegos) {
		PersistenceManager mgr = getPersistenceManager();
		boolean contains = true;
		try {
			mgr.getObjectById(Juegos.class, juegos.getIdJuegos());
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
