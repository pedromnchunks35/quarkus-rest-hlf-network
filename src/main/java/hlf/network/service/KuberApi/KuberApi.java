package hlf.network.service.KuberApi;

import java.io.IOException;
import java.util.List;

import hlf.network.beans.Kubernetes.Kubernetes;
import io.kubernetes.client.openapi.ApiException;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import io.kubernetes.client.openapi.models.V1Deployment;
import io.kubernetes.client.openapi.models.V1Pod;
import io.kubernetes.client.openapi.models.V1Service;

@Path("/kuberapi")
public class KuberApi {
    @Inject
    Kubernetes kubernetes;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getKuberApi() throws IOException, ApiException {
        kubernetes.activeClient();
        List<V1Service> result = kubernetes.getServiceByLabels("type-component=peer", 0, 2);
        List<V1Pod> result2 = kubernetes.getPodsByLabels("", 0, 2);
        List<V1Deployment> result3 = kubernetes.getDeploymentsByLabels("type-component=peer", 0, 2);
        return Response.ok(result3.get(0).getStatus()).status(Response.Status.ACCEPTED)
                .build();
    }
}
