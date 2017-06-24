/**
 * This file is part of the SCB project
 */
package com.corryn.scb.calendar;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.corryn.scb.calendar.entity.Appointment;
import com.corryn.scb.calendar.repository.AppointmentRepository;
import com.corryn.scb.calendar.repository.FindOpenAppointmentsCriteria;

/**
 * AppointmentResource
 * 
 * @author Romana Schubert
 *
 */
@Path("appointments")
public class AppointmentResource
{
    @Inject
    private AppointmentRepository appointmentRepository;
    
    /**
     * @return all appointments
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Appointment> getAppointments()
    {
	return this.appointmentRepository.list();
    }
    
    @GET
    @Path("/open")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Appointment> getOpenAppointments()
    {
	return this.appointmentRepository.list(new FindOpenAppointmentsCriteria());
    }

    /**
     * @return appointment for the given id
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Appointment getAppointment(@PathParam(value = "id") final Long id)
    {
	return this.appointmentRepository.get(id);
    }
}
