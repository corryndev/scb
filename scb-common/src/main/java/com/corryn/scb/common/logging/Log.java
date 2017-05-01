/**
 * This file is part of the SCB project
 */
package com.corryn.scb.common.logging;

import org.jboss.logging.Logger;

/**
 * @author Romana Schubert
 *
 */
public class Log
{
    private static Logger LOG = Logger.getLogger("com.corryn.scb");

    /**
     * @return the logger
     */
    public static final Logger getLog()
    {
	return Log.LOG;
    }
}
