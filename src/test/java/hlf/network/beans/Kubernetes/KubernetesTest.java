package hlf.network.beans.Kubernetes;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import io.kubernetes.client.openapi.models.V1ContainerStateWaiting;
import io.kubernetes.client.openapi.models.V1ContainerStatus;
import io.kubernetes.client.openapi.models.V1Deployment;
import io.kubernetes.client.openapi.models.V1Pod;
import io.kubernetes.client.openapi.models.V1Service;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;

@QuarkusTest
public class KubernetesTest {
    @Inject
    Kubernetes kubernetes;

    @Test
    public void getCorrectPortByPortLabelTest() throws StreamReadException, DatabindException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        V1Service service = objectMapper
                .readValue(new File("./src/main/java/hlf/network/beans/Kubernetes/v1ServiceMock.json"),
                        V1Service.class);
        String port = kubernetes.getCorrectPortByPortLabel("tcp", service.getSpec().getPorts());
        assertEquals(port, "80");
        service.getSpec().getPorts().get(0).setName("lul");
        port = kubernetes.getCorrectPortByPortLabel("tcp", service.getSpec().getPorts());
        assertEquals(port, "");
    }

    @Test
    public void checkIfDeploymentIsAliveTest() throws StreamReadException, DatabindException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        V1Deployment deployment = objectMapper
                .readValue(new File("./src/main/java/hlf/network/beans/Kubernetes/v1DeploymentMock.json"),
                        V1Deployment.class);
        boolean isAlive = kubernetes.checkIfDeploymentAlive(deployment.getStatus());
        assertEquals(isAlive, true);
        deployment.getStatus().setReadyReplicas(null);
        isAlive = kubernetes.checkIfDeploymentAlive(deployment.getStatus());
        assertEquals(isAlive, false);
        deployment.getStatus().setReadyReplicas(0);
        isAlive = kubernetes.checkIfDeploymentAlive(deployment.getStatus());
        assertEquals(isAlive, false);
    }

    @Test
    public void isTimeValidTest() throws StreamReadException, DatabindException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        V1Pod pod = objectMapper
                .readValue(new File("./src/main/java/hlf/network/beans/Kubernetes/v1PodMock.json"),
                        V1Pod.class);
        boolean isAlive = kubernetes.checkIfPodIsAlive(pod);
        assertEquals(isAlive, true);
        pod.getStatus().getContainerStatuses().get(0).setReady(false);
        isAlive = kubernetes.checkIfPodIsAlive(pod);
        assertEquals(isAlive, false);
    }
}
