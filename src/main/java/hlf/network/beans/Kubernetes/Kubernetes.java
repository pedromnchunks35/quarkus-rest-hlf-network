package hlf.network.beans.Kubernetes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.Configuration;
import io.kubernetes.client.openapi.apis.AppsV1Api;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1ContainerState;
import io.kubernetes.client.openapi.models.V1ContainerStateRunning;
import io.kubernetes.client.openapi.models.V1ContainerStateTerminated;
import io.kubernetes.client.openapi.models.V1ContainerStateWaiting;
import io.kubernetes.client.openapi.models.V1ContainerStatus;
import io.kubernetes.client.openapi.models.V1Deployment;
import io.kubernetes.client.openapi.models.V1DeploymentList;
import io.kubernetes.client.openapi.models.V1DeploymentStatus;
import io.kubernetes.client.openapi.models.V1Pod;
import io.kubernetes.client.openapi.models.V1PodList;
import io.kubernetes.client.openapi.models.V1Service;
import io.kubernetes.client.openapi.models.V1ServiceList;
import io.kubernetes.client.openapi.models.V1ServicePort;
import io.kubernetes.client.util.ClientBuilder;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Kubernetes {
    public void activeClient() throws IOException {
        ApiClient client = ClientBuilder.cluster().build();
        Configuration.setDefaultApiClient(client);
    }

    /**
     * @param labels, labels separed by comma ex:
     *                type-component=peer,ledger=orgx-couch-peer1
     * @throws ApiException
     */
    public List<V1Service> getServiceByLabels(String labels, int page, int size) throws ApiException {
        CoreV1Api api = new CoreV1Api();
        String continueToken = null;
        List<V1Service> result = new ArrayList<>();
        for (int i = 0; i < page + 1; i++) {
            V1ServiceList list = api.listServiceForAllNamespaces(
                    null,
                    continueToken,
                    null,
                    labels,
                    size,
                    null,
                    null,
                    null,
                    null,
                    null);
            List<V1Service> items = list.getItems();
            if (i == page) {
                result = items;
                break;
            }
            continueToken = list.getMetadata().getContinue();
            if (continueToken == null || continueToken.isEmpty()) {
                break;
            }
        }
        return result;
    }

    /**
     * @param labels, given labels to make the search
     * @param page,   the number of the page we want to see
     * @param size,   the size of the members in it
     * @return
     * @throws ApiException
     */
    public List<V1Pod> getPodsByLabels(String labels, int page, int size) throws ApiException {
        CoreV1Api api = new CoreV1Api();
        String continueToken = null;
        List<V1Pod> result = new ArrayList<>();
        for (int i = 0; i < page + 1; i++) {
            V1PodList list = api.listPodForAllNamespaces(
                    null,
                    continueToken,
                    null,
                    labels,
                    size,
                    null,
                    null,
                    null,
                    null,
                    null);
            List<V1Pod> items = list.getItems();
            if (i == page) {
                result = items;
                break;
            }
            continueToken = list.getMetadata().getContinue();
            if (continueToken == null || continueToken.isEmpty()) {
                break;
            }
        }
        return result;
    }

    /**
     * @param labels, given labels to make the search
     * @param page,   the number of the page we want to see
     * @param size,   the size of the members in it
     * @return
     * @throws ApiException
     */
    public List<V1Deployment> getDeploymentsByLabels(String labels, int page, int size) throws ApiException {
        AppsV1Api api = new AppsV1Api();
        String continueToken = null;
        List<V1Deployment> result = new ArrayList<>();
        for (int i = 0; i < page + 1; i++) {
            V1DeploymentList list = api.listDeploymentForAllNamespaces(
                    null,
                    continueToken,
                    null,
                    labels,
                    size,
                    null,
                    null,
                    null,
                    null,
                    null);
            List<V1Deployment> items = list.getItems();
            if (i == page) {
                result = items;
                break;
            }
            continueToken = list.getMetadata().getContinue();
            if (continueToken == null || continueToken.isEmpty()) {
                break;
            }
        }
        return result;
    }

    /**
     * @param portLabel, the name of the port that we wish to return
     * @param ports,     the ports that the service has
     * @return
     */
    public String getCorrectPortByPortLabel(String portLabel, List<V1ServicePort> ports) {
        String port = "";
        for (int i = 0; i < ports.size(); i++) {
            if (ports.get(i).getName().equals(portLabel)) {
                port = ports.get(i).getPort().toString();
                break;
            }
        }
        return port;
    }

    /**
     * @param service, the given service returned
     * @return
     * @throws ApiException
     */
    public boolean checkIfDeploymentAliveByService(V1Service service) throws ApiException {
        String componentName = service.getMetadata().getLabels().get("name-component");
        List<V1Deployment> deployment = getDeploymentsByLabels("name-component=" + componentName, 0, 1);
        return checkIfDeploymentAlive(deployment.get(0).getStatus());
    }

    /**
     * @param status, the status object
     * @return
     */
    public boolean checkIfDeploymentAlive(V1DeploymentStatus status) {
        return (status.getReadyReplicas() == null || status.getReadyReplicas() == 0) ? false : true;
    }

    /**
     * @param pod
     * @return
     */
    public boolean checkIfPodIsAlive(V1Pod pod) {
        boolean allGood = true;
        List<V1ContainerStatus> containersState = pod.getStatus().getContainerStatuses();
        for (int i = 0; i < containersState.size(); i++) {
            V1ContainerStatus singleContainerStatus = containersState.get(i);
            allGood = singleContainerStatus.getReady();
            if (allGood == false) {
                return allGood;
            }
            /**
             * V1ContainerState state = singleContainerStatus.getState();
             * V1ContainerStateWaiting waiting = state.getWaiting();
             * V1ContainerStateRunning running = state.getRunning();
             * V1ContainerStateTerminated terminated = state.getTerminated();
             * allGood = isTimeValid(waiting, running, terminated);
             **/

        }
        return allGood;
    }

    /**
     * @deprecated, unfortunely we did not see the method .getReady(), which already
     * does this logic for us :(
     * 
     * @param waiting,    waiting state container
     * @param running,    waiting state running
     * @param terminated, waiting state terminated
     * @return
     */
    public boolean isTimeValid(V1ContainerStateWaiting waiting, V1ContainerStateRunning running,
            V1ContainerStateTerminated terminated) {
        if (running.getStartedAt() == null) {
            return false;
        }
        if (terminated != null &&
                ((terminated.getStartedAt() != null && terminated.getStartedAt().isAfter(running.getStartedAt()))
                        ||
                        (terminated.getFinishedAt() != null
                                && terminated.getFinishedAt().isAfter(running.getStartedAt())))) {
            return false;
        }
        if (waiting != null) {
            return false;
        }
        return true;
    }
}