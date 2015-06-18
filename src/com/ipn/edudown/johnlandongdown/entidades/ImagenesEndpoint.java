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

@Api(name = "imagenesendpoint", namespace = @ApiNamespace(ownerDomain = "ipn.com", ownerName = "ipn.com", packagePath = "edudown.johnlandongdown.entidades"))
public class ImagenesEndpoint {

	/**
	 * This method lists all the entities inserted in datastore.
	 * It uses HTTP GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 * persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked"})
	@ApiMethod(name = "listImagenes")
	public List<Imagenes> listImagenes(
			@Nullable @Named("limit") Integer limit) {

		PersistenceManager mgr = null;
		List<Imagenes> execute = null;

			mgr = getPersistenceManager();
			Query query = mgr.newQuery(Imagenes.class);

			if (limit != null) {
				query.setRange(0, limit);
			}

			mgr.close();

		return execute;
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET method.
	 *
	 * @param id the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getImagenes")
	public Imagenes getImagenes(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		Imagenes imagenes = null;

			imagenes = mgr.getObjectById(Imagenes.class, id);

			mgr.close();

		return imagenes;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity already
	 * exists in the datastore, an exception is thrown.
	 * It uses HTTP POST method.
	 *
	 * @param imagenes the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertImagenes")
	public Imagenes insertImagenes(Imagenes imagenes) {
		
		Key k = KeyFactory.createKey(Imagenes.class.getSimpleName(),
				imagenes.hashCode());
		imagenes.setIdImagenes(k);
		
		PersistenceManager mgr = getPersistenceManager();
		try {
			if (containsImagenes(imagenes)) {
				throw new EntityExistsException("La imagen ya existe.");
			}
			mgr.makePersistent(imagenes);
		} finally {
			mgr.close();
		}
		return imagenes;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown.
	 * It uses HTTP PUT method.
	 *
	 * @param imagenes the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updateImagenes")
	public Imagenes updateImagenes(Imagenes imagenes) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			if (!containsImagenes(imagenes)) {
				throw new EntityNotFoundException("La imagen no existe.");
			}
			mgr.makePersistent(imagenes);
		} finally {
			mgr.close();
		}
		return imagenes;
	}

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeImagenes")
	public void removeImagenes(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			Imagenes imagenes = mgr.getObjectById(Imagenes.class, id);
			mgr.deletePersistent(imagenes);
		} finally {
			mgr.close();
		}
	}

	private boolean containsImagenes(Imagenes imagenes) {
		PersistenceManager mgr = getPersistenceManager();
		boolean contains = true;
		try {
			mgr.getObjectById(Imagenes.class, imagenes.getIdImagenes());
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
