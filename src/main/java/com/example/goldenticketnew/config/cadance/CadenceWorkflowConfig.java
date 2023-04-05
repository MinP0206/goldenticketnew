package com.example.goldenticketnew.config.cadance;



import com.example.goldenticketnew.dtos.BookingRequestDto;
import com.example.goldenticketnew.dtos.DeleteBillTicketRequest;
import com.example.goldenticketnew.service.bill.IBillService;
import com.example.goldenticketnew.utils.BeanUtils;
import com.uber.cadence.activity.ActivityMethod;
import com.uber.cadence.client.WorkflowClient;
import com.uber.cadence.client.WorkflowClientOptions;
import com.uber.cadence.serviceclient.ClientOptions;
import com.uber.cadence.serviceclient.IWorkflowService;
import com.uber.cadence.serviceclient.WorkflowServiceTChannel;
import com.uber.cadence.worker.WorkerFactory;
import com.uber.cadence.workflow.Workflow;
import com.uber.cadence.workflow.WorkflowMethod;
import lombok.Data;
import org.apache.catalina.Host;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

/**
 * Hello World Cadence workflow that executes a single activity. Requires a local instance the
 * Cadence service to be running.
 */
@Configuration
@Data
public class CadenceWorkflowConfig {


    public static final String TASK_LIST = "BookActivity" ;

    @Value("${cadence.domain}")
    private String domain;
    @Value("${cadence.host}")
    private String host;
    @Value("${cadence.port}")
    private int port;

    @Bean
    public IWorkflowService workflowService() {

        IWorkflowService ser = new WorkflowServiceTChannel(ClientOptions.newBuilder()
            .setHost(host)
            .setPort(port)
            .build());
        System.out.println(ser);
        return ser;
    }
    @Bean
    public WorkflowClient workflowClient(IWorkflowService workflowService) {
        return WorkflowClient.newInstance(
            workflowService,
            WorkflowClientOptions.newBuilder()
                .setDomain(domain)
                .build());
    }
    @Bean
    public WorkerFactory workerFactory(WorkflowClient workflowClient) {
        return WorkerFactory.newInstance(
            workflowClient
        );
    }
    /** Workflow interface has to have at least one method annotated with @WorkflowMethod. */
    public interface BookWorkflow {
        /** @return greeting string */
        @WorkflowMethod(executionStartToCloseTimeoutSeconds = 300, taskList = TASK_LIST)
        String getBooking(BookingRequestDto request);
    }

    /** Activity interface is just a POJI. */
    public interface BookingActivities {
        @ActivityMethod(scheduleToCloseTimeoutSeconds = 2)
        String composeBooking(BookingRequestDto request);
    }

    /** GreetingWorkflow implementation that calls GreetingsActivities#composeGreeting. */

    public static class BookWorkflowImpl implements BookWorkflow {

        /**
         * Activity stub implements activity interface and proxies calls to it to Cadence activity
         * invocations. Because activities are reentrant, only a single stub can be used for multiple
         * activity invocations.
         */
        private final BookingActivities activities =
            Workflow.newActivityStub(BookingActivities.class);

        @Override
        public String getBooking(BookingRequestDto request) {
            // This is a blocking call that returns only after the activity has completed.
            System.out.println("cho 120 s");
            Workflow.sleep(Duration.ofSeconds(120));
            return activities.composeBooking(request);
        }
    }

    public static class BookingActivitiesImpl implements BookingActivities {
        @Override
        public String composeBooking(BookingRequestDto request) {
            try {
                IBillService billService = BeanUtils.getBean(IBillService.class);
                DeleteBillTicketRequest request1 = new DeleteBillTicketRequest();
                request1.setBillId(request.getBillId());
                billService.removeBill(request1);
                System.out.println("cho 120 s");
                return "dat ve thanh cong";
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
            return "fail";
        }
    }
//    public static void main(String[] args) throws InterruptedException {
//
//        // Get a new client
//        // NOTE: to set a different options, you can do like this:
//        // ClientOptions.newBuilder().setRpcTimeout(5 * 1000).build();
//        WorkflowClient workflowClient =
//            WorkflowClient.newInstance(
//                new Thrift2ProtoAdapter(IGrpcServiceStubs.newInstance()),
//                WorkflowClientOptions.newBuilder().setDomain("golden-new").build());
//        // Get worker to poll the task list.
//        WorkerFactory factory = WorkerFactory.newInstance(workflowClient);
//        Worker worker = factory.newWorker(TASK_LIST);
//        // Workflows are stateful. So you need a type to create instances.
//        worker.registerWorkflowImplementationTypes(BookWorkflowImpl.class);
//        // Activities are stateless and thread safe. So a shared instance is used.
//        worker.registerActivitiesImplementations(new BookingActivitiesImpl());
//        // Start listening to the workflow and activity task lists.
//        factory.start();
//
//        boolean test = true;
//        // Get a workflow stub using the same task list the worker uses.
//        BookWorkflow workflow = workflowClient.newWorkflowStub(BookWorkflow.class);
//        // Execute a workflow waiting for it to complete.
//        String greeting
//        = workflow.getBooking("đặt vé");
//        System.out.println(greeting);
////        Workflow.sleep(1000);
//
//        System.exit(0);
//    }
//    public static void deleteTicket(){
//        System.out.println("Do quá thời gian đợi nên hủy ghế");
//    }

}