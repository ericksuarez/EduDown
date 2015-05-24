package com.ipn.edudown.johnlandongdown.entidades;

import com.ipn.edudown.johnlandongdown.entidades.PMF;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Named;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

@Api(name = "gradoendpoint", namespace = @ApiNamespace(ownerDomain = "ipn.com", ownerName = "ipn.com", packagePath = "edudown.johnlandongdown.entidades"))
public class GradoEndpoint {

	/**
	 * This method lists all the entities inserted in datastore. It uses HTTP
	 * GET method and paging support.
	 * 
	 * @return A CollectionResponse class containing the list of all entities
	 *         persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listGrado")
	public List<Grado> listGrado(@Nullable @Named("limit") Integer limit) {

		PersistenceManager mgr = null;
		List<Grado> execute = null;

		mgr = getPersistenceManager();
		Query query = mgr.newQuery(Grado.class);
		query.setOrdering("grupo asc");
		
		if (limit != null)
			query.setRange(0, limit);

		execute = (List<Grado>) query.execute();

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
	@ApiMethod(name = "getGrado")
	public Grado getGrado(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		Grado grado = null;
		grado = mgr.getObjectById(Grado.class, id);
		mgr.close();
		return grado;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity
	 * already exists in the datastore, an exception is thrown. It uses HTTP
	 * POST method.
	 * 
	 * @param grado
	 *            the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertGrado")
	public Grado insertGrado(Grado grado) {
		
		Key k = KeyFactory.createKey(Grado.class.getSimpleName(),
				grado.hashCode());
		grado.setIdGrado(k);
		
		PersistenceManager mgr = getPersistenceManager();
		
		try {
			if (containsGrado(grado)) {
				throw new EntityExistsException("La materia ya existe.");
			}
			mgr.makePersistent(grado);
		} finally {
			mgr.close();
		}
		return grado;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does
	 * not exist in the datastore, an exception is thrown. It uses HTTP PUT
	 * method.
	 * 
	 * @param grado
	 *            the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updateGrado")
	public Grado updateGrado(Grado grado) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			if (!containsGrado(grado)) {
				throw new EntityNotFoundException("El Grado no existe.");
			}
			mgr.makePersistent(grado);
		} finally {
			mgr.close();
		}
		return grado;
	}

	/**
	 * This method removes the entity with primary key id. It uses HTTP DELETE
	 * method.
	 * 
	 * @param id
	 *            the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeGrado")
	public void removeGrado(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		Grado grado = mgr.getObjectById(Grado.class, id);
		mgr.deletePersistent(grado);
		mgr.close();
	}

	private boolean containsGrado(Grado grado) {
		PersistenceManager mgr = getPersistenceManager();
		boolean contains = true;
		try {
			mgr.getObjectById(Grado.class, grado.getIdGrado());
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
