package hlf.network.controller.Network.GET;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import hlf.network.beans.Kubernetes.Kubernetes;
import hlf.network.dto.PeerListDTO;
import hlf.network.dto.PeerListNetworkDTO;
import hlf.network.repository.NetworkRepository;
import io.kubernetes.client.openapi.models.V1Service;
import io.kubernetes.client.openapi.models.V1ServicePort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class NetworkControllerGET implements NetworkControllerInterfaceGET {

    @Inject
    Kubernetes kubernetes;
    @Inject
    NetworkRepository networkRepository;

    @Override
    public Response getNetworkComponentsList(int page, int size) {
        try {
            List<PeerListNetworkDTO> resultList = new ArrayList<>();
            List<V1Service> services = kubernetes.getServiceByLabels("type-component=peer", page, size);
            for (int i = 0; i < services.size(); i++) {
                V1Service service = services.get(i);
                Map<String, String> labels = service.getMetadata().getLabels();
                String name = service.getMetadata().getName();
                String msp = labels.get("msp");
                String type = "peer";
                List<V1ServicePort> ports = service.getSpec().getPorts();
                String port = kubernetes.getCorrectPortByPortLabel("tcp", ports);
                String ipAddress = service.getMetadata().getName() + (port.equals("") ? "" : ":" + port);
                boolean isAlive = kubernetes.checkIfDeploymentAliveByService(service);
                PeerListNetworkDTO result = networkRepository.getPeerListNetwork(name, ipAddress, type, msp, isAlive);
                resultList.add(result);
            }
            return Response.ok(resultList).status(Response.Status.OK).build();
        } catch (Exception e) {
            return Response.ok("Error with the api " + e.getMessage()).status(Response.Status.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @Override
    public Response getPeerList(int page, int size) {
        List<PeerListDTO> result = new ArrayList<>();
        try {
            List<V1Service> services = kubernetes.getServiceByLabels("type-component=peer", page, size);
            for (int i = 0; i < services.size(); i++) {
                String name = services.get(i).getMetadata().getName();
                List<V1ServicePort> ports = services.get(i).getSpec().getPorts();
                String port = kubernetes.getCorrectPortByPortLabel("tcp", ports);
                String ipAddress = services.get(i).getMetadata().getName() + (port.equals("") ? "" : ":" + port);
                boolean isAlive = kubernetes.checkIfDeploymentAliveByService(services.get(i));
                PeerListDTO newPeer = new PeerListDTO(name, ipAddress, isAlive);
                result.add(newPeer);
            }
        } catch (Exception e) {
            return Response.ok("Error with the api " + e.getMessage()).status(Response.Status.INTERNAL_SERVER_ERROR)
                    .build();
        }
        return Response.ok(result).status(Response.Status.OK).build();
    }

    @Override
    public Response getNumberOfNodes() {
        Integer result = 0;
        try {
            result = kubernetes.getServiceByLabels("type-component=peer", 0, 10000).size();
        } catch (Exception e) {
            return Response.ok("Error with the api").status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return Response.ok(result).status(Response.Status.OK).build();
    }

}
