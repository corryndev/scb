/**
 * This file is part of the SCB project
 */
package com.corryn.scb.calendar.repository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.corryn.scb.calendar.entity.Appointment;
import com.corryn.scb.calendar.entity.Appointment_;
import com.corryn.scb.common.repository.RemoveSpecification;

/**
 * @author Romana Schubert
 *
 */
public class RemoveLegacyAppointmentsCriteria implements RemoveSpecification<Appointment>
{
    /* (non-Javadoc)
     * @see com.corryn.scb.common.repository.RemoveSpecification#toDelete(javax.persistence.criteria.CriteriaBuilder, javax.persistence.criteria.CriteriaDelete)
     */
    @Override
    public CriteriaDelete<Appointment> toDelete(final CriteriaBuilder builder, final CriteriaDelete<Appointment> delete)
    {
	final Root<Appointment> appointment = delete.from(Appointment.class);
	final Date today = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());	
	final Predicate legacyPredicate = builder.lessThan(appointment.get(Appointment_.date), today);
	delete.where(legacyPredicate);
	return delete;
    }
}
