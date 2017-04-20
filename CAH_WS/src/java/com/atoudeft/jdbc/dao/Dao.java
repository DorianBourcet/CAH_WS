/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atoudeft.jdbc.dao;

/**
 *
 * @author moumene
 */
//import java.sql.Connection;

import java.sql.Connection;
import java.util.List;

public abstract class Dao<T> {
	protected Connection cnx;

	public Dao(Connection cnx) {
		super();
		this.cnx = cnx;
	}
	
	public Connection getCnx() {
		return cnx;
	}

	public void setCnx(Connection cnx) {
		this.cnx = cnx;
	}

	public abstract boolean create(T x);
	public abstract T read(String id);
	public abstract boolean update(T x);
	public abstract boolean delete(T x);
	public abstract List<T> findAll();
}