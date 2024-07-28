package hlf.network.repository;

import hlf.network.dto.PeerListNetworkDTO;
import hlf.network.entity.Network;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class NetworkRepository implements PanacheRepositoryBase<Network, Integer> {
        @Inject
        EntityManager entityManager;

        /**
         * @param name,          name of the component
         * @param ipAddress,     ip address of the component
         * @param typeComponent, type of the component
         * @param msp,           the msp of the component
         * @param isAlive,       if it is alive or not
         * @return
         */
        public PeerListNetworkDTO getPeerListNetwork(String name, String ipAddress, String typeComponent, String msp,
                        boolean isAlive) {
                String query = "SELECT new hlf.network.dto.PeerListNetworkDTO(COUNT(T),COUNT(CH)) "
                                +
                                "FROM Transaction T " +
                                "LEFT JOIN T.creator C " +
                                "LEFT JOIN T.operation O " +
                                "LEFT JOIN O.chaincode CH " +
                                "WHERE C.mspId=:msp " +
                                "GROUP BY C.mspId";
                PeerListNetworkDTO result = entityManager.createQuery(query, PeerListNetworkDTO.class)
                                .setParameter("msp", msp)
                                .getSingleResult();
                if (result == null) {
                        result = new PeerListNetworkDTO(Long.valueOf(0), Long.valueOf(0));
                }
                result.setAlive(isAlive);
                result.setIpAddress(ipAddress);
                result.setMsp(msp);
                result.setName(name);
                result.setTypeComponent(typeComponent);
                return result;
        }
}
