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
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

@Api(name = "materiaendpoint", namespace = @ApiNamespace(ownerDomain = "ipn.com", ownerName = "ipn.com", packagePath = "edudown.johnlandongdown.entidades"))
public class MateriaEndpoint {

	/**
	 * This method lists all the entities inserted in datastore.
	 * It uses HTTP GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 * persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listMateria")
	public List<Materia> listMateria(
			@Nullable @Named("limit") Integer limit) {

		PersistenceManager mgr = null;
		List<Materia> execute = null;


			mgr = getPersistenceManager();
			Query query = mgr.newQuery(Materia.class);


			if (limit != null) {
				query.setRange(0, limit);
			}

			execute = (List<Materia>) query.execute();

			mgr.close();


		return execute;
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET method.
	 *
	 * @param id the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getMateria")
	public Materia getMateria(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		Materia materia = null;
		try {
			materia = mgr.getObjectById(Materia.class, id);
		} finally {
			mgr.close();
		}
		return materia;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity already
	 * exists in the datastore, an exception is thrown.
	 * It uses HTTP POST method.
	 *
	 * @param materia the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertMateria")
	public Materia insertMateria(Materia materia) {
		
		Key k = KeyFactory.createKey(Materia.class.getSimpleName(),
				materia.hashCode());
		materia.setIdMateria(k);
		
		PersistenceManager mgr = getPersistenceManager();
		
		try {
			if (containsMateria(materia)) {
				throw new EntityExistsException("La materia ya existe.");
			}
			mgr.makePersistent(materia);
		} finally {
			mgr.close();
		}
		return materia;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown.
	 * It uses HTTP PUT method.
	 *
	 * @param materia the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updateMateria")
	public Materia updateMateria(Materia materia) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			if (!containsMateria(materia)) {
				throw new EntityNotFoundException("La materia no existe.");
			}
			mgr.makePersistent(materia);
		} finally {
			mgr.close();
		}
		return materia;
	}

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeMateria")
	public void removeMateria(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			Materia materia = mgr.getObjectById(Materia.class, id);
			mgr.deletePersistent(materia);
		} finally {
			mgr.close();
		}
	}

	private boolean containsMateria(Materia materia) {
		PersistenceManager mgr = getPersistenceManager();
		boolean contains = true;
		try {
			mgr.getObjectById(Materia.class, materia.getIdMateria());
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
