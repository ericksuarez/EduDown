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

@Api(name = "palabrasendpoint", namespace = @ApiNamespace(ownerDomain = "ipn.com", ownerName = "ipn.com", packagePath = "edudown.johnlandongdown.entidades"))
public class PalabrasEndpoint {

	/**
	 * This method lists all the entities inserted in datastore. It uses HTTP
	 * GET method and paging support.
	 * 
	 * @return A CollectionResponse class containing the list of all entities
	 *         persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked" })
	@ApiMethod(name = "listPalabras")
	public List<Palabras> listPalabras(@Nullable @Named("limit") Integer limit) {

		PersistenceManager mgr = null;
		List<Palabras> execute = null;

		mgr = getPersistenceManager();
		Query query = mgr.newQuery(Palabras.class);

		if (limit != null) {
			query.setRange(0, limit);
		}

		execute = (List<Palabras>) query.execute();

		mgr.close();

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
	@ApiMethod(name = "getPalabras")
	public Palabras getPalabras(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		Palabras palabras = null;
		try {
			palabras = mgr.getObjectById(Palabras.class, id);
		} finally {
			mgr.close();
		}
		return palabras;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity
	 * already exists in the datastore, an exception is thrown. It uses HTTP
	 * POST method.
	 * 
	 * @param palabras
	 *            the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertPalabras")
	public Palabras insertPalabras(Palabras palabras) {

		Key k = KeyFactory.createKey(Palabras.class.getSimpleName(),
				palabras.hashCode());
		palabras.setIdPalabras(k);

		PersistenceManager mgr = getPersistenceManager();
		try {
			if (containsPalabras(palabras)) {
				throw new EntityExistsException("La palabra ya existe.");
			}
			mgr.makePersistent(palabras);
		} finally {
			mgr.close();
		}
		return palabras;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does
	 * not exist in the datastore, an exception is thrown. It uses HTTP PUT
	 * method.
	 * 
	 * @param palabras
	 *            the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updatePalabras")
	public Palabras updatePalabras(Palabras palabras) {
		PersistenceManager mgr = getPersistenceManager();

		mgr.makePersistent(palabras);

		mgr.close();

		return palabras;
	}

	/**
	 * This method removes the entity with primary key id. It uses HTTP DELETE
	 * method.
	 * 
	 * @param id
	 *            the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removePalabras")
	public void removePalabras(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			Palabras palabras = mgr.getObjectById(Palabras.class, id);
			mgr.deletePersistent(palabras);
		} finally {
			mgr.close();
		}
	}

	private boolean containsPalabras(Palabras palabras) {
		PersistenceManager mgr = getPersistenceManager();
		boolean contains = true;
		try {
			mgr.getObjectById(Palabras.class, palabras.getIdPalabras());
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
