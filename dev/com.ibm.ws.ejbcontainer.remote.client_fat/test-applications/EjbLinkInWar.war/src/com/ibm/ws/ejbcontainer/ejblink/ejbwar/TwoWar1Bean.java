/*******************************************************************************
 * Copyright (c) 2006, 2020 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ws.ejbcontainer.ejblink.ejbwar;

import javax.ejb.Stateless;

import com.ibm.ws.ejbcontainer.ejblink.ejb.AutoLinkLocal2SameWar;

/**
 * Basic Stateless Bean implementation for testing AutoLink to a bean interface
 * that was implemented in an alternate war twice.
 **/
@Stateless
public class TwoWar1Bean implements AutoLinkLocal2SameWar {
    private static final String CLASS_NAME = TwoWar1Bean.class.getName();

    @Override
    public String getBeanName() {
        return CLASS_NAME;
    }

    public TwoWar1Bean() {
        // intentionally blank
    }
}
