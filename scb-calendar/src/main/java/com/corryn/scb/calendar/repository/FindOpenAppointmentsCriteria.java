/**
 * This file is part of the SCB project
 */
package com.corryn.scb.calendar.repository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.corryn.scb.calendar.entity.Appointment;
import com.corryn.scb.calendar.entity.Appointment_;
import com.corryn.scb.common.repository.QuerySpecification;

/**
 * @author Romana Schubert
 *
 */
public class FindOpenAppointmentsCriteria implements QuerySpecification<Appointment>
{
    /* (non-Javadoc)
     * @see com.corryn.scb.common.repository.CriteriaSpecification#toCriteriaQuery(javax.persistence.criteria.CriteriaBuilder, javax.persistence.criteria.CriteriaQuery)
     */
    @Override
    public CriteriaQuery<Appointment> toQuery(final CriteriaBuilder builder, final CriteriaQuery<Appointment> query)
    {
	final Root<Appointment> appointment = query.from(Appointment.class);
	final Date today = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());	
	final Predicate openPredicate = builder.greaterThanOrEqualTo(appointment.get(Appointment_.date), today);
	return query.select(appointment).where(openPredicate);
    }
}
