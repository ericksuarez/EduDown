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

@Api(name = "alumnoendpoint", namespace = @ApiNamespace(ownerDomain = "ipn.com", ownerName = "ipn.com", packagePath = "edudown.johnlandongdown.entidades"))
public class AlumnoEndpoint {

	/**
	 * This method lists all the entities inserted in datastore. It uses HTTP
	 * GET method and paging support.
	 * 
	 * @return A CollectionResponse class containing the list of all entities
	 *         persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listAlumno")
	public List<Alumno> listAlumno(@Nullable @Named("limit") Integer limit) {

		PersistenceManager mgr = null;
		List<Alumno> execute = null;

		try {
			mgr = getPersistenceManager();
			Query query = mgr.newQuery(Alumno.class);

			if (limit != null) {
				query.setRange(0, limit);
			}

			execute = (List<Alumno>) query.execute();

		} finally {
			mgr.close();
		}

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
	@ApiMethod(name = "getAlumno")
	public Alumno getAlumno(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		Alumno alumno = null;

		alumno = mgr.getObjectById(Alumno.class, id);

		return alumno;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity
	 * already exists in the datastore, an exception is thrown. It uses HTTP
	 * POST method.
	 * 
	 * @param alumno
	 *            the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertAlumno")
	public Alumno insertAlumno(Alumno alumno) {

		Key k = KeyFactory.createKey(Alumno.class.getSimpleName(),
				alumno.hashCode());
		alumno.setIdAlumno(k);

		PersistenceManager mgr = getPersistenceManager();
		try {
			if (containsAlumno(alumno)) {
				throw new EntityExistsException("EL alumno ya existe.");
			}
			mgr.makePersistent(alumno);
		} finally {
			mgr.close();
		}
		return alumno;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does
	 * not exist in the datastore, an exception is thrown. It uses HTTP PUT
	 * method.
	 * 
	 * @param alumno
	 *            the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updateAlumno")
	public Alumno updateAlumno(Alumno alumno) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			if (!containsAlumno(alumno)) {
				throw new EntityNotFoundException("El alumno no existe.");
			}
			mgr.makePersistent(alumno);
		} finally {
			mgr.close();
		}
		return alumno;
	}

	/**
	 * This method removes the entity with primary key id. It uses HTTP DELETE
	 * method.
	 * 
	 * @param id
	 *            the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeAlumno")
	public void removeAlumno(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			Alumno alumno = mgr.getObjectById(Alumno.class, id);
			mgr.deletePersistent(alumno);
		} finally {
			mgr.close();
		}
	}

	private boolean containsAlumno(Alumno alumno) {
		PersistenceManager mgr = getPersistenceManager();
		boolean contains = true;
		try {
			mgr.getObjectById(Alumno.class, alumno.getIdAlumno());
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
