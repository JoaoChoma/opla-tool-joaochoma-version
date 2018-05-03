//  Operator.java
//
//  Authors:
//       Antonio J. Nebro <antonio@lcc.uma.es>
//       Juan J. Durillo <durillo@lcc.uma.es>
// 
//  Copyright (c) 2011 Antonio J. Nebro, Juan J. Durillo
//
//  This program is free software: you can redistribute it and/or modify
//  it under the terms of the GNU Lesser General Public License as published by
//  the Free Software Foundation, either version 3 of the License, or
//  (at your option) any later version.
//
//  This program is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//  GNU Lesser General Public License for more details.
// 
//  You should have received a copy of the GNU Lesser General Public License
//  along with this program.  If not, see <http://www.gnu.org/licenses/>.

package jmetal.core;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import arquitetura.exceptions.ClassNotFound;
import arquitetura.exceptions.ConcernNotFoundException;
import arquitetura.exceptions.NotFoundException;
import arquitetura.exceptions.PackageNotFound;

/**
 * Class representing an operator
 */
public abstract class Operator implements Serializable {

	private static final long serialVersionUID = -1888856778904485625L;
	/**
	 * Stores the current operator parameters. It is defined as a Map of pairs <
	 * <code>String</code>, <code>Object</code>>, and it allow objects to be
	 * accessed by their names, which are specified by the string.
	 */
	protected Map<String, Object> parameters_;

	/**
	 * Constructor.
	 */
	public Operator(HashMap<String, Object> parameters) {
		parameters_ = parameters;
	} // Operator

	/**
	 * Abstract method that must be defined by all the operators. When invoked,
	 * this method executes the operator represented by the current object.
	 * 
	 * @param object
	 *            This param inherits from Object to allow different kinds of
	 *            parameters for each operator. For example, a selection
	 *            operator typically receives a <code>SolutionSet</code> as a
	 *            parameter, while a mutation operator receives a
	 *            <code>Solution</code>.
	 * @return An object reference. The returned value depends on the operator.
	 * @throws NotFoundException 
	 * @throws PackageNotFound 
	 * @throws ClassNotFound 
	 * @throws CloneNotSupportedException 
	 * @throws ConcernNotFoundException 
	 * @throws Exception 
	 */

	abstract public Object execute(Object object) throws  Exception;

	// abstract public Object execute(Object object, OPLA_agregacao_MAC_MSI
	// problem) throws JMException;

	/**
	 * Sets a new <code>Object</code> parameter to the operator.
	 * 
	 * @param name
	 *            The parameter name.
	 * @param value
	 *            Object representing the parameter.
	 */
	public void setParameter(String name, Double value) {
		parameters_.put(name, value);
	} // setParameter

	/**
	 * Returns an object representing a parameter of the <code>Operator</code>
	 * 
	 * @param name
	 *            The parameter name.
	 * @return the parameter.
	 */
	public Object getParameter(String name) {
		return parameters_.get(name);
	} // getParameter

} // Operator
