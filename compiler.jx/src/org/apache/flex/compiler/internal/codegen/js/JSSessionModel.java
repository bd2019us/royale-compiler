/*
 *
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package org.apache.flex.compiler.internal.codegen.js;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.flex.compiler.definitions.IClassDefinition;
import org.apache.flex.compiler.tree.as.IGetterNode;
import org.apache.flex.compiler.tree.as.ISetterNode;

/**
 * @author Michael Schmalle
 */
public class JSSessionModel
{
    public static final String CONSTRUCTOR_EMPTY = "emptyConstructor";
    public static final String CONSTRUCTOR_FULL = "fullConstructor";
    public static final String SUPER_FUNCTION_CALL = "replaceSuperFunction";

    private IClassDefinition currentClass;

    public static class PropertyNodes
    {
        public IGetterNode getter;
        public ISetterNode setter;
    }

    private HashMap<String, PropertyNodes> propertyMap = new HashMap<String, PropertyNodes>();

    private HashMap<String, PropertyNodes> staticPropertyMap = new HashMap<String, PropertyNodes>();

    private ArrayList<String> bindableVars = new ArrayList<String>();

    private int foreachLoopCount = 0;

    public IClassDefinition getCurrentClass()
    {
        return currentClass;
    }

    public void setCurrentClass(IClassDefinition currentClass)
    {
        this.currentClass = currentClass;
    }

    public HashMap<String, PropertyNodes> getPropertyMap()
    {
        return propertyMap;
    }

    public HashMap<String, PropertyNodes> getStaticPropertyMap()
    {
        return staticPropertyMap;
    }

    public boolean hasBindableVars()
    {
        return bindableVars.size() > 0;
    }

    public List<String> getBindableVars()
    {
        return bindableVars;
    }

    public final void incForeachLoopCount()
    {
        foreachLoopCount++;
    }

    public String getCurrentForeachName()
    {
        return "foreachiter" + Integer.toString(foreachLoopCount);
    }

}