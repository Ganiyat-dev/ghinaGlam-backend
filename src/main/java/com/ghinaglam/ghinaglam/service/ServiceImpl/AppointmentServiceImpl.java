package com.ghinaglam.ghinaglam.service.ServiceImpl;

import com.ghinaglam.ghinaglam.dto.AppointmentDto;
import com.ghinaglam.ghinaglam.model.Appointment;
import com.ghinaglam.ghinaglam.model.Client;
import com.ghinaglam.ghinaglam.model.Plan;
import com.ghinaglam.ghinaglam.repository.AppointmentRepository;
import com.ghinaglam.ghinaglam.repository.ClientRepository;
import com.ghinaglam.ghinaglam.repository.PlanRepository;
import com.ghinaglam.ghinaglam.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final ClientRepository clientRepository;
    private final PlanRepository planRepository;

    private final ModelMapper mapper = new ModelMapper();


    @Override
    public AppointmentDto createAppointment(Long clientId, Long planId,
                                            AppointmentDto appointmentDto) {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new IllegalStateException("Client with the id" + clientId + " not found"));
        Plan plan = planRepository.findById(planId).orElseThrow(() -> new IllegalStateException("No Plan found"));
        appointmentDto.setEndDate(calcEndDate(appointmentDto.getStartDate(), plan.getPlanSession()));

        Appointment appointment = mapToEntity(appointmentDto);
        appointment.setClient(client);
        appointment.setPlan(plan);

//        appointment.setStatus(Status.STARTED);

        return mapToDto(appointmentRepository.save(appointment));
    }

//    @Override
//    @Transactional
//    public AppointmentDto updateAppointmentStatus(Long appointmentId, Status status) {
//            Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(() -> new IllegalStateException("Appointment does not exist"));
//            return mapToDto(appointment);
//    }

    @Override
    public List<AppointmentDto> getAllAppointments() { //Only Admin is authorized to perform this action
        return appointmentRepository.findAll().stream().map(this::mapToDto).toList();
    }
    @Override
    public void getAppointmentById(Long appointmentId) {
        appointmentRepository.findById(appointmentId);
    }

    @Override
    public List<Appointment> getAppointmentByStartDate(LocalDate startDate) {
        return appointmentRepository.findAppointmentByStartDate(startDate);
    }


    private AppointmentDto mapToDto(Appointment appointment) {
        return mapper.map(appointment, AppointmentDto.class);
    }
    private Appointment mapToEntity(AppointmentDto appointmentDto) {
        return mapper.map(appointmentDto, Appointment.class);
    }

    private LocalDateTime calcEndDate(LocalDateTime startDate, Long planSession) {
        log.info("the end date is {}", startDate.plusDays(7 * planSession));
        return startDate.plusDays(7 * planSession);
    }

}
