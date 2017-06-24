/**
 * This file is part of the SCB project
 */
package com.corryn.scb.calendar;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;

import com.corryn.scb.calendar.repository.AppointmentRepository;
import com.corryn.scb.calendar.repository.RemoveLegacyAppointmentsCriteria;

/**
 * CleanupAppointmentJob
 * 
 * @author Romana Schubert
 *
 */
@Singleton
public class CleanupAppointmentJob
{
    @Inject
    private AppointmentRepository repository;
    
    /**
     * cleanup legacy appointments
     */
    @Schedule(dayOfWeek="Sun", hour="0")
    public void cleanup()
    {
	this.repository.remove(new RemoveLegacyAppointmentsCriteria());
    }
}
