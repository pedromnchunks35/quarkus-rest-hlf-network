package hlf.network.dto;

import lombok.Data;

@Data
public class TransactionByOrgDTO {
    public TransactionByOrgDTO(String orgName, double percentage) {
        this.orgName = orgName;
        this.percentage = percentage;
    }

    private String orgName;
    private double percentage;
}
