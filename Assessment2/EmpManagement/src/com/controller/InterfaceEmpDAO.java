package com.controller;

import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;


public interface InterfaceEmpDAO {
	public Beans getUser(int id);
public boolean insert(Beans b);
public ArrayList<Beans> display();
public boolean update(Beans b);
public boolean delete(Beans b);
}
