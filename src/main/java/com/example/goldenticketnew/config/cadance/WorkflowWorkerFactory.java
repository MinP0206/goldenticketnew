package com.example.goldenticketnew.config.cadance;

import com.uber.cadence.RegisterDomainRequest;
import com.uber.cadence.serviceclient.IWorkflowService;
import com.uber.cadence.worker.Worker;
import com.uber.cadence.worker.WorkerFactory;
import com.uber.cadence.worker.WorkerOptions;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;


@Component
@Slf4j
@RequiredArgsConstructor
public class WorkflowWorkerFactory implements InitializingBean {
    private final CadenceWorkflowConfig workflowConfig;

    private final WorkerFactory workerFactory;

    private final IWorkflowService workflowService;


    private void registerDomain() {
        RegisterDomainRequest request = new RegisterDomainRequest();
        request.setName(workflowConfig.getDomain());
        request.setWorkflowExecutionRetentionPeriodInDays(1);
        try {
            workflowService.RegisterDomain(request);
            log.info("register domain");
        } catch (TException e) {
//            e.printStackTrace();
        }

    }

    private void runFactory() {
        createUpdateStatusWorker();
        workerFactory.start();
    }

    private void createUpdateStatusWorker() {
        Worker worker = workerFactory.newWorker(CadenceWorkflowConfig.TASK_LIST,
            WorkerOptions.newBuilder()
                .build());
        worker.registerWorkflowImplementationTypes(CadenceWorkflowConfig.BookWorkflowImpl.class);
        worker.registerActivitiesImplementations(new CadenceWorkflowConfig.BookingActivitiesImpl());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        registerDomain();
        runFactory();
    }
}

