/**
 * This file is part of the SCB project
 */
package com.corryn.scb.calendar.repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.corryn.scb.calendar.entity.Appointment;
import com.corryn.scb.common.repository.Repository;

/**
 * AppointmentRepository
 * 
 * @author Romana Schubert
 *
 */
public class AppointmentRepository extends Repository<Appointment>
{
    /**
     * AppointmentRepository
     * 
     * @param entityManager
     */
    @Inject
    public AppointmentRepository(final EntityManager entityManager)
    {
	super(entityManager, Appointment.class);
    }
}
