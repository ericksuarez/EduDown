package com.ipn.edudown.johnlandongdown.entidades;

import com.ipn.edudown.johnlandongdown.entidades.PMF;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.datanucleus.query.JDOCursorHelper;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Named;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

@Api(name = "profesorendpoint", namespace = @ApiNamespace(ownerDomain = "ipn.com", ownerName = "ipn.com", packagePath="edudown.johnlandongdown.entidades"))
public class ProfesorEndpoint {

  /**
   * This method lists all the entities inserted in datastore.
   * It uses HTTP GET method and paging support.
   *
   * @return A CollectionResponse class containing the list of all entities
   * persisted and a cursor to the next page.
   */
  @SuppressWarnings({"unchecked", "unused"})
  @ApiMethod(name = "listProfesor")
  public CollectionResponse<Profesor> listProfesor(
    @Nullable @Named("cursor") String cursorString,
    @Nullable @Named("limit") Integer limit) {

    PersistenceManager mgr = null;
    Cursor cursor = null;
    List<Profesor> execute = null;

    try{
      mgr = getPersistenceManager();
      Query query = mgr.newQuery(Profesor.class);
      if (cursorString != null && cursorString != "") {
        cursor = Cursor.fromWebSafeString(cursorString);
        HashMap<String, Object> extensionMap = new HashMap<String, Object>();
        extensionMap.put(JDOCursorHelper.CURSOR_EXTENSION, cursor);
        query.setExtensions(extensionMap);
      }

      if (limit != null) {
        query.setRange(0, limit);
      }

      execute = (List<Profesor>) query.execute();
      cursor = JDOCursorHelper.getCursor(execute);
      if (cursor != null) cursorString = cursor.toWebSafeString();

      // Tight loop for fetching all entities from datastore and accomodate
      // for lazy fetch.
      for (Profesor obj : execute);
    } finally {
      mgr.close();
    }

    return CollectionResponse.<Profesor>builder()
      .setItems(execute)
      .setNextPageToken(cursorString)
      .build();
  }

  /**
   * This method gets the entity having primary key id. It uses HTTP GET method.
   *
   * @param id the primary key of the java bean.
   * @return The entity with primary key id.
   */
  @ApiMethod(name = "getProfesor")
  public Profesor getProfesor(@Named("id") Long id) {
    PersistenceManager mgr = getPersistenceManager();
    Profesor profesor  = null;
    try {
      profesor = mgr.getObjectById(Profesor.class, id);
    } finally {
      mgr.close();
    }
    return profesor;
  }

  /**
   * This inserts a new entity into App Engine datastore. If the entity already
   * exists in the datastore, an exception is thrown.
   * It uses HTTP POST method.
   *
   * @param profesor the entity to be inserted.
   * @return The inserted entity.
   */
  @ApiMethod(name = "insertProfesor")
  public Profesor insertProfesor(Profesor profesor) {
    PersistenceManager mgr = getPersistenceManager();
    try {
      //if(containsProfesor(profesor)) {
    	if (profesor.getIdProfesor() != null) {
        throw new EntityExistsException("Object already exists");
      }
      mgr.makePersistent(profesor);
    } finally {
      mgr.close();
    }
    return profesor;
  }

  /**
   * This method is used for updating an existing entity. If the entity does not
   * exist in the datastore, an exception is thrown.
   * It uses HTTP PUT method.
   *
   * @param profesor the entity to be updated.
   * @return The updated entity.
   */
  @ApiMethod(name = "updateProfesor")
  public Profesor updateProfesor(Profesor profesor) {
    PersistenceManager mgr = getPersistenceManager();
    try {
      if(!containsProfesor(profesor)) {
        throw new EntityNotFoundException("Object does not exist");
      }
      mgr.makePersistent(profesor);
    } finally {
      mgr.close();
    }
    return profesor;
  }

  /**
   * This method removes the entity with primary key id.
   * It uses HTTP DELETE method.
   *
   * @param id the primary key of the entity to be deleted.
   */
  @ApiMethod(name = "removeProfesor")
  public void removeProfesor(@Named("id") Long id) {
    PersistenceManager mgr = getPersistenceManager();
    try {
      Profesor profesor = mgr.getObjectById(Profesor.class, id);
      mgr.deletePersistent(profesor);
    } finally {
      mgr.close();
    }
  }

  private boolean containsProfesor(Profesor profesor) {
    PersistenceManager mgr = getPersistenceManager();
    boolean contains = true;
    try {
      mgr.getObjectById(Profesor.class, profesor.getIdProfesor());
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
