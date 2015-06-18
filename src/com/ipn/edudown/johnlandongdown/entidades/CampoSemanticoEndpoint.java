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

@Api(name = "camposemanticoendpoint", namespace = @ApiNamespace(ownerDomain = "ipn.com", ownerName = "ipn.com", packagePath = "edudown.johnlandongdown.entidades"))
public class CampoSemanticoEndpoint {

	/**
	 * This method lists all the entities inserted in datastore. It uses HTTP
	 * GET method and paging support.
	 * 
	 * @return A CollectionResponse class containing the list of all entities
	 *         persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listCampoSemantico")
	public List<CampoSemantico> listCampoSemantico(
			@Nullable @Named("limit") Integer limit) {

		PersistenceManager mgr = null;
		List<CampoSemantico> execute = null;

		try {
			mgr = getPersistenceManager();
			Query query = mgr.newQuery(CampoSemantico.class);

			if (limit != null) {
				query.setRange(0, limit);
			}

			execute = (List<CampoSemantico>) query.execute();
			;
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
	@ApiMethod(name = "getCampoSemantico")
	public CampoSemantico getCampoSemantico(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		CampoSemantico camposemantico = null;
		try {
			camposemantico = mgr.getObjectById(CampoSemantico.class, id);
		} finally {
			mgr.close();
		}
		return camposemantico;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity
	 * already exists in the datastore, an exception is thrown. It uses HTTP
	 * POST method.
	 * 
	 * @param camposemantico
	 *            the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertCampoSemantico")
	public CampoSemantico insertCampoSemantico(CampoSemantico camposemantico) {

		Key k = KeyFactory.createKey(CampoSemantico.class.getSimpleName(),
				camposemantico.hashCode());
		camposemantico.setIdCampo(k);

		PersistenceManager mgr = getPersistenceManager();
		try {
			if (camposemantico.getIdCampo() != null) {
				if (containsCampoSemantico(camposemantico)) {
					throw new EntityExistsException(
							"El campo semantico ya existe");
				}
			}
			mgr.makePersistent(camposemantico);
		} finally {
			mgr.close();
		}
		return camposemantico;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does
	 * not exist in the datastore, an exception is thrown. It uses HTTP PUT
	 * method.
	 * 
	 * @param camposemantico
	 *            the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updateCampoSemantico")
	public CampoSemantico updateCampoSemantico(CampoSemantico camposemantico) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			if (!containsCampoSemantico(camposemantico)) {
				throw new EntityNotFoundException(
						"El campo semantico no existe.");
			}
			mgr.makePersistent(camposemantico);
		} finally {
			mgr.close();
		}
		return camposemantico;
	}

	/**
	 * This method removes the entity with primary key id. It uses HTTP DELETE
	 * method.
	 * 
	 * @param id
	 *            the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeCampoSemantico")
	public void removeCampoSemantico(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			CampoSemantico camposemantico = mgr.getObjectById(
					CampoSemantico.class, id);
			mgr.deletePersistent(camposemantico);
		} finally {
			mgr.close();
		}
	}

	private boolean containsCampoSemantico(CampoSemantico camposemantico) {
		PersistenceManager mgr = getPersistenceManager();
		boolean contains = true;
		try {
			if (camposemantico.getIdCampo() == null) {
				return false;
			}
			mgr.getObjectById(CampoSemantico.class, camposemantico.getIdCampo());
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
