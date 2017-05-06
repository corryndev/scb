/**
 * This file is part of the SCB project
 */
package com.corryn.scb.common.event;

import javax.enterprise.event.Observes;

/**
 * @author Romana Schubert
 *
 */
public interface EventListener<T>
{
    /**
     * @param event the event
     */
    public void onEvent(@Observes T event);
}
