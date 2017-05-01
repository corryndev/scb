/**
 * This file is part of the SCB project
 */
package com.corryn.scb.common.logging;

import org.jboss.logging.Logger;

/**
 * @author Romana Schubert
 *
 */
public final class Log
{
    private static final Logger LOG = Logger.getLogger("com.corryn.scb");

    /**
     * @return the logger
     */
    public static final Logger getLog()
    {
	return Log.LOG;
    }
}
